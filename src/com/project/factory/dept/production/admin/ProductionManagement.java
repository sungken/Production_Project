package com.project.factory.dept.production.admin;

import java.util.Scanner;

import com.project.factory.dept.production.admin.resource.ModelInfo;
import com.project.factory.dept.production.admin.resource.ModelInfoData;
import com.project.factory.dept.production.admin.resource.ProductionTarget;
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
			product.start();
			product.setstatusproduction(true);
			
			MainView.pause();
		} else if (sel == 2) {
			product.setstatusproduction(false);
			MainView.pause();
		} else if (sel == 3) {
			stopproduction();
		} else {
			System.out.println("잘못된입력");
			MainView.pause();
		}
	}

	private static void stopproduction() {
		
		ProductionManagement.setRejectproduct();

		// 생산 정지 하루 재고 -> 재고량
		for (ModelInfo model : ModelInfoData.modelInfoList) {
				model.setModelInventory(TodayProduction.getFinalTodayProductNum());

			
		}

		// 하루 목표량 -> 0
		for (String key : ProductionTarget.TargetNum.keySet()) {
			ProductionTarget.TargetNum.put(key, 0);

		}
	}

	private static void setRejectproduct() {
		// 불량품 개수 입력
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		// 불량품 개수
		while (loop) {
			ProductionView.viewModel();
			System.out.print("번호 입력(종료. 0번): ");
			int sel = sc.nextInt();
			if (sel == 0) {
				loop = false;
			}
			System.out.printf("%d. %s: ", sel, TodayProductionData.todayProductionList.get(sel - 1));
			int productNum = sc.nextInt();
			TodayProductionData.todayProductionList.get(sel - 1).setTodayDefectiveNum(productNum);

		}

	}

}// class

//생산시작 쓰레드
class ProductStart extends Thread {

	private boolean statusproduction = true;

	public void setstatusproduction(boolean statusproduction) {
		this.statusproduction = statusproduction;
	}

	public void run(String date) {
		int count = 0;
		System.out.println("생산을 시작합니다.");
		while (statusproduction) {
			try {
				for (TodayProduction today : TodayProductionData.todayProductionList) {
					today.setTodayProductNum(count);
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
