package com.project.factory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.project.factory.resource.Data;
import com.project.factory.resource.Members;
import com.project.factory.resource.sub.Delivery;
import com.project.factory.resource.sub.DeliveryOrderData;
import com.project.factory.resource.sub.Order;
import com.project.factory.resource.sub.OrderData;

public class testMain {

	public static void main(String[] args) {
		
		
//		OrderAssign.checkOrder();
//		OrderAssign.modifyAssign();
//		OrderAssign.orderView();
		
//		LocalDate now = LocalDate.now();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd");
//		String time = now.format(formatter);
//		System.out.println(time);
		
//		OrderData.load();
//		Data.load();
//		
//		for (Order order : OrderData.orderList) {
//			for (Members member : Data.memberList) {
//				if (order.getAgencyName().equals(member.getName())) {//주문서의 대리점 이름과 일치하는 멤버 정보를 불러올 수 있게 됨
//					System.out.println(order.getAgencyName());
//					System.out.println(member.getName());
//					System.out.println(member.getDept());
//					member.getArea(member.getDept());//dept : 1-17
//					System.out.println(member.getArea(member.getDept()));
//					System.out.println();
//				}
//			}
//		}
		
//		}
		DeliveryOrderData.load();
		for(Delivery delivery : DeliveryOrderData.deliveryList) {
			System.out.println();
		}
		
		
	}
}

	
	
//		OrderAssign.addOrderListAddDrliveryMember();
		 


