package com.project.factory.dept.production.admin.resource;
/**
 * 모델 정보 클래스
 */
public class ModelInfo {
	private String modelName;
	private int frame;
	private int leather;
	private String engineType;
	
	public ModelInfo(String modelName, int frame, int leather, String engineType) {
		this.modelName = modelName;
		this.frame = frame;
		this.leather = leather;
		this.engineType = engineType;
		
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
