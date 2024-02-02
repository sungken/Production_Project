//package com.project.factory.dept.production.admin;
//
//import java.util.concurrent.TimeUnit;
//
//import com.project.factory.dept.production.admin.resource.ModelInventory;
//import com.project.factory.dept.production.admin.resource.ModelInventoryData;
//
//class productStart extends Thread {
//
//	public void run() {
//		int count = 0;
//		System.out.println("시작");
//		boolean statusproduction = true;
//		while (statusproduction) {
//			try {
//				for (ModelInventory modelInventory : ModelInventoryData.modelInventoryList) {
//					modelInventory.setModelInventory(count);
//					System.out.println(modelInventory.getModelName() + " : " + modelInventory.getModelInventory());
//
//				}
//				count += 5;
//				Thread.sleep(1000);
//
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//
//	}
//}
