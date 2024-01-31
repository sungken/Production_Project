package com.project.factory.member;

import java.util.Scanner;

import com.project.factory.resource.Data;

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
				System.out.println("성공");
				System.out.println(Identify.level);
				System.out.println(Identify.dept);
				

			}else {
				System.out.println("실패");
			}

		}
		
		if (Identify.auth != null) {
			return true;
		} else {
			return false;
		}
	}
}
