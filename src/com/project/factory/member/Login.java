package com.project.factory.member;

import java.util.Scanner;

import com.project.factory.Main;
import com.project.factory.resource.Data;
import com.project.factory.view.MainView;

public class Login {
	public static boolean login() {
		Scanner scan = new Scanner(System.in);
		System.out.print("아이디 입력: ");
		String id = scan.nextLine();
		System.out.print("비밀번호 입력: ");
		String pw = scan.next();
		
		for (int i = 0; i < Data.memberList.size(); i++) {
			if (Data.memberList.get(i).getId().equals(id) && Data.memberList.get(i).getPw().equals(pw)) {
				Identify.auth = id;
				Identify.level = Data.memberList.get(i).getLevel();
				Identify.dept = Data.memberList.get(i).getDept();
				//아이디가 잘못입력된 경우
			}else if(Data.memberList.get(i).getId().equals(id) && !Data.memberList.get(i).getPw().equals(pw)) {
				System.out.println("아이디를 잘못 입력했습니다");
				MainView.checkContinue();
				MainView.singnleLine();
				if(Main.answer == "Y") {
					login();
				}else {
					MainView.mainMenu();
				}
				
			}else if(!Data.memberList.get(i).getId().equals(id) && Data.memberList.get(i).getPw().equals(pw)) {
				System.out.println("비밀번호를 잘못 입력했습니다");
				MainView.checkContinue();
				MainView.singnleLine();
				if(Main.answer == "Y") {
					login();
				}else {
					MainView.mainMenu();
				}
				
			}else {
				System.out.println("아이디와 비밀번호를 잘못 입력했습니다");
				MainView.checkContinue();
				MainView.singnleLine();
				if(Main.answer == "Y") {
					login();
				}else {
					MainView.mainMenu();
				}
			}

		}
		
		if (Identify.auth != null) {
			return true;
		} else {
			return false;
		}
	}
}
