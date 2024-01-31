package com.project.factory.view.member;

import java.util.Scanner;

import com.project.factory.member.Login;

public class LoginView {
	public static void loginView() {
		Scanner scan = new Scanner(System.in);
//		Main.title();
		System.out.println("--------------------------");
		System.out.print("아이디(사원번호) : ");
		String id = scan.nextLine();
		
		System.out.print("비밀번호 : ");
		String pw = scan.nextLine();
		
		if(Login.login(id, pw)) {
			System.out.println("로그인이 완료되었습니다.");
//			MainView.pause();
		}else {
			System.out.println("로그인이 실패하였습니다.");
			loginView();
		}
	}
}
