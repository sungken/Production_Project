package com.project.factory.dept.production.admin;

import java.util.Scanner;

import com.project.factory.dept.production.admin.resource.ModelInventory;
import com.project.factory.dept.production.admin.resource.ModelInventoryData;
import com.project.factory.dept.production.admin.resource.ProductionTarget;
import com.project.factory.view.dept.ProductionView;

//TODO productionManagement 클래스명 오타 수정
public class ProductionManagement {
	 static // 생산관리
	ProductStart product = new ProductStart();
	

	public static void productionSelect() {
		Scanner sc = new Scanner(System.in);
		ProductionView.viewproductionMenu();
		System.out.print("생산 입력: ");
		int sel = sc.nextInt();

		if (sel == 1) {
			try {
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (sel == 2) {
			pauseproduction();
		} else if (sel == 3) {
			stopproduction();
		} else {
			System.out.println("잘못된입력");
		}
	}

	private static void pauseproduction() {
		// 생산 일시중지

	}

	private static void stopproduction() {
		// 생산 정지 하루 재고 -> 재고량
		// 하루 목표량 -> 0
		product.stop();
		ProductionTarget.save_target();
		for (String key : ProductionTarget.TargetNum.keySet()) {
			ProductionTarget.TargetNum.put(key, 0);

		}
	}

	private void setRejectproduct() {
		// 불량품 개수 입력
	}

}

class ProductStart extends Thread {

	public void run() {
		int count = 0;
		System.out.println("시작");
		boolean statusproduction = true;
		while (statusproduction) {
			try {
				for (ModelInventory modelInventory : ModelInventoryData.modelInventoryList) {
					modelInventory.setModelInventory(count);
					System.out.println(modelInventory.getModelName() + " : " + modelInventory.getModelInventory());

				}
				count += 5;
				Thread.sleep(1000);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
