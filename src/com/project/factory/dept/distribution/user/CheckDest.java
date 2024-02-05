package com.project.factory.dept.distribution.user;

import java.util.Scanner;

import com.project.factory.member.Identify;
import com.project.factory.resource.dept.AssignData;
import com.project.factory.view.MainView;

public class CheckDest {
	

	public static void checkDest() {
	    AssignData.load();

	    boolean hasOrders = false;

	    for (Assign assignOrder : AssignData.assignList) {
	        if (assignOrder.getMemberId().equals(Identify.auth)) {
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
	    System.out.println("배송이 완료된 리스트 번호를 입력해주세요");
	    System.out.print("번호 입력: ");

	    Scanner scan = new Scanner(System.in);

	    int selectNum = scan.nextInt();

	    boolean found = false;

	    for (Assign assignOrder : AssignData.assignList) {
	        if (assignOrder.getNum() == selectNum && assignOrder.getMemberId().equals(Identify.auth)) {
	            System.out.println();
	            System.out.printf("%d번 배송 완료되었습니다.", assignOrder.getNum());
	            found = true;
	            break;
	        }
	    }

	    if (!found) {
	        // 번호를 잘못 입력했거나 해당 사용자 아이디에 해당하는 주문이 없을 경우의 처리
	        System.out.println("잘못된 번호를 입력했거나 해당 사용자 아이디에 해당하는 주문이 없습니다.");
	    } else {
	        deleteOrder(selectNum);
	    }

	    System.out.println();
	    MainView.pause();
	}

	    
		
		
	 private static void deleteOrder(int selectNum) {
	        for (Assign assignOrder : AssignData.assignList) {
	            if (assignOrder.getNum() == selectNum) {
	                // 주문 번호와 일치하는 주문을 리스트에서 삭제
	                AssignData.assignList.remove(assignOrder);
	                // 파일에 변경된 주문 목록 저장
	                AssignData.save();
	                break;
	            }
	        }
	    }





	private static void printOrder() {
		
		MainView.doubleLine();
		System.out.println();
		
		
		for(Assign assignOrder : AssignData.assignList) {
			if(assignOrder.getMemberId().equals(Identify.auth)) {
				System.out.println("[번호]\t[구역]\t[대리점명]\t[모델명]\t[수량]");
				System.out.printf("%d\t%s\t%s\t%s\t\t%d\n"
														,assignOrder.getNum()
														,assignOrder.getAssignRegion()
														,assignOrder.getAgencyName()
														,assignOrder.getModelId()
														,assignOrder.getQuantity());
			}
			
			
			
		}
		
	}
	
	
	
}
