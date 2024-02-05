package com.project.factory.resource.sub;

public class Order {
	// 주문서
	//주문서번호■주문서 작성일■대리점명■대리점 주소■전화번호■개수■납기일■모델명
	private String orderNum;
	private String writeDate;
	private String id;
	private String address;
	private String phoneNum;
	private int count;
	private String dueDate;
	private String modelId;
	
	/**
	 * 
	 * @param orderNum 주무서 번호
	 * @param writeDate 주문서 작성일
	 * @param id 대리점명
	 * @param address 대리점 주소
	 * @param phoneNum 대리점 전화번호
	 * @param count 개수
	 * @param dueDate 납기일
	 * @param modelId 모델명
	 */
	public Order(String orderNum, String writeDate, String id, String address, String phoneNum, int count, String dueDate, String modelId) {
		this.orderNum = orderNum;
		this.writeDate = writeDate;
		this.id = id;
		this.address = address;
		this.phoneNum = phoneNum;
		this.count = count;
		this.dueDate = dueDate;
		this.modelId = modelId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public String getId() {
		return id;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public String getDueDate() {
		return dueDate;
	}

	public String getModelId() {
		return modelId;
	}

	@Override
	public String toString() {
		return "[orderNum=" + orderNum + ", writeDate=" + writeDate + ", id=" + id + ", address=" + address
				+ ", phoneNum=" + phoneNum + ", count=" + count + ", dueDate=" + dueDate + ", modelId=" + modelId + "]";
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
