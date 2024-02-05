package com.project.factory.dept.distribution.user;

public class Assign {
	// 주문서
		//주문서번호■주문서 작성일■대리점명■대리점 주소■전화번호■개수■납기일■모델명
		private int num ;
		private String assignOrder;
		private String id;
		private String writeDate;
		private String agencyName;
		private String agencyAddress;
		private String agencyPhoneNum;
		private int quantity;
		private String dueDate;
		private String modelId;
		private String name;
		private String memberId;
		
		/**
		 * 
		 * @param id 주무서 번호
		 * @param writeDate 주문서 작성일
		 * @param agencyName 대리점명
		 * @param agencyAddress 대리점 주소
		 * @param agencyPhoneNum 대리점 전화번호
		 * @param quantity 수량
		 * @param dueDate 납기일
		 * @param modelId 모델명
		 */
		//                 1■           경기도■        452721■    2024-01-31■        강남1호점■  서울특별시 강남구 테헤란로 132■010-1234-4567■       30■        2024-02-05■      k3■           정희현■           ffff
		public Assign(int num, String assignOrder, String id, String writeDate, String agencyName, String agencyAddress, String agencyPhoneNum, int quantity, String dueDate, String modelId, String name, String memberId) {
			this.num = num;
			this.assignOrder = assignOrder;
			this.id = id;
			this.writeDate = writeDate;
			this.agencyName = agencyName;
			this.agencyAddress = agencyAddress;
			this.agencyPhoneNum = agencyPhoneNum;
			this.quantity = quantity;
			this.dueDate = dueDate;
			this.modelId = modelId;
			this.name = name;
			this.memberId = memberId;
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
			

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getMemberId() {
			return memberId;
		}

		public void setMemberId(String memberId) {
			this.memberId = memberId;
		}

		public void setId(String id) {
			this.id = id;
		}

		public void setWriteDate(String writeDate) {
			this.writeDate = writeDate;
		}

		public void setAgencyName(String agencyName) {
			this.agencyName = agencyName;
		}

		public void setAgencyAddress(String agencyAddress) {
			this.agencyAddress = agencyAddress;
		}

		public void setAgencyPhoneNum(String agencyPhoneNum) {
			this.agencyPhoneNum = agencyPhoneNum;
		}

		public void setDueDate(String dueDate) {
			this.dueDate = dueDate;
		}

		public void setModelId(String modelId) {
			this.modelId = modelId;
		}

		public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}

		public String getAssignOrder() {
			return assignOrder;
		}

		public void setAssignOrder(String assignOrder) {
			this.assignOrder = assignOrder;
		}






	

}
