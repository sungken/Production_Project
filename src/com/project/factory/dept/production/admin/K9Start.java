package com.project.factory.dept.production.admin;

import com.project.factory.dept.production.admin.resource.TodayProduction;
import com.project.factory.dept.production.admin.resource.TodayProductionData;

public class K9Start extends Thread{
		private String model = "K9";
		
		private boolean statusproduction = true;
		
		public void setStatusproduction(boolean statusproduction) {
			this.statusproduction = statusproduction;
		}


		public void run() {
			int count = 5;
			System.out.println("K9생산을 시작합니다.");
			while (true) {
				try {
					for (TodayProduction today : TodayProductionData.todayProductionList) {
						if(today.getModel().equals(model)) {
							today.setTodayProductNum(count);
						}
					}
					count += 3;
					Thread.sleep(10000);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	
}
