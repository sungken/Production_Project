package com.project.factory.resource.sub;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import com.project.factory.resource.Path;

public class DeliveryOrderData {
	public static ArrayList<Delivery> deliveryList = new ArrayList<Delivery>();

	public static void load() {
		
		
		try {
			deliveryList.clear(); // 기존 데이터 초기화
			BufferedReader reader = new BufferedReader(new FileReader("data\\deliveryMemberAdduserRegion.txt"));
			
			String line = null;
			while ((line = reader.readLine()) != null) {
				//출근날짜■id■이름■생년월일■부서■직급■출근시간■출퇴근■지역
				String[] temp = line.split("■");

				Delivery deliveryItem = new Delivery(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8]);

				deliveryList.add(deliveryItem);
				
			}
			reader.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("예외 DeliveryOrderData");
			e.printStackTrace();
		}
		
	}
	
}// DeliveryOrderData
