package com.project.factory.dept.distribution.user;

public class Assign {
	// 주문서
		//주문서번호■주문서 작성일■대리점명■대리점 주소■전화번호■개수■납기일■모델명
		private int num ;
		private String assignRegion;
		private String agencyName;
		private String modelId;
		private int quantity;
		private String name;
		private String memberId;
		private String state = "미완료";
		

	    

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
		
		public Assign(int num, String assignRegion, String agencyName, String modelId,  int quantity, String name, String memberId, String state) {
			this.num = num;
			this.assignRegion = assignRegion;
			this.agencyName = agencyName;
			this.modelId = modelId;
			this.quantity = quantity;
			this.name = name;
			this.memberId = memberId;
			this.state = state;
		}

		public String getAssignRegion() {
			return assignRegion;
		}



		public void setAssignRegion(String assignRegion) {
			this.assignRegion = assignRegion;
		}

		public String getAgencyName() {
			return agencyName;
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

	

		public void setAgencyName(String agencyName) {
			this.agencyName = agencyName;
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



		






	

}
