package com.project.factory.dept.production.admin.resource;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import com.project.factory.dept.production.admin.ProductionManagement;
import com.project.factory.resource.Path;
import com.project.factory.view.dept.ProductionView;
/**
 * 하루 생산량 데이터 관리 클래스
 */
public class TodayProductionData {
	public static ArrayList<TodayProduction> todayProductionList = new ArrayList<TodayProduction>();
	/**
	 * txt파일에 있는 하루 생산량을 ArrayList에 담는 메소드이다.
	 */
	public static void todayInventoryLoad() {
		try {

			BufferedReader reader = new BufferedReader(new FileReader(Path.TODAYPRODUCTION));

			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("■");

				TodayProduction todayProduction = new TodayProduction(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), temp[2]);

				todayProductionList.add(todayProduction);
				

			}
			reader.close();

		} catch (Exception e) {
			System.out.println("Data.load");
			e.printStackTrace();
		}

	}
	/**
	 * 하루 생산량을 txt파일에 저장하는 메소드이다.
	 */
	public static void todayInventorySave() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(Path.TODAYPRODUCTION));

			for (TodayProduction todayProduction : TodayProductionData.todayProductionList) {

				String line = String.format("%d■%d■%s\r\n", todayProduction.getTodayProductNum(), todayProduction.getTodayDefectiveNum(), todayProduction.getModel());

				writer.write(line);

			}

			writer.close();

		} catch (Exception e) {
			System.out.println("Data.save");
			e.printStackTrace();
		}

	}
}
