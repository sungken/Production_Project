package com.project.factory.dept.human.admin;

/** 신입사원 정보를 객체로 저장하는 클래스이다.
 * 
 */
public class NewMembers {
	
	private String id ;
	private String pw;
	private String name;
	private String phoneNum;
	private String birth;
	private String address;
	private String dept;
	private String level;


	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	

	public String getPw() {
		return pw;
	}




	public void setPw(String pw) {
		this.pw = pw;
	}






	public String getBirth() {
		return birth;
	}




	public void setBirth(String birth) {
		this.birth = birth;
	}




	public String getPhoneNum() {
		return phoneNum;
	}




	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public String getDept() {
		return dept;
	}




	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getLevel() {
		return level;
	}




	public void setLevel(String level) {
		this.level = level;
	}


	public NewMembers(String id, String pw, String name, String phoneNum, String birth, String address, String dept, String level) {
		this.id = "0";
		this.pw = "0000";
		this.name = name;
		this.phoneNum = phoneNum;
		this.birth = birth;
		this.address = address;
		this.dept = dept;
		this.level = level;
	}




	@Override
	public String toString() {
		return super.toString();
	}






















}
