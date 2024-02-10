package com.project.factory.dept.human.admin;

/** 신입사원에게 사원번호까지 부여한 정보를 객체로 저장하는 클래스이다.
 * 
 */
public class NewMembersTemp {
	//신규 입사자에서 사원번호까지 받은 사람들 리스트 (신입사원은 비밀번호가 없어서 멤버 리스트에 저장하면 나중에 사용할때 인덱스아웃오브 에러뜸)
	
	//449644A■차은우■010-1234-5678■920505■서울특별시 송파구 풍성로76길■생산■2
	
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


	public String getPw() {
		return pw;
	}




	public void setPw(String pw) {
		this.pw = pw;
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




	public NewMembersTemp(String id, String pw,String name, String phoneNum, String birth, String address, String dept,
			String level) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNum = phoneNum;
		this.birth = birth;
		this.address = address;
		this.dept = dept;
		this.level = level;
	}







}
