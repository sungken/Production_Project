package com.project.factory.view;

import com.project.factory.resource.dept.Board;
import com.project.factory.resource.dept.BoardData;

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
	
	
	public static void boardManagementListView() {
		MainView.singnleLine();
		System.out.println("          공지사항 수정");
		MainView.singnleLine();
		
		System.out.println();
		MainView.singnleLine();
		
		for (Board board : BoardData.boardList) {	
			System.out.printf("%-5s\t%-10S\t%-30S\t%-10S\r\n","[번호]", "[작성일]", "[제목]", "[삭제 예정일]");
			System.out.printf("%3d\t%10S\t%-30S\t%-10S\n", board.getNoticeNumber(), board.getWriteDate(), board.getTitle().trim(), board.getDeleteDate());


		}
	}
}
