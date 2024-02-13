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
	/**
	 * 생산 시스템 정지여부 변수이다.
	 */
	private boolean stopRequested;
	/**생산 시스템 정지여부를 반환하는 메서드이다.
	 * 
	 * @return 생산시스템 정지여부
	 */
	public boolean isStopRequested() {
		return stopRequested;
	}

	/**생산 시스템 정지여부를 설정하는 메서드이다.
	 * 
	 * @param stopRequested	생산시스템 정지여부
	 */
	public void setStopRequested(boolean stopRequested) {
		this.stopRequested = stopRequested;
	}
	
	/**생산시스템이 시작여부 변수이다.
	 * 
	 */
	private boolean isStarted;
	/**생산시스템 시작여부를 반환하는 메서드이다.
	 * 
	 * @return 생산시스템 시작여부
	 */
	public boolean isStarted() {
		return isStarted;
	}

	/**생산시스템 시작여부를 설정하는 메서드이다.
	 * 
	 * @param isStarted 생산시스템 시작여부
	 */
	public void setStarted(boolean isStarted) {
		this.isStarted = isStarted;
	}
	/**생산 시스템 종료 변수이다.
	 * 
	 */
	private boolean terminate;
	
	
	/**생산 시스템 종료상태를 반환하는 메서드이다.
	 * 
	 * @return 생산 시스템 종료상태
	 */
	public boolean isTerminate() {
		return terminate;
	}

	/**생산 시스템 종료상태를 설정하는 메서드이다.
	 * 
	 * @param terminate 생산 시스템 종료상태
	 */
	public void setTerminate(boolean terminate) {
		this.terminate = terminate;
	}


	/**
	 * 생샌 시스템 구현부 메소드이다.
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