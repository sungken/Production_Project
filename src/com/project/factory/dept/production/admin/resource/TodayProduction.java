package com.project.factory.dept.production.admin.resource;

/**
 * 하루 생산량 데이터 클래스이다.
 */
public class TodayProduction {
	private int todayProductNum;
	private int todayDefectiveNum;
	private String model;
	
	/**
	 * 하루 생산량 생성자이다.
	 * @param todayProductNum	하루 생산량
	 * @param todayDefectiveNum 하루 불량품 개수
	 * @param model	모델이름
	 */
	public TodayProduction(int todayProductNum, int todayDefectiveNum, String model) {
		this.todayProductNum = todayProductNum;
		this.todayDefectiveNum = todayDefectiveNum;
		this.model = model;
	}

	public TodayProduction() {
		// TODO Auto-generated constructor stub
	}

	public int getTodayProductNum() {
		return todayProductNum;
	}

	public void setTodayProductNum(int todayProductNum) {
		this.todayProductNum = todayProductNum;
	}

	public int getTodayDefectiveNum() {
		return todayDefectiveNum;
	}

	public void setTodayDefectiveNum(int todayDefectiveNum) {
		this.todayDefectiveNum = todayDefectiveNum;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	
	
	
}
