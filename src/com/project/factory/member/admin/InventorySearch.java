package com.project.factory.member.admin;

import com.project.factory.dept.production.admin.resource.ModelInventory;
import com.project.factory.dept.production.admin.resource.ModelInventoryData;
import com.project.factory.view.MainView;
import com.project.factory.view.dept.ProductionView;

public class InventorySearch {
	//재고확인
	public static void checkInventory() {
		MainView.doubleLine();
		System.out.println();
		ProductionView.viewCurrentProduct();
		System.out.println();
		MainView.doubleLine();
		MainView.pause();
	}
	
	
	
	
}
