package com.project.factory.dept.production.user;

import java.util.Scanner;

import com.project.factory.view.MainView;
import com.project.factory.view.dept.ProductionView;

public class CheckPiece {

	public static void pieceMenu() {
		Scanner sc = new Scanner(System.in);
		ProductionView.checkPieceMenu();
		System.out.print("번호 입력: ");
		int sel = sc.nextInt();
		if(sel == 1) {
			checkPiece();
			MainView.pause();
		}else if (sel == 2) {
			addPiece();
		}
				
		}
		
	

	private static void checkPiece() {
		ProductionView.checkPiece();
		
	}

	private static void addPiece() {
		Scanner sc = new Scanner(System.in);
		ProductionView.addPieceMenu();
		
		
	}

}
