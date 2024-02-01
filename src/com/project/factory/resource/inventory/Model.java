package com.project.factory.resource.inventory;

public class Model {
	private String modelName;
	private int modelInventory;

	
	public Model(String modelName, int modelInventory) {
		this.modelName = modelName;
		
	}
	

	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public int getModelInventory() {
		return modelInventory;
	}
	public void setModelInventory(int modelInventory) {
		this.modelInventory = modelInventory;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
}
