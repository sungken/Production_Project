package com.project.factory.dept.human.admin;

/** 신입사원 정보를 나타내는 클래스이다.
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


	/** 신입사원 사원번호를 반환하는 메서드이다.
	 * 
	 * @return 신입사원 사원번호
	 */
	public String getId() {
		return id;
	}



	/** 신입사원 사원번호를 설정하는 메서드이다.
	 * 
	 * @param id 신입사원 사원번호
	 */
	public void setId(String id) {
		this.id = id;
	}

	
	/** 신입사원 이름을 반환하는 메서드이다.
	 *  
	 * @return 신입사원 이름
	 */
	public String getName() {
		return name;
	}

	/** 신입사원 이름을 설정하는 메서드이다.
	 * 
	 * @param name 신입사원 이름
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/** 신입사원 비밀번호를 반환하는 메서드이다.
	 * 
	 * @return 신입사원 비밀번호
	 */
	public String getPw() {
		return pw;
	}



	/** 신입사원 비밀번호를 설정하는 메서드이다.
	 * 
	 * @param pw 신입사원 비밀번호
	 */
	public void setPw(String pw) {
		this.pw = pw;
	}





	/** 신입사원 생년월일을 반환하는 메서드이다.
	 * 
	 * @return 신입사원 생년월일
	 */
	public String getBirth() {
		return birth;
	}



	/** 신입사원 전화번호를 반환하는 메서드이다.
	 * 
	 * @return 신입사원 전화번호
	 */
	public String getPhoneNum() {
		return phoneNum;
	}


	/** 신입사원 주소를 반환하는 메서드이다.
	 * 
	 * @return 신입사원 주소
	 */
	public String getAddress() {
		return address;
	}



	/** 신입사원의 부서를 반환하는 메서드이다.
	 * 
	 * @return 신입사원 부서
	 */

	public String getDept() {
		return dept;
	}



	/** 신입사원의 직급을 반환하는 메서드이다.
	 * 
	 * @return 신입사원 직급
	 */
	public String getLevel() {
		return level;
	}



	
	/** NewMembers 클래스의 생성자이다.
	 * 
	 * @param id 신입사원 사원번호
	 * @param pw 신입사원 비밀번호
	 * @param name 신입사원 이름
	 * @param phoneNum 신입사원 전화번호
	 * @param birth 신입사원 생년월일
	 * @param address 신입사원 주소
	 * @param dept 신입사원 부서
	 * @param level 신입사원 직급
	 */

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


}
