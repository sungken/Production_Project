package com.project.factory.dept.production.admin;

import com.project.factory.dept.production.admin.resource.TodayProduction;
import com.project.factory.dept.production.admin.resource.TodayProductionData;


public class ProductThread extends Thread {

	private boolean stopRequested;

	public boolean isStopRequested() {
		return stopRequested;
	}


	public void setStopRequested(boolean stopRequested) {
		this.stopRequested = stopRequested;
	}
	
	
	private boolean isStarted;
	
	public boolean isStarted() {
		return isStarted;
	}


	public void setStarted(boolean isStarted) {
		this.isStarted = isStarted;
	}


	@Override
	public void run() {
		int K3count = 0;
		int K5count = 0;
		int K7count = 0;
		int K9count = 0;
		System.out.println("쓰레드 시작");

		while (!stopRequested) {
			try {
				for (TodayProduction today : TodayProductionData.todayProductionList) {
					if (today.getModel().equals("K3")) {
						today.setTodayProductNum(K3count);
						
//						System.out.printf("%s . %d\n", today.getModel(), today.getTodayProductNum());
					}
					if (today.getModel().equals("K5")) {
						today.setTodayProductNum(K5count);
//						System.out.printf("%s . %d\n", today.getModel(), today.getTodayProductNum());
					}
					if (today.getModel().equals("K7")) {
						today.setTodayProductNum(K7count);
//						System.out.printf("%s . %d\n", today.getModel(), today.getTodayProductNum());
					}
					if (today.getModel().equals("K9")) {
						today.setTodayProductNum(K9count);
//						System.out.printf("%s . %d\n", today.getModel(), today.getTodayProductNum());
					}
					
				}
				K3count += 9;
				K5count += 7;
				K7count += 5;
				K9count += 3;
				Thread.sleep(10000);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("쓰레드 종료");
	}

}
