package com.project.factory.resource;

import java.io.BufferedReader;
import java.io.FileReader;

public class Order {
	// 주문서

	// orederlist
	public void orderList() {
		try {

			BufferedReader reader = new BufferedReader(new FileReader(Path.MEMBER));

			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("■");

				
			}
			reader.close();

		} catch (Exception e) {
			System.out.println("Login.login");
			e.printStackTrace();
		}

	}
}
