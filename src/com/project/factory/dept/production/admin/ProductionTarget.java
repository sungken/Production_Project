package com.project.factory.dept.production.admin;

import java.util.Scanner;

import com.project.factory.resource.inventory.Model;
import com.project.factory.view.dept.ProductionView;

public class ProductionTarget {

	// 목표량
	private void setTarget() {
		Scanner sc = new Scanner(System.in);
		ProductionView.viewModelInven();
		int sel = sc.nextInt();

		switch (sel) {
		case 1:
			System.out.print("k3 :");
		
		case 2:
			System.out.print("k5 :");
			
		case 3:
			System.out.print("k7 :");
	
		case 4:
			System.out.print("k9 :");
			
		}
	}

}
