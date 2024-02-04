package com.project.factory.dept.production.admin.resource;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import com.project.factory.resource.Path;

public class TodayProductionData {
	public static ArrayList<TodayProduction> todayProductionList = new ArrayList<TodayProduction>();

	public static void todayInventoryLoad() {
		try {

			BufferedReader reader = new BufferedReader(new FileReader(Path.TODAYPRODUCTION));

			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("■");

				TodayProduction todayProduction = new TodayProduction(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), temp[3]);

				todayProductionList.add(todayProduction);

			}

			reader.close();

		} catch (Exception e) {
			System.out.println("Data.load");
			e.printStackTrace();
		}

	}

	public static void TodayInventorySave() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(Path.TODAYPRODUCTION));

			for (TodayProduction todayProduction : TodayProductionData.todayProductionList) {

				String line = String.format("%d■%d■%d■%s\r\n", todayProduction.getTodayProductNum(), todayProduction.getTodayDefectiveNum(), todayProduction.getModel());

				writer.write(line);

			}

			writer.close();

		} catch (Exception e) {
			System.out.println("Data.save");
			e.printStackTrace();
		}

	}
}
