package com.project.factory.view.member;

import com.project.factory.view.MainView;

//TODO ModifyView 클래스 생성
public class ModifyView {

	// TODO modifyMenu 메서드 생성
	public static void modifyMenu() {
		System.out.println();
		MainView.doubleLine();
		System.out.println("      개인정보 조회 및 수정");
		MainView.doubleLine();

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
