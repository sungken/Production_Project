package com.project.factory.dept.production.admin.resource;

/**
 * 하루 생산량 데이터 클래스이다.
 */
public class TodayProduction {
	private int todayProductNum;
	private int todayDefectiveNum;
	private String model;
	
	/**
	 * TodayProduction 클래스의 생성자이다.
	 * @param todayProductNum	하루 생산량
	 * @param todayDefectiveNum 하루 불량품 개수
	 * @param model	모델이름
	 */
	public TodayProduction(int todayProductNum, int todayDefectiveNum, String model) {
		this.todayProductNum = todayProductNum;
		this.todayDefectiveNum = todayDefectiveNum;
		this.model = model;
	}
	/**
	 * 하루생산량 생성자이다.
	 */
	public TodayProduction() {
		// TODO Auto-generated constructor stub
	}

	/**하루 생산량을 반환하는 메서드이다.

	 * 
	 * @return 하루 생산량
	 */
	public int getTodayProductNum() {
		return todayProductNum;
	}

	/**하루 생산량을 설정하는 메서드이다.

	 * 
	 * @param todayProductNum 하루 생산량
	 */
	public void setTodayProductNum(int todayProductNum) {
		this.todayProductNum = todayProductNum;
	}



	/**
	 * 하루 불량품 개수를 반환하는 메서드이다.
	 * @return	하루 불량품 개수
	 */
	public int getTodayDefectiveNum() {
		return todayDefectiveNum;
	}



	/**
	 * 하루 불량품 개수를 설정하는 메서드이다.
	 * @param todayDefectiveNum	하루 불량품 개수
	 */
	public void setTodayDefectiveNum(int todayDefectiveNum) {
		this.todayDefectiveNum = todayDefectiveNum;
	}

	/**모델 이름을 반환하는 메서드이다.
	 * 
	 * @return 모델이름
	 */
	public String getModel() {
		return model;
	}

	/**모델 이름을 설정하는 메서드이다.
	 * 	
	 * @param model 모델 이름
	 */
	public void setModel(String model) {
		this.model = model;
	}


	
	
	
}
