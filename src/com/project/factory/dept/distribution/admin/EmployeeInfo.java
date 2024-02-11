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
	
	public String getId() {
		return id;
	}
	
//	public void setId(String id) {
//		this.id = id;
//	}
	
	public String getName() {
		return name;
	}
	
//	public void setName(String name) {
//		this.name = name;
//	}
	
	public String getAssignedRegion() {
		return assignedRegion;
	}
	public void setAssignedRegion(String assignedRegion) {
		this.assignedRegion = assignedRegion;
	}
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
	 * @param phoneNum 유통부 사원번호
	 * @param assignedRegion 유통부 사원 담당구역
	 */
	public EmployeeInfo(String id, String name, String phoneNum,String assignedRegion) {
		this.id = id;
		this.name = name;
		this.assignedRegion = assignedRegion;
		this.phoneNum = phoneNum;
	}


	
	
}

