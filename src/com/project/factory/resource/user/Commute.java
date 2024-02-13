package com.project.factory.resource.user;

/** 근태 등록을 나타내는 클래스이다.
 * 
 */
public class Commute{
	//출근 인원 목록(관리자 기능)
	private String cal;
	private String id;
	private String name;
	private String dept;
	private String level;
	private String currentTime;
	private String commute;

	/** 근태 등록을 한 날짜를 반환하는 메서드이다.
	 * 
	 * @return 근태 등록을 한 날짜
	 */
	public String getCal() {
		return cal;
	}
	
	/** 사원번호를 반환하는 메서드이다. 
	 * 
	 * @return 사원번호
	 */
	public String getId() {
		return id;
	}

	/** 사원이름을 반환하는 메서드이다. 
	 * 
	 * @return 사원이름
	 */
	public String getName() {
		return name;
	}

	/** 사원부서를 반환하는 메서드이다.
	 *  
	 * @return 사원부서
	 */
	public String getDept() {
		return dept;
	}

	/** 사원직급을 반환하는 메서드이다.
	 * 
	 * @return 사원직급
	 */
	public String getLevel() {
		return level;
	}

	/** 근태 등록을 한 시간을 반환하는 메서드이다.
	 * 
	 * @return 근태 등록한 시간
	 */
	public String getCurrentTime() {
		return currentTime;
	}

	/** 근태 등록 상태(출근/퇴근)을 반환하는 메서드이다.
	 * 
	 * @return 근태 등록 상태(출근/퇴근)
	 */
	public String getCommute() {
		return commute;
	}
	
	/** 근태 등록 상태(출근/퇴근)을 설정하는 메서드이다
	 * 
	 * @param commute 근태 등록 상태(출근/퇴근)
	 */
	public void setCommute(String commute) {
		this.commute = commute;
	}

	
	/** Commute 클래스의 생성자
	 * @param cal = 출근 날짜
	 * @param id = 사원번호
	 * @param name = 이름
	 * @param dept = 부서
	 * @param level = 권한
	 * @param currentTime = 출근시간 
	 * @param commute = 출/퇴근 상태
	 */
	
	
	public Commute(String cal ,String id, String name, String dept, String level, String currentTime, String commute) {
		this.cal = cal;
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.level = level;
		this.currentTime = currentTime;
		this.commute = commute;
	}

	
}
