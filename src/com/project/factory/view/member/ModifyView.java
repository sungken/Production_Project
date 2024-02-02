package com.project.factory.view.member;

import com.project.factory.member.Identify;
import com.project.factory.resource.Data;
import com.project.factory.resource.Members;
import com.project.factory.view.MainView;

public class ModifyView {

	public static void modifyMenu() {
		System.out.println();
		MainView.doubleLine();
		System.out.println("       개인정보 조회 및 수정");
		MainView.doubleLine();

		for (Members member : Data.memberList) {
			if (member.getId().equals(Identify.auth)) {
				System.out.println("[이름]\t[전화번호]\t[주소]\t\t\t\t[비밀번호]");
				System.out.printf("%S\t%S\t%S\t\t%S\n", member.getName(), member.getPhoneNum(), member.getAddress(), member.getPw());
				break;
			}
		}
		MainView.singnleLine();

		System.out.println("수정하고 싶은 개인정보 번호를 선택해주세요.");
		System.out.println();
		System.out.println("1. 이름");
		System.out.println("2. 전화번호");
		System.out.println("3. 주소");
		System.out.println("4. 비밀번호");
		System.out.println();
		MainView.singnleLine();
		System.out.print("번호 입력: ");
	}
}
