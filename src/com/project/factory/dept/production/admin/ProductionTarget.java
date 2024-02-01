package com.project.factory.dept.production.admin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

import com.project.factory.resource.Path;

public class ProductionTarget {
	//모델별 목표 생산량을 담는 HashMap
	public static HashMap<String, Integer> TargetNum = new HashMap<String, Integer>();
	
	public static void load_target() {
		try {

			BufferedReader reader = new BufferedReader(new FileReader(Path.TODAYGOAL));

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

	public static void save_target() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(Path.TODAYGOAL));

			for (String key : TargetNum.keySet()) {

				String line = String.format("%s■%d\r\n", key, TargetNum.get(key));
				
				writer.write(line);

			}

			writer.close();

		} catch (Exception e) {
			System.out.println("Data.save");
			e.printStackTrace();
		}

	}

}
