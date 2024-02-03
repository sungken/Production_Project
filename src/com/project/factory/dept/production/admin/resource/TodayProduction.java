package com.project.factory.dept.production.admin.resource;

public class TodayProduction {
	private String date;
	private int todayProductNum;
	private int todayDefectiveNum;
	private String model;
	
	public TodayProduction(String date, int todayProductNum, int todayDefectiveNum, String model) {
		this.date = date;
		this.todayProductNum = todayProductNum;
		this.todayDefectiveNum = todayDefectiveNum;
		this.model = model;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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
	
	
}
