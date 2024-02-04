package com.project.factory.member.admin;

import com.project.factory.dept.production.admin.resource.ModelInfo;
import com.project.factory.dept.production.admin.resource.ModelInfoData;
import com.project.factory.view.MainView;
import com.project.factory.view.dept.ProductionView;

public class InventorySearch {
	// 재고확인
	public static void checkInventory() {
		MainView.doubleLine();
		System.out.println();
		for (ModelInfo modelInventory : ModelInfoData.modelInfoList) {
			System.out.printf("%s : %d대\n", modelInventory.getModelName(), modelInventory.getModelInventory());
		}
		System.out.println();
		MainView.doubleLine();
		MainView.pause();
	}
	

}
