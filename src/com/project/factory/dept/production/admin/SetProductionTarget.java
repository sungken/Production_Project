package com.project.factory.dept.production.admin;

import java.util.Scanner;

import com.project.factory.view.MainView;
import com.project.factory.view.dept.ProductionView;

public class SetProductionTarget {
	public static void setProductionTarget() {
		int target = 0;
		Scanner sc = new Scanner(System.in);
		MainView.doubleLine();
		System.out.println("모델별 생산 목표량을 입렵해주세요.");
		ProductionView.viewModelInven();
		MainView.doubleLine();
		
		System.out.println("번호입력: ");
		int sel = sc.nextInt();
		
		switch (sel) {
		case 1 : 
			System.out.print("K3: ");
			target = sc.nextInt();
			ProductionTarget.TargetNum.put("K3", target);
			break;
		case 2 :
			System.out.print("K5: ");
			target = sc.nextInt();
			ProductionTarget.TargetNum.put("K3", target);
			break;
		case 3 :
			System.out.print("K7: ");
			ProductionTarget.TargetNum.put("K7", target);
			break;
		case 4 :
			System.out.print("K9: ");
			ProductionTarget.TargetNum.put("K9", target);
			break;
			
		}
		for(String key : ProductionTarget.TargetNum.keySet()) {
			Integer value = ProductionTarget.TargetNum.get(key);
			System.out.println(key + "," +value);
		}
	}
	
}
