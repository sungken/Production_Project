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
				
				String[] temp = line.split("■");
				Assign assignOrder = new Assign(
					    Integer.parseInt(temp[0]),   // 주문서 번호 (정수)
					    temp[1],                     // 지역
					    temp[2],                     // 대리점명
					    temp[3],                     // 모델명
					    Integer.parseInt(temp[4]),                     // 수량
					    temp[5],                     // 이름
					    temp[6]);
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
			BufferedWriter writer = new BufferedWriter(new FileWriter(Path.ASSIGNORDER));

			for (Assign assignOrder : AssignData.assignList) {

				String line = String.format("%d■%s■%s■%s■%d■%s■%s\r\n", assignOrder.getNum(),
						assignOrder.getAssignRegion(), assignOrder.getAgencyName(),
						assignOrder.getModelId(), assignOrder.getQuantity(), assignOrder.getModelId(),
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
