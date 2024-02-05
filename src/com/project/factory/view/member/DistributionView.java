package com.project.factory.view.member;

import com.project.factory.Today;
import com.project.factory.dept.distribution.admin.EmployeeInfo;
import com.project.factory.member.Identify;
import com.project.factory.resource.dept.DistributionData;

public class DistributionView {
	
	public static String assignRegion;

	public static void DistributionMemberView(){
		
		DistributionData.load();
		
        for (EmployeeInfo employeeInfo :DistributionData.distributionMembersList ) {
            if(employeeInfo.getId().equals(Identify.name)) {
            	assignRegion = employeeInfo.getAssignedRegion();
            }
        }
        
        System.out.println(Today.day());
		System.out.printf("[%s 님 - %s]",Identify.name, assignRegion);
		
		
	}
}
