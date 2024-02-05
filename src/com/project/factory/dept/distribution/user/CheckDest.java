package com.project.factory.dept.distribution.user;

import com.project.factory.member.Identify;
import com.project.factory.resource.dept.AssignData;
import com.project.factory.resource.sub.Order;
import com.project.factory.resource.sub.OrderData;
import com.project.factory.view.MainView;

public class CheckDest {
	

	public static void checkDest() {
		AssignData.load();
		
		//주문서번호■주문서 작성일■대리점명■대리점 주소■전화번호■개수■납기일■모델명
		
		printOrder();
		
		
		
	}

	private static void printOrder() {
		
		MainView.doubleLine();
		System.out.println();
		
		
		for(Assign assignOrder : AssignData.assignList) {
			if(assignOrder.getMemberId().equals(Identify.auth)) {
				System.out.println("[번호]\t[구역]\t[대리점명]\t[모델명]\t[수량]");
				System.out.printf("%d\t%s\t%s\t%s\t%d\n"
														,assignOrder.getNum()
														,assignOrder.getAssignOrder()
														,assignOrder.getAgencyName()
														,assignOrder.getModelId()
														,assignOrder.getQuantity());
			}
			
			
			
		}
		
	}
	
	
	
}
