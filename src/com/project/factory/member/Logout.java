package com.project.factory.member;

public class Logout {
	
	public static void logout(){
		Identify.auth = null;
		Identify.dept = null;
		Identify.level = null;
	}
	
//	MainView.pause;
	
	
}
