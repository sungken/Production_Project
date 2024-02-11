package com.project.factory.dept.production.admin.resource;
/**
 * 하루 목표 생산량 데이터 클래스이다.
 */
public class ProductionTargetData {
	
	private String modelName;
	private int targetNum;
	/**
	 * 하루 목표생산량 생성자이다.
	 * @param targetNum	하루 목표량
	 * @param modelName	모델 이름
	 */
	public ProductionTargetData(int targetNum, String modelName) {
		this.modelName = modelName;
		this.targetNum = targetNum;
	}
	
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public int getTargetNum() {
		return targetNum;
	}
	public void setTargetNum(int targetNum) {
		this.targetNum = targetNum;
	}
	
	
}
