package com.project.factory.resource.dept;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import com.project.factory.dept.distribution.user.Assign;
import com.project.factory.dept.distribution.user.AssignOrder;
import com.project.factory.resource.Path;

public class AssignList {
	
	
	public static ArrayList<AssignOrder> assignOrderList = new ArrayList<AssignOrder>();
	public static int orderCount;

	public static void load() {
	    try {
	    	assignOrderList.clear(); // 기존 데이터 초기화

	        BufferedReader reader = new BufferedReader(new FileReader(Path.CHECKASSIGNORDER));

	        String line = null;
	        while ((line = reader.readLine()) != null) {
	        	//System.out.println("[주문서 번호]\t[구역]\t[대리점명]\t[모델명]\t[수량]\t[상태]");
	            String[] temp = line.split("■");
	            AssignOrder assignCheckOrder = new AssignOrder(
	                    temp[0],        // 주문서 번호
	                    temp[1],        // 주문서 작성일
	                    temp[2],        // 대리점명
	                    temp[3],        // 대리점 주소
	                    Integer.parseInt(temp[4]),        // 전화번호
	                    temp[5], // 개수 (정수로 변환)
	                    temp[6]
	                   


	            );
	            assignOrderList.add(assignCheckOrder);
	        }

	        reader.close();

	    } catch (Exception e) {
	        System.out.println("AssignData.load");
	        e.printStackTrace();
	    }
	}

	
    public static int getOrderCountByMemberId(String memberId) {


        for (AssignOrder assignCheckOrder : AssignList.assignOrderList) {
            if (assignCheckOrder.getUserId().equals(memberId)) {
                orderCount++;
              
            }
        }
        
        return orderCount;

        
    }
    
    
    public static int getCompletedOrderCountByMemberId(String memberId) {
        int completedOrderCount = 0;

        for (AssignOrder assignCheckOrder : AssignList.assignOrderList) {
            if (assignCheckOrder.getUserId().equals(memberId) && assignCheckOrder.getState().equals("완료")) {
                completedOrderCount++;
            }
        }

        return completedOrderCount;
    }
	
	public static void save() {

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(Path.ASSIGNORDER));

			for (AssignOrder assignCheckOrder : AssignList.assignOrderList) {
				//System.out.println("[주문서 번호]\t[구역]\t[대리점명]\t[모델명]\t[수량]\t[상태]");
				String line = String.format("%s■%s■%s■%s■%d■%s■%s\r\n",
						assignCheckOrder.getOrderId(),
						assignCheckOrder.getArea(), assignCheckOrder.getAgencyName(),
						assignCheckOrder.getModelId(),assignCheckOrder.getQuantity(),
						assignCheckOrder.getState(),assignCheckOrder.getUserId());

				writer.write(line);

			}

			writer.close();

		} catch (Exception e) {
			System.out.println("AssignList.save");
			e.printStackTrace();
		}

	}// save

}
