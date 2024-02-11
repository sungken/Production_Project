package com.project.factory.resource.dept;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import com.project.factory.dept.distribution.admin.EmployeeInfo;
import com.project.factory.resource.Path;

/** 유통부 사원의 데이터를 관리하는 클래스이다.
 * 
 */
public class DistributionData {
	
	/** 유통부 사원 목록
	 * 
	 */
	public static ArrayList<EmployeeInfo> distributionMembersList = new ArrayList<>();
	
	/** 파일에서 유통부 사원 데이터를 로드하는 메서드이다.
	 * 
	 */
	public static void load() {
        try {
        	distributionMembersList.clear();

            BufferedReader reader = new BufferedReader(new FileReader(Path.USERREGION));

            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] temp = line.split("■");

                	
                EmployeeInfo employeeInfo = new EmployeeInfo(temp[0], temp[1], temp[2], temp[3]);
                distributionMembersList.add(employeeInfo);
               
            }

            reader.close();
        } catch (Exception e) {
 
            e.printStackTrace();
        }
		
	}
}
