package com.project.factory.dept.production.admin;

import com.project.factory.dept.production.admin.resource.TodayProduction;
import com.project.factory.dept.production.admin.resource.TodayProductionData;
import com.project.factory.resource.inventory.ModelInfo;
import com.project.factory.resource.inventory.ModelInfoData;
import com.project.factory.resource.inventory.Piece;
import com.project.factory.resource.inventory.PieceData;

/**
 * 생산 시스템이 실행되는 클래스이다.
 */
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
	
	private boolean terminate;
	
	
	
	public boolean isTerminate() {
		return terminate;
	}


	public void setTerminate(boolean terminate) {
		this.terminate = terminate;
	}


	int K3count = 0;
	int K5count = 0;
	int K7count = 0;
	int K9count = 0;

	/**
	 * 생산 시스템 구현부 메소드이다.
	 */
	@Override
	public void run() {
		terminate = true;

		while (true) {
			if(!terminate) {
				break;
			}
			if(stopRequested) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				continue;
				
			}
			
			try {
				ProductionSystem.productK3();
				ProductionSystem.productK5();
				ProductionSystem.productK7();
				ProductionSystem.productK9();
				Thread.sleep(10000);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			
	}

}