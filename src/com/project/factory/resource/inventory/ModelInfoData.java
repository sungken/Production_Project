package com.project.factory.resource.inventory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import com.project.factory.resource.Path;
/**
 * 모델 정보 데이터를 관리하는 클래스이다.
 */
public class ModelInfoData {
	/**
	 * 모델별 정보를 담는 ArrayList이다.
	 */
	public static ArrayList<ModelInfo> modelInfoList = new ArrayList<ModelInfo>();
	/**
	 * 모델 정보가 담겨있는 txt파일의 내용을 ArrayList에 담는 메소드이다.
	 */
	public static void modelInfoLoad() {
		try {

			BufferedReader reader = new BufferedReader(new FileReader(Path.MODELINVENTORY));

			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("■");

				ModelInfo modelInfo = new ModelInfo(temp[0], Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), temp[4], Integer.parseInt(temp[5]));

				modelInfoList.add(modelInfo);

			}

			reader.close();

		} catch (Exception e) {
			System.out.println("Data.load");
			e.printStackTrace();
		}

	}
	/**
	 * ArrayList의 모델 정보를 txt파일에 담는 메소드이다.
	 */
	public static void modelInfoSave() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(Path.MODELINVENTORY));

			for (ModelInfo modelInfo : ModelInfoData.modelInfoList) {

				String line = String.format("%s■%d■%d■%d■%s■%d\r\n", modelInfo.getModelName(), modelInfo.getWheel(), modelInfo.getFrame(), modelInfo.getLeather(), modelInfo.getEngineType(), modelInfo.getModelInventory());

				writer.write(line);

			}

			writer.close();

		} catch (Exception e) {
			System.out.println("Data.save");
			e.printStackTrace();
		}

	}


}
