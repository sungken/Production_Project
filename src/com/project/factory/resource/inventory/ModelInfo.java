package com.project.factory.resource.inventory;
/**
 * 모델 정보 클래스 (모델이름, 들어가는 부품(개수), 엔진타입, 모델재고)
 */
public class ModelInfo {
	private String modelName;
	private int wheel;
	private int frame;
	private int leather;
	private String engineType;
	private int modelInventory;
	
	/**
	 * 모델 클래스의 생성자이다.
	 * @param modelName	모델이름
	 * @param wheel	바퀴 수
	 * @param frame	철판 수
	 * @param leather	가죽 수
	 * @param engineType	엔진 종류
	 * @param modelInventory	재고량
	 */
	public ModelInfo(String modelName, int wheel, int frame, int leather, String engineType, int modelInventory) {
		this.modelName = modelName;
		this.wheel = wheel;
		this.frame = frame;
		this.leather = leather;
		this.engineType = engineType;
		this.modelInventory = modelInventory;
	}
	/**
	 * 모델 정보 생산자이다.
	 */
	public ModelInfo() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 바퀴의 개수를 반환하는 메서드이다.
	 * @return 바퀴 개수
	 */
	public int getWheel() {
		return wheel;
	}
	/**
	 * 바퀴 개수를 설정하는 메서드이다.
	 * @param wheel 바퀴 개수
	 */
	public void setWheel(int wheel) {
		this.wheel = wheel;
	}
	/**
	 * 모델 재고를 반환하는 메서드이다.
	 * @return 모델 재고
	 */
	public int getModelInventory() {
		return modelInventory;
	}
	/**
	 * 모델 재고를 설정하는 메서드이다.
	 * @param modelInventory 모델 재고
	 */
	public void setModelInventory(int modelInventory) {
		this.modelInventory = modelInventory;
	}
	/**
	 * 모델 이름을 반환하는 메서드이다.
	 * @return 모델 이름
	 */
	public String getModelName() {
		return modelName;
	}
	/**
	 * 모델 이름을 설정하는 메서드이다.
	 * @param modelName 모델 이름
	 */
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	/**
	 * 철판 개수를 반환하는 메서드이다.
	 * @return 철판 개수
	 */
	public int getFrame() {
		return frame;
	}
	/**
	 * 철판 개수를 설정하는 메서드이다.
	 * @param frame 철판 개수
	 */
	public void setFrame(int frame) {
		this.frame = frame;
	}
	/**
	 * 가죽 개수를 반환하는 메서드이다.
	 * @return 가죽 개수
	 */
	public int getLeather() {
		return leather;
	}
	/**
	 * 가죽 개수를 설정하는 메서드이다.
	 * @param leather 가죽 개수
	 */
	public void setLeather(int leather) {
		this.leather = leather;
	}
	/**
	 * 엔진 종류를 반환하는 메서드이다.
	 * @return 엔진 종류
	 */
	public String getEngineType() {
		return engineType;
	}
	/**
	 * 엔진 종류를 설정하는 메서드이다.
	 * @param engineType 엔진 종류
	 */
	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}
	
	
}
