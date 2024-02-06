package com.project.factory.dept.distribution.user;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.project.factory.member.Identify;
import com.project.factory.resource.dept.AssignData;
import com.project.factory.resource.dept.AssignList;
import com.project.factory.view.MainView;

public class CheckDest {

	public static String selectNum;

	public static void checkDest() {
		//AssignData.load();
		AssignList.load();

		boolean hasOrders = false;

		for (Assign assignOrder : AssignData.assignList) {
			if (assignOrder.getUserId().equals(Identify.auth)) {
				hasOrders = true;
				break;
			}
		}

		if (!hasOrders) {
			MainView.doubleLine();
			System.out.println();
			System.out.println("오늘 배정받은 배송지가 없습니다.");
			System.out.println();
			MainView.doubleLine();
			MainView.pause();
			return;
		}

		printOrder();
		
		System.out.println();
		MainView.singnleLine();
		System.out.println();
		
		insertListNum();



		deleteOrder(selectNum);

		MainView.pause();
	}

	private static void checkContinue() {
		boolean continuePrompt = true;

		while (continuePrompt) {
			System.out.println();
			System.out.print("계속 진행하시겠습니까?(Y/N)\n");
			System.out.print("입력: ");

			Scanner Scanner = new Scanner(System.in);
			String answer = Scanner.nextLine().toLowerCase();

			if (answer.equals("y")) {
				System.out.println();
				insertListNum();
			} else if (answer.equals("n")) {
				continuePrompt = false; 
			} else {
				System.out.println("올바른 입력이 아닙니다. 다시 시도해주세요.");
				continuePrompt = false;
			}
		}
	}

	private static void insertListNum() {
		boolean validInput = false;

		while (!validInput) {
			System.out.println("배송이 완료된 주문서 번호를 입력해주세요");
			System.out.print("번호 입력: ");

			Scanner scan = new Scanner(System.in);

			try {
				selectNum = scan.nextLine();

				boolean found = false;

				for (AssignOrder assignCheckOrder : AssignList.assignOrderList) {
					if (assignCheckOrder.getOrderId().equals(selectNum) && assignCheckOrder.getUserId().equals(Identify.auth)) {
						System.out.println();
						System.out.printf("%s번 주문서 배송 완료되었습니다.", assignCheckOrder.getOrderId());
						System.out.println();
						found = true;
						validInput = true; 
						break;
					}
				}

				if (!found) {
					System.out.println();
					System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
					System.out.println();
					validInput = true; 
					checkContinue();
				}

			} catch (InputMismatchException e) {
				System.out.println();
				System.out.println("숫자를 입력해주세요. 다시 시도해주세요.");
				System.out.println();
				validInput = true; 
				checkContinue();
			}
		}
	}

	private static void deleteOrder(String selectNum) {
		for (AssignOrder assignCheckOrder : AssignList.assignOrderList) {
			if (assignCheckOrder.getOrderId().equals(selectNum)) {
				// 주문 번호와 일치하는 주문을 리스트에서 삭제
				assignCheckOrder.setState("완료");
				// 파일에 변경된 주문 목록 저장
				
				AssignData.save(); // 주문 상태가 변경됐으니 저장 필요
				break;
			}
		}
	}

	private static void printOrder() {

		MainView.doubleLine();
		System.out.println();

		System.out.println("[주문서 번호]\t[구역]\t[대리점명]\t[모델명]\t[수량]\t[상태]");
		for (AssignOrder assignCheckOrder : AssignList.assignOrderList) {
			if (assignCheckOrder.getUserId().equals(Identify.auth)) {
				System.out.printf("%s\t%s\t%s\t%s\t\t%d\t%s\n", assignCheckOrder.getOrderId(), assignCheckOrder.getArea(),
						assignCheckOrder.getAgencyName(), assignCheckOrder.getModelId(), assignCheckOrder.getQuantity(),assignCheckOrder.getState());
			}

		}

	}

}
