package com.project.factory.view;

public class BoardManagementView {

	public static void boardManagementMenu() {
		System.out.println();
		MainView.doubleLine();
		System.out.println("          공지사항 관리");
		MainView.doubleLine();

		System.out.println();
		System.out.println("1. 공지사항 등록");
		System.out.println("2. 공지사항 수정");
		System.out.println("3. 공지사항 삭제");
		System.out.println();
		MainView.singnleLine();
		System.out.print("번호 입력: ");
	}
	
	public static void boardEditMenu() {
		System.out.println();
		System.out.println("1. 삭제 날짜");
		System.out.println("2. 제목");
		System.out.println("3. 내용");
		System.out.println();
		MainView.singnleLine();
		System.out.print("번호 입력: ");
	}
	
	
	public sta
}
