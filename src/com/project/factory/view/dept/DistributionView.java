package com.project.factory.view.dept;

import com.project.factory.Today;
import com.project.factory.dept.distribution.admin.EmployeeInfo;
import com.project.factory.member.Identify;
import com.project.factory.resource.dept.DistributionData;

public class DistributionView {


		public static String assignRegion;

		public static void DistributionMemberView(){
			DistributionData.load();

			System.out.println(Today.day());

	        for (EmployeeInfo employeeInfo :DistributionData.distributionMembersList ) {
	        	if(employeeInfo.getId().equals(Identify.auth)) {
	            	System.out.printf("[%s 님 - %s]",Identify.name, employeeInfo.getAssignedRegion());
	            	
	        	}
	        }

	        System.out.printf("오늘 배정받은 개수");
	  


		
	}
}
