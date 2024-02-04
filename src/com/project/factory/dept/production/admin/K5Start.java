package com.project.factory.dept.production.admin;

import com.project.factory.dept.production.admin.resource.TodayProduction;
import com.project.factory.dept.production.admin.resource.TodayProductionData;

public class K5Start extends Thread{
	
		private String model = "K5";
		
		private boolean statusproduction = true;
		
		public void setStatusproduction(boolean statusproduction) {
			this.statusproduction = statusproduction;
		}


		public void run() {
			int count = 0;
			System.out.println("K5생산을 시작합니다.");
			while (true) {
				try {
					for (TodayProduction today : TodayProductionData.todayProductionList) {
						if(today.getModel().equals(model)) {
						today.setTodayProductNum(count);
						}
					}
					count += 7;
					Thread.sleep(10000);
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	
}
