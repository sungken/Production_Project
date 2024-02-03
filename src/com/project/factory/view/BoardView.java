package com.project.factory.view;

import com.project.factory.resource.dept.Board;
import com.project.factory.resource.dept.BoardData;

public class BoardView {

//	private static void boardView() {
//		
//	}
	
	//어차피 관리자만 공지사항을 작성할 수 있어서 부서만 출력하면 될 듯
	private static void boardListView() {
		System.out.printf("%-5s\t%-5s\t%-40S\t%-10S\n", "[번호]", "[부서]", "[제목]", "[작성일]");

		for (Board board : BoardData.boardList) {
			System.out.printf("%3d\t%10S\t%-40S\t%-10S\n", board.getNoticeNumber(), board.getDept(),
					board.getTitle().trim(), board.getWriteDate());
		}
	}
}
