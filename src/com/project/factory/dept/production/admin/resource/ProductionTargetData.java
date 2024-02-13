package com.project.factory.dept.production.admin.resource;

/**
 * 하루 목표 생산량 데이터 클래스이다.
 */
public class ProductionTargetData {

	private String modelName;
	private int targetNum;

	/**
	 * 하루 목표생산량 생성자이다.
	 * 
	 * @param targetNum 하루 목표량
	 * @param modelName 모델 이름
	 */
	public ProductionTargetData(int targetNum, String modelName) {
		this.modelName = modelName;
		this.targetNum = targetNum;
	}


	/**
	 * 모델의 이름을 설정하는 메서드이다.
	 * 
	 * @param modelName 모델 이름

	 */
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	/**
	 * 하루 목표 생산량을 반환하는 메서드이다.
	 * 
	 * @return 하루 목표 생산량

	 */
	public int getTargetNum() {
		return targetNum;
	}

	
	/** 하루 목표량을 설정하는 메서드이다. 
	 * 
	 * @param targetNum 하루 목표량


	/**
	 * 하루 목표 생산량을 설정하는 메서드이다.
	 * 
	 * @param targetNum 하루 목표 생산량

	 */
	public void setTargetNum(int targetNum) {
		this.targetNum = targetNum;
	}

}
