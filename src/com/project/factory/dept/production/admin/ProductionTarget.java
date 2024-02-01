package com.project.factory.dept.production.admin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

import com.project.factory.resource.Members;
import com.project.factory.resource.Path;
import com.project.factory.view.dept.ProductionView;

public class ProductionTarget {
	
	
	public static void load_target() {
		HashMap<String, Integer> TargetNum = new HashMap<String, Integer>();
		try {

			BufferedReader reader = new BufferedReader(new FileReader(Path.MEMBER));

			String line = null;
			while ((line = reader.readLine()) != null) {
			
				String[] temp = line.split("■");
				TargetNum.put(temp[0], Integer.parseInt(temp[1]));
				
				
			}

			reader.close();

		} catch (Exception e) {
			System.out.println("Data.load");
			e.printStackTrace();
		}

	}

	// 목표량
//	private void setTarget() {
//		Scanner sc = new Scanner(System.in);
//		ProductionView.viewModelInven();
//		int sel = sc.nextInt();
//		switch (sel) {
//		case 1:
//			
//		case 2:
//			
//		case 3:
//			
//		case 4:
//			
//			
//		}
//	}

}
