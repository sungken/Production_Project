package com.project.factory.dept.production.admin.resource;
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
	
	
	public ModelInfo(String modelName, int wheel, int frame, int leather, String engineType, int modelInventory) {
		this.modelName = modelName;
		this.wheel = wheel;
		this.frame = frame;
		this.leather = leather;
		this.engineType = engineType;
		this.modelInventory = modelInventory;
	}

	public ModelInfo() {
		// TODO Auto-generated constructor stub
	}

	public int getWheel() {
		return wheel;
	}

	public void setWheel(int wheel) {
		this.wheel = wheel;
	}

	public int getModelInventory() {
		return modelInventory;
	}

	public void setModelInventory(int modelInventory) {
		this.modelInventory = modelInventory;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public int getFrame() {
		return frame;
	}

	public void setFrame(int frame) {
		this.frame = frame;
	}

	public int getLeather() {
		return leather;
	}

	public void setLeather(int leather) {
		this.leather = leather;
	}

	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}
	
	
}
