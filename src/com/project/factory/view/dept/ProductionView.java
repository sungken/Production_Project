package com.project.factory.view.dept;

import java.util.Set;

import com.project.factory.dept.production.admin.ProductionManagement;
import com.project.factory.dept.production.admin.resource.ModelInventory;
import com.project.factory.dept.production.admin.resource.ModelInventoryData;
import com.project.factory.dept.production.admin.resource.ProductionTarget;
import com.project.factory.view.MainView;

public class ProductionView {
	
	

	public static void viewModelInven() {
		int count = 1;
		Set<String> keySet = ProductionTarget.TargetNum.keySet();
		for (String model : keySet) {
			System.out.println(count + ". " + model + ": " + ProductionTarget.TargetNum.get(model) + "대");
			count++;
		}
		System.out.println();
		MainView.doubleLine();
		System.out.println();
	}
	
	public static void viewproductionMenu() {
		MainView.doubleLine();
		System.out.println();
		System.out.println("1. 생산 시작");
		System.out.println("2. 생산 정지");
		System.out.println("3. 생산 종료");
		System.out.println();
		MainView.doubleLine();
	}
	
	public static void viewCurrentProduct() {
		for (ModelInventory modelInventory : ModelInventoryData.modelInventoryList) {
			System.out.printf("%s : %d대\n", modelInventory.getModelName(), modelInventory.getModelInventory());
		}
	}
	
	public static void viewPoductionView() {
		MainView.doubleLine();
		System.out.println();
		System.out.printf("총 생산량 %d대\n");
		System.out.printf("불량품 개수 : %d대");
		System.out.println("재고량 : ");
		System.out.println();
		MainView.doubleLine();
	}
	public static void viewModel() {
		MainView.doubleLine();
		System.out.println();
		System.out.println("모델별 불량품 개수를 입력해주세요");
		int count = 1;
		for (ModelInventory modelInventory : ModelInventoryData.modelInventoryList) {
			System.out.printf("%d. %s \n", count, modelInventory.getModelName());
			count++;
		}
		System.out.println();
		MainView.doubleLine();
	}


}
