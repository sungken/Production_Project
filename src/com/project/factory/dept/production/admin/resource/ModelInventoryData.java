package com.project.factory.dept.production.admin.resource;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import com.project.factory.resource.Path;
/**
 * 모델별 재고 관리 클래스
 */
public class ModelInventoryData {
	public static ArrayList<ModelInventory> modelInventoryList = new ArrayList<ModelInventory>();

	public static void inventoryLoad() {
		try {

			BufferedReader reader = new BufferedReader(new FileReader(Path.MODELINVENTORY));

			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("■");

				ModelInventory modelInventory = new ModelInventory(temp[0], Integer.parseInt(temp[1]));

				modelInventoryList.add(modelInventory);

			}

			reader.close();

		} catch (Exception e) {
			System.out.println("Data.load");
			e.printStackTrace();
		}

	}

	public static void inventorySave() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(Path.MODELINVENTORY));

			for (ModelInventory modelInventory : ModelInventoryData.modelInventoryList) {

				String line = String.format("%s■%d\r\n", modelInventory.getModelName(), modelInventory.getModelInventory());

				writer.write(line);

			}

			writer.close();

		} catch (Exception e) {
			System.out.println("Data.save");
			e.printStackTrace();
		}

	}
}
