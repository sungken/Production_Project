package com.project.factory.member;

import java.util.Scanner;

import com.project.factory.Main;
import com.project.factory.resource.Data;
import com.project.factory.resource.Members;
import com.project.factory.view.MainView;

public class Login {
	public static void login() {
		Scanner scan = new Scanner(System.in);
		System.out.print("아이디 입력: ");
		String id = scan.nextLine();
		System.out.print("비밀번호 입력: ");
		String pw = scan.next();

		for (Members member : Data.memberList) {
			if (member.getId().equals(id) && member.getPw().equals(pw)) {
				Identify.auth = id;
				Identify.level = member.getLevel();
				Identify.dept = member.getDept();
				Identify.name = member.getName();
				break;
			}
			// 아이디는 맞고 비밀번호 틀렸을시
			else if (member.getId().equals(id) && !member.getPw().equals(pw)) {
				System.out.println("비밀번호를 잘못 입력했습니다");
				MainView.checkContinue();
				MainView.singnleLine();
				if (Main.answer.equals("Y") || Main.answer.equals("y")) {
					login();
				} else if(Main.answer.equals("N") || Main.answer.equals("n")) {
				break;
				}
				else {
					System.out.println("잘못된 입력입니다. 다시 입력하세요.");
					MainView.checkContinue();
				}
				
			}
			// 비밀번호는 맞고 아이디는 틀렸을시
			else if (member.getPw().equals(pw) && !member.getId().equals(id)) {
				System.out.println("아이디를 잘못 입력했습니다");
				MainView.checkContinue();
				MainView.singnleLine();
				if (Main.answer.equals("Y") || Main.answer.equals("y")) {
					login();
				} else if(Main.answer.equals("N") || Main.answer.equals("n")) {
				break;
				}
				else {
					System.out.println("잘못된 입력입니다. 다시 입력하세요.");
					MainView.checkContinue();
				}
			}
			// 둘다 틀릴경우
			else if(!member.getPw().equals(pw) && !member.getId().equals(id)){
				System.out.println("아이디와 비밀번호를 잘못 입력했습니다");
				MainView.checkContinue();
				MainView.singnleLine();
				if (Main.answer.equals("Y") || Main.answer.equals("y")) {
					login();
				} else if(Main.answer.equals("N") || Main.answer.equals("n")) {
				break;
				}
				else {
					System.out.println("잘못된 입력입니다. 다시 입력하세요.");
				}
			}

		}
		MainView.pause();
	}
}
