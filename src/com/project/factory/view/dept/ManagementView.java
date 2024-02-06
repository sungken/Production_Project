package com.project.factory.view.dept;

import com.project.factory.member.Identify;
import com.project.factory.resource.CommuteData;

public class ManagementView {

	public static void managementAdminView() {
		
		CommuteData.load();
		
		HumanView.countMembersBySpecificDept(Identify.dept);
		
	}

}
