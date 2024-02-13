package com.project.factory.dept.distribution.admin;

/** 유통부 사원의 정보 나타내는 클래스이다.
 * 
 */

public class EmployeeInfo {
	private String id;
	private String name;
	private String assignedRegion;
	private String phoneNum;
	
	

//	public void setMember(Members member) {
//		this.member = member;
//	}
	
	/** 사원번호를 반환하는 메서드이다.
	 * 
	 * @return 사원번호
	 */
	public String getId() {
		return id;
	}
	
//	public void setId(String id) {
//		this.id = id;
//	}
	
	/** 사원이름을 반환하는 메서드이다.
	 * 
	 * @return 사원이름
	 */
	public String getName() {
		return name;
	}
	
//	public void setName(String name) {
//		this.name = name;
//	}
	
	/** 사원의 배정된 구역을 반환하는 메서드이다.
	 * 
	 * @return 배정된 구역
	 */
	public String getAssignedRegion() {
		return assignedRegion;
	}
	
	/** 사원의 배정된 구역을 설정하는 메서드이다.
	 * 
	 * @param assignedRegion 배정된 구역
	 */
	public void setAssignedRegion(String assignedRegion) {
		this.assignedRegion = assignedRegion;
	}
	/** 사원 전화번호를 반환하는 메서드이다.
	 * 
	 * @return 사원 전화번호
	 */
	public String getPhoneNum() {
		return phoneNum;
	}
//	public void setPhoneNum(String phoneNum) {
//		this.phoneNum = phoneNum;
//	}
	/** 유통부 사원 정보 생성자
	 * 
	 * @param id 유통부 사원번호
	 * @param name 유통부 사원이름
	 * @param phoneNum 유통부 사원 전화번호
	 * @param assignedRegion 유통부 사원 담당구역
	 */
	public EmployeeInfo(String id, String name, String phoneNum,String assignedRegion) {
		this.id = id;
		this.name = name;
		this.assignedRegion = assignedRegion;
		this.phoneNum = phoneNum;
	}


	
	
}

