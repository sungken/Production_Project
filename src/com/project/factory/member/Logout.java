package com.project.factory.member;

import com.project.factory.view.MainView;

/** 로그아웃 클래스이다.
 * 
 */
public class Logout {
	
	/** 로그아웃 기능을 수행하는 메서드이다.
	 * 
	 */
	public static void logout(){
		MainView.title("로그아웃");
		Identify.auth = null;
		Identify.dept = null;
		Identify.level = null;
		
		System.out.println();
		System.out.println("로그아웃되었습니다.");
		MainView.pause();
	}
	
//	MainView.pause;
	
	
}
