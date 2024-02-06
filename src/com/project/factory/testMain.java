package com.project.factory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.project.factory.resource.Data;
import com.project.factory.resource.Members;
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
		
		
		for(Order order : OrderData.orderList) {
			for(Members member : Data.memberList) {
				if(order.getAgencyName().equals(member.getName())) {
					member.getArea(member.getDept());
				}
				System.out.println(member.getArea(member.getDept()));
			}
		}
	}}
	
//		OrderAssign.addOrderListAddDrliveryMember();
		 


