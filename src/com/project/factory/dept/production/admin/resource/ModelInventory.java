package com.project.factory.dept.production.admin.resource;

public class ModelInventory {
	
	private String modelName;
	private int modelInventory;
	
	public ModelInventory(String modelName, int modelInventory) {
		this.modelName = modelName;
		this.modelInventory = modelInventory;
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
