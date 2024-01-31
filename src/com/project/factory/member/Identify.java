package com.project.factory.member;

//TODO 로그인한 사용자 정보 저장
/**
 * 로그인한 사용자 정보 저장 클래스
 */
public class Identify {
	// 인증 티켓(= 사용자가 인증을 완료했음을 나타내는 값)
	public static String auth;
	// 관리자(1), 사원(2), 대리점(3) 구분
	public static String level;
	// 부서(생산, 유통, 인사, 경영) 
	public static String dept;
}
