package com.project.factory.board;

import java.util.Scanner;

import com.project.factory.Main;
import com.project.factory.board.admin.BoardManagement;
import com.project.factory.member.Identify;
import com.project.factory.resource.dept.Board;
import com.project.factory.resource.dept.BoardData;
import com.project.factory.view.BoardView;
import com.project.factory.view.MainView;

public class ReadBoard {

	static Scanner scan = new Scanner(System.in);
	
	static int noticeNumber = 0; // 공지사항 번호

	public static void readBoard() {

		BoardData.load();

		while (true) {

			BoardView.boardView();

			Main.selectNum = scan.nextLine(); // 입력 받기

			if (!Main.selectNum.isEmpty()) { // 입력이 공백이 아닌 경우
				if (BoardManagement.isInteger(Main.selectNum)) { // 정수값인지 확인

					ReadBoard.noticeNumber = Integer.parseInt(Main.selectNum); // 확인할 공지사항 번호

					// 유효한 공지사항 번호인지 확인
					if (ReadBoard.checkNoticeNumberExists()) {
						BoardView.boardDetailView(ReadBoard.noticeNumber);

						MainView.pauseToSel();

					} else {
						System.out.println("잘못된 번호입니다.");
						if (MainView.checkContinueBoolean()) {
							continue;
						} else {
							MainView.pause();
							return;
						}
					}
				} else {
					System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
					if (MainView.checkContinueBoolean()) {
						continue;
					} else {
						MainView.pause();
						return;
					}
				}
			} else {
				System.out.println("잘못된 번호입니다.");
				if (MainView.checkContinueBoolean()) {
					continue;
				} else {
					MainView.pause();
					return;
				}
			}
		} // while
	}// readBoard
	
	private static boolean checkNoticeNumberExists() {
		for (Board board : BoardData.boardList) {
			if (board.getNoticeNumber() == ReadBoard.noticeNumber) {
				return true;
			}
		}
		return false;
	}
}// ReadBoard
