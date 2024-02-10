package com.project.factory.resource.sub;

public class Order {
	// 주문서
	//주문서번호■주문서 작성일■대리점명■대리점 주소■전화번호■개수■납기일■모델명
	private String id;
	private String writeDate;
	private String agencyName;
	private String agencyAddress;
	private String agencyPhoneNum;
	private int quantity;
	private String dueDate;
	private String modelId;
	
	/**
	 * 
	 * @param id 주문서 번호
	 * @param writeDate 주문서 작성일
	 * @param agencyName 대리점명
	 * @param agencyAddress 대리점 주소
	 * @param agencyPhoneNum 대리점 전화번호
	 * @param quantity 수량
	 * @param dueDate 납기일
	 * @param modelId 모델명
	 */
	public Order(String id, String writeDate, String agencyName, String agencyAddress, String agencyPhoneNum, int quantity, String dueDate, String modelId) {
		this.id = id;
		this.writeDate = writeDate;
		this.agencyName = agencyName;
		this.agencyAddress = agencyAddress;
		this.agencyPhoneNum = agencyPhoneNum;
		this.quantity = quantity;
		this.dueDate = dueDate;
		this.modelId = modelId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getId() {
		return id;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public String getAgencyAddress() {
		return agencyAddress;
	}

	public String getAgencyPhoneNum() {
		return agencyPhoneNum;
	}

	public String getDueDate() {
		return dueDate;
	}

	public String getModelId() {
		return modelId;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", writeDate=" + writeDate + ", agencyName=" + agencyName + ", agencyAddress="
				+ agencyAddress + ", agencyPhoneNum=" + agencyPhoneNum + ", quantity=" + quantity + ", dueDate=" + dueDate
				+ ", modelId=" + modelId + "]";
	}
	

	// orederlist > 누가 사용?
//	public void orderList() {
//		try {
//
//			BufferedReader reader = new BufferedReader(new FileReader(Path.MEMBER));
//
//			String line = null;
//			while ((line = reader.readLine()) != null) {
//				String[] temp = line.split("■");
//
//				
//			}
//			reader.close();
//
//		} catch (Exception e) {
//			System.out.println("Login.login");
//			e.printStackTrace();
//		}
//
//	}
}
