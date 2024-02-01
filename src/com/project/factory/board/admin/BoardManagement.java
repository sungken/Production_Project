package com.project.factory.board.admin;

import java.util.Scanner;

import com.project.factory.Main;
import com.project.factory.view.BoardManagementView;

//TODO WriteBoard 클래스명 > BoardManagement으로 수정 
public class BoardManagement {

	public static void boardManagement() {
		
		Scanner scan = new Scanner(System.in);
		
		BoardManagementView.boardManagementMenu();
		
		Main.selectNum = scan.nextLine();

		if (Main.selectNum.equals("1")) {
			BoardManagement.boardWrite();
		} else if (Main.selectNum.equals("2")) {
			BoardManagement.boardEdit();
		} else if (Main.selectNum.equals("3")) {
			BoardManagement.boardDelete();
		} else {
			System.out.println("잘못된 번호입니다.");
		}
		
	}//boardManagement

	private static void boardWrite() {
		// TODO Auto-generated method stub
		
	}
	
	private static void boardEdit() {
		// TODO Auto-generated method stub
		
	}
	
	private static void boardDelete() {
		// TODO Auto-generated method stub
		
	}
}
