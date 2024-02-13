package com.project.factory.dept.distribution.user;

import java.util.InputMismatchException;

import java.util.Scanner;

import com.project.factory.member.Identify;
import com.project.factory.resource.dept.AssignData;

import com.project.factory.view.MainView;
import com.project.factory.view.dept.DistributionView;

/** 배정된 주문서를 확인하고 유통 기능을 하는 클래스이다. 
 * 
 */
public class CheckDest {

	public static String selectNum;
	public static int count;
	
	


	/** 배송지를 조회하고 유통을 완료하는 메서드이다.
	 * 
	 */
	public static void checkDest() {
		AssignData.load();
	
		MainView.title("배송지 조회 및 유통");

		boolean hasOrders = false;

		for (Assign assignOrder : AssignData.assignList) {
			if (assignOrder.getUserId().equals(Identify.auth)) {
				hasOrders = true;
				count++;
				break;
			}
		}
		
		

		if (!hasOrders) {
			System.out.println();
			System.out.println("오늘 배정받은 배송지가 없습니다.");
			System.out.println();
			MainView.singleLine();
			MainView.pause();
			return;
		}
		
		for (Assign assignOrder : AssignData.assignList) {
			if(assignOrder.getUserId().equals(Identify.auth)) {
				if(count == DistributionView.completeOrderCount ) {
					
					System.out.println();
					System.out.println("배송을 모두 완료했습니다.");
					System.out.println();
					MainView.singleLine();
					MainView.pause();
					return;
				}
			}
		}

		printOrder();
		
		System.out.println();
		MainView.singleLine();
		
		insertListNum();

		deleteOrder(selectNum);

		MainView.pause();
	}

	/** 해당 작업을 계속 진행할지를 선택 받는 메서드이다.
	 * 
	 */
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
	
	/** 배송이 완료된 주문서를 선택하고 선택한 주문서의 유통을 완료하는 메서드이다.
	 * 
	 */

	private static void insertListNum() {
		boolean validInput = false;

		while (!validInput) {
			System.out.println("배송이 완료된 주문서 번호를 입력해주세요");
			System.out.print("번호 입력: ");

			Scanner scan = new Scanner(System.in);

			try {
				selectNum = scan.nextLine();

				boolean found = false;

				for (Assign assignOrder : AssignData.assignList) {
					if (assignOrder.getId().equals(selectNum) && assignOrder.getUserId().equals(Identify.auth)) {
						System.out.println();
						System.out.printf("%s번 주문서 배송 완료되었습니다.", assignOrder.getId());
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

	/** 유통을 완료한 주문서의 상태를 미완료에서 완료로 변경하는 메서드이다.
	 * 
	 * @param selectNum 유통을 완료한 주문서 번호
	 */
	private static void deleteOrder(String selectNum) {
		for (Assign assignOrder : AssignData.assignList) {
			if (assignOrder.getId().equals(selectNum)) {
				// 주문 번호와 일치하는 주문을 리스트에서 삭제
				assignOrder.setState("완료");
				// 파일에 변경된 주문 목록 저장
				
				AssignData.save(); // 주문 상태가 변경됐으니 저장 필요
				break;
			}
		}
	}

	private static void printOrder() {

		
		System.out.println();

		System.out.printf("%-8s\t%-6s\t%-10s\t%-8s\t%-5s\t%-5s\n","[주문서 번호]","[구역]","[대리점명]","[모델명]","[수량]","[상태]");
		for (Assign assignOrder : AssignData.assignList) {
			if (assignOrder.getUserId().equals(Identify.auth)) {
				System.out.printf("%-8s\t%-6s\t%-10s\t%-8s\t%-5s\t%-5s\n", assignOrder.getId(), assignOrder.getArea(),

                        assignOrder.getAgencyName(), assignOrder.getModelId(), assignOrder.getQuantity(),assignOrder.getState());

			}

		}

	}

}
