package com.project.factory.resource.dept;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.project.factory.dept.distribution.user.Assign;
import com.project.factory.resource.Path;
import com.project.factory.resource.sub.Order;
import com.project.factory.resource.sub.OrderData;

public class AssignData {

	public static ArrayList<Assign> assignList = new ArrayList<Assign>();

	public static void load() {

		try {

			assignList.clear(); // 기존 데이터 초기화

			BufferedReader reader = new BufferedReader(new FileReader(Path.ASSIGNORDER));

			String line = null;
			while ((line = reader.readLine()) != null) {
				//                						 1■           경기도■        452721■    2024-01-31■        강남1호점■  서울특별시 강남구 테헤란로 132■010-1234-4567■       30■        2024-02-05■      k3■           정희현■           ffff
				//						public Assign(int num, String assignOrder, String id, String writeDate, String agencyName, String agencyAddress, String agencyPhoneNum, int quantity, String dueDate, String modelId, String name, String memberId)
				String[] temp = line.split("■");
				Assign assignOrder = new Assign(
					    Integer.parseInt(temp[0]),   // 주문서 번호 (정수)
					    temp[1],                     // 지역
					    temp[2],                     // 대리점 코드
					    temp[3],                     // 작성일
					    temp[4],                     // 대리점명
					    temp[5],                     // 대리점 주소
					    temp[6],                     // 전화번호 (문자열)
					    Integer.parseInt(temp[7]),   // 수량 (정수)
					    temp[8],                     // 납기일
					    temp[9],                     // 모델명
					    temp[10],                    // 사원명
					    temp[11]                     // 사원번호
					);
				assignList.add(assignOrder);

			}

			reader.close();

		} catch (Exception e) {
			System.out.println("AssignData.load");
			e.printStackTrace();
		}

	}// load

	public static void save() {

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(Path.ORDER));

			for (Assign assignOrder : AssignData.assignList) {

				String line = String.format("%s■%s■%s■%s■%s■%d■%s■%s■%s■%s\r\n", assignOrder.getId(),
						assignOrder.getWriteDate(), assignOrder.getAgencyName(), assignOrder.getAgencyAddress(),
						assignOrder.getAgencyPhoneNum(), assignOrder.getQuantity(), assignOrder.getModelId(),
						assignOrder.getName(), assignOrder.getMemberId());

				writer.write(line);

			}

			writer.close();

		} catch (Exception e) {
			System.out.println("AssignData.save");
			e.printStackTrace();
		}

	}// save

}
