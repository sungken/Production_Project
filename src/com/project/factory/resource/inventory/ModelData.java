package com.project.factory.resource.inventory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import com.project.factory.resource.Path;

public class ModelData {
	public static ArrayList<Model> modelList = new ArrayList<Model>();
	

public static void modelLoad() {
	try {
		BufferedReader reader = new BufferedReader(new FileReader(Path.MODELINVENTORY));
		String line = null;
		while((line = reader.readLine()) != null) {
			String[] temp = line.split("■");
//			Model model = new Model(temp[0], temp[1]);
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
}
}