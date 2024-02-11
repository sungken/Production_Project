package com.project.factory.dept.production.admin.resource;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

import com.project.factory.resource.Path;
/**
 * 모델별 목표 생산량 클래스
 */
public class ProductionTarget {
	/**
	 * 하루 생산목표량을 담는 HashMap이다.
	 */
	public static HashMap<String, Integer> TargetNum = new HashMap<String, Integer>();
	
	/**
	 * txt파일의 내용을 HashMap에 담는 메소드이다.
	 */
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
	
	/**
	 * 하루목표량 HashMap의 내용을 txt파일에 저장하는 메소드이다.
	 */
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
