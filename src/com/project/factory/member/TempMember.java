package com.project.factory.member;

public class TempMember {
	//553277A■134113411341■손진원■840924■010-7533-1895■서울특별시 강남구 언주로47길■1■생산■553277A@auto.com
	private String memberId;
	private String pw;
	private String name;
	private String birth;
	private String phoneNum;
	private String address;
	private int grade;
	private String dept;
	private String email;
	
	
	public TempMember(String memberId, String pw, String name, String birth, String phoneNum, String address, int grade,
			String dept, String email) {

		this.memberId = memberId;
		this.pw = pw;
		this.name = name;
		this.birth = birth;
		this.phoneNum = phoneNum;
		this.address = address;
		this.grade = grade;
		this.dept = dept;
		this.email = email;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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


	public int getGrade() {
		return grade;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}


	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
	    return "TempMember{" +
	            "\r\n  memberId='" + memberId + '\'' +
	            "\r\n  pw='" + pw + '\'' +
	            "\r\n  name='" + name + '\'' +
	            "\r\n  birth='" + birth + '\'' +
	            "\r\n  phoneNum='" + phoneNum + '\'' +
	            "\r\n  address='" + address + '\'' +
	            "\r\n  grade=" + grade +
	            "\r\n  dept='" + dept + '\'' +
	            "\r\n  email='" + email + '\'' +
	            "\r\n}";
	}


	
	

}
