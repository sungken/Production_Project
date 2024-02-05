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
	 // 생산관리
	
<<<<<<< HEAD
	public static void productionSelect() {
=======
	
	//스위치 케이스 맘대루~
	
	
	private void startProduction() {
		//생산 자동 카운트
	}
	
	private void pauseProduction() {
		//생산 일시중지
	}
	private void stopProduction() {
		//생산 정지 하루 재고 -> 재고량
>>>>>>> upstream/main
		
		
		K3Start k3 = new K3Start();
		K5Start k5 = new K5Start();
		K7Start k7 = new K7Start();
		K9Start k9 = new K9Start();
		
		Scanner sc = new Scanner(System.in);
		
		ProductionView.viewproductionMenu();
		System.out.print("생산 입력: ");
		int sel = sc.nextInt();
		
		if (sel == 1) {
			
			k3.start();
			k5.start();
			k7.start();
			k9.start();
			k3.setStatusproduction(true);
			k5.setStatusproduction(true);
			k7.setStatusproduction(true);
			k9.setStatusproduction(true);
			
			MainView.pause();
		} else if (sel == 2) {
			k3.setStatusproduction(false);
			k5.setStatusproduction(false);
			k7.setStatusproduction(false);
			k9.setStatusproduction(false);
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




