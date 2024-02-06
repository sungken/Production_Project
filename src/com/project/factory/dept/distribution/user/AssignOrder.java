package com.project.factory.dept.distribution.user;

public class AssignOrder {
	
//System.out.println("[주문서 번호]\t[구역]\t[대리점명]\t[모델명]\t[수량]\t[상태]");
	
	private String orderId;
	private String area;
	private String agencyName;
	private String modelId;
	private int quantity;
	private String state;
	private String userId;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getAgencyName() {
		return agencyName;
	}
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
	public String getModelId() {
		return modelId;
	}
	public void setModelId(String modelId) {
		this.modelId = modelId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public AssignOrder(String orderId, String area, String agencyName, String modelId, int quantity, String state, String userId) {
	
		this.orderId = orderId;
		this.area = area;
		this.agencyName = agencyName;
		this.modelId = modelId;
		this.quantity = quantity;
		this.state = state;
		this.userId = userId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
