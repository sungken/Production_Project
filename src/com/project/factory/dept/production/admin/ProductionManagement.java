package com.project.factory.dept.production.admin;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import com.project.factory.dept.production.admin.resource.ModelInventory;
import com.project.factory.dept.production.admin.resource.ModelInventoryData;
import com.project.factory.dept.production.admin.resource.ProductionTarget;
import com.project.factory.dept.production.admin.resource.TodayInventoryData;
import com.project.factory.dept.production.admin.resource.TodayProduction;
import com.project.factory.dept.production.admin.resource.TodayProductionData;
import com.project.factory.view.MainView;
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
			product.setstatusproduction(true);
			product.start();
			MainView.pause();
		} else if (sel == 2) {
			product.setstatusproduction(false);
			MainView.pause();
		} else if (sel == 3) {
			stopproduction();
		} else {
			System.out.println("잘못된입력");
		}
	}


	private static void stopproduction() {
		Scanner sc = new Scanner(System.in);
		ProductionManagement.setRejectproduct();
		boolean loop = true;
		//불량품 개수
		
		// 생산 정지 하루 재고 -> 재고량
		
		
		// 하루 목표량 -> 0
		for (String key : ProductionTarget.TargetNum.keySet()) {
			ProductionTarget.TargetNum.put(key, 0);

		}
	}

	private static void setRejectproduct() {
		// 불량품 개수 입력
		ProductionView.viewModel();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("번호 선택: ");
			int sel = sc.nextInt();
			System.out.printf("%d %s: ", sel, ModelInventoryData.modelInventoryList.get(sel));
			int num = sc.nextInt();
			
		}

	}

}

//생산시작 쓰레드
class ProductStart extends Thread {

	
	private boolean statusproduction = true;
	
	public void setstatusproduction(boolean statusproduction) {
		this.statusproduction = statusproduction;
	}
	

	public void run() {
		int count = 0;
		System.out.println("생산을 시작합니다.");
		while (statusproduction) {
			try {
				for (ModelInventory modelInventory : ModelInventoryData.modelInventoryList) {
					modelInventory.setModelInventory(count);
				}
				count += 5;
				Thread.sleep(10000);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("쓰레드 중지");

	}




	

	
}
