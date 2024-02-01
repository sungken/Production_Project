package com.project.factory.member;

public class Logout {
	
	public static void logout(){
		Identify.auth = null;
		Identify.dept = null;
		Identify.level = null;
		System.out.println("로그아웃되었습니다.");
	}
	
//	MainView.pause;
	
	
}
