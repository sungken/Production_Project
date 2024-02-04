package com.project.factory.dept.production.admin.resource;

public class TodayProduction {
	private static int todayProductNum;
	private static int todayDefectiveNum;
	private int finalTodayProductNum;
	private String model;
	
	public TodayProduction(int todayProductNum, int todayDefectiveNum, int finalTodayProductNum,  String model) {
		this.todayProductNum = todayProductNum;
		this.todayDefectiveNum = todayDefectiveNum;
		this.finalTodayProductNum = finalTodayProductNum;
		this.model = model;
	}

	public int getTodayProductNum() {
		return todayProductNum;
	}

	public static int getFinalTodayProductNum() {
		return todayProductNum - todayDefectiveNum;
	}

	public void setFinalTodayProductNum(int finalTodayProductNum) {
		this.finalTodayProductNum = finalTodayProductNum;
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
