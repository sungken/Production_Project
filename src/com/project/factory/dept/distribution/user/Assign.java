package com.project.factory.dept.distribution.user;

import com.project.factory.resource.Members;

/** 유통부 사원의 정보에 주문서 정보 나타내는 클래스이다.
 * 
 */
public class Assign {

		private String id;
		private String writeDate;
		private String agencyName;
		private String agencyAddress;
		private String agencyPhoneNum;
		private int quantity;
		private String dueDate;
		private String modelId;
		private String userName;
		private String userId;
		private String area;
		private String state = "미완료";
		
		//주문서번호■주문서 작성일■대리점명■대리점 주소■전화번호■개수■납기일■모델명 사원이름 아이디 구역 상태
		/** Assign 클래스의 생성자이다.
		 * 
		 * @param id 주문서 아이디
		 * @param writeDate 주문서 작성일
		 * @param agencyName 대리점명
		 * @param agencyAddress 대리점 주소
		 * @param agencyPhoneNum 대리점 전화번호
		 * @param quantity 수량
		 * @param dueDate 납기일
		 * @param modelId 모델명
		 * @param userName 유통부 사원이름
		 * @param userId 유통부 사원번호
		 * @param area 유통부 사원 담당구역
		 * @param state 배송상태
		 */
		public Assign(String id, String writeDate, String agencyName, String agencyAddress, String agencyPhoneNum,
				int quantity, String dueDate, String modelId, String userName, String userId, Object area, String state) {

			this.id = id;
			this.writeDate = writeDate;
			this.agencyName = agencyName;
			this.agencyAddress = agencyAddress;
			this.agencyPhoneNum = agencyPhoneNum;
			this.quantity = quantity;
			this.dueDate = dueDate;
			this.modelId = modelId;
			this.userName = userName;
			this.userId = userId;
			this.area = (String) area;
			this.state = state;
		
			
			
		}
		
		/** 사원이름을 반환하는 메서드이다.
		 * 
		 * @return 사원이름
		 */
		public String getUserName() {
			return userName;
		}
		
		/** 사원이름을 설정하는 메서드이다.
		 * 
		 * @param userName 사원이름
		 */
		public void setUserName(String userName) {
			this.userName = userName;
			
		}
		
		/** 담당구역을 반환하는 메서드이다.
		 * 
		 * @return 담당구역
		 */
		public String getArea() {
			return area;
		}
		
		/** 사원번호를 반환하는 메서드이다.
		 * 
		 * @return 사원번호
		 */
		public String getUserId() {
			return userId;
		}
		
		/** 사원번호를 설정하는 메서드이다.
		 * 
		 * @param userId 사원번호
		 */
		public void setUserId(String userId) {
			this.userId = userId;
		}
		
		/** 주문서 아이디를 반환하는 메서드이다.
		 * 
		 * @return 주문서 아이디
		 */
		public String getId() {
			return id;
		}
		
		
		/** 주문서 작성일을 반환하는 메서드이다.
		 * 
		 * @return 주문서 작성일
		 */
		public String getWriteDate() {
			return writeDate;
		}
		
		
		/** 대리점명을 반환하는 메서드이다.
		 * 
		 * @return 대리점명
		 */
		public String getAgencyName() {
			return agencyName;
		}
		
		
		/** 대리점 주소를 반환하는 메서드이다.
		 * 
		 * @return 대리점 주소
		 */
		public String getAgencyAddress() {
			return agencyAddress;
		}
		
		/** 대리점 전화번호를 반환하는 메서드이다.
		 * 
		 * @return 대리점 전화번호
		 */
		public String getAgencyPhoneNum() {
			return agencyPhoneNum;
		}
		
	
		
		/** 수량을 반환하는 메서드이다.
		 * 
		 * @return 수량
		 */
		public int getQuantity() {
			return quantity;
		}
		
		/** 납기일을 반환하는 메서드이다.
		 *  
		 * @return 납기일
		 */
		public String getDueDate() {
			return dueDate;
		}

		/** 모델명을 반환하는 메서드이다.
		 * 
		 * @return
		 */
		public String getModelId() {
			return modelId;
		}


		/** 주문서 상태를 반환하는 메서드이다.
		 * 
		 * @return 주문서 상태
		 */
		public String getState() {
			return state;
		}
		
		/** 주문서 상태를 설정하는 메서드이다.
		 *  
		 * @param state 주문서 상태
		 */
		public void setState(String state) {
			this.state = state;
		}



	


		






	

}
