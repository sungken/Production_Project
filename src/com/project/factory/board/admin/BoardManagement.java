package com.project.factory.board.admin;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

import com.project.factory.Main;
import com.project.factory.Today;
import com.project.factory.member.Identify;
import com.project.factory.resource.Path;
import com.project.factory.view.BoardManagementView;
import com.project.factory.view.MainView;

//TODO WriteBoard 클래스명 > BoardManagement으로 수정 
public class BoardManagement {
	
	//TODO 공지사항 데이터에 작성일 추가
	//공지사항번호■작성자ID(사원번호)■제목■내용■작성일■삭제할날짜
	public static String board;
	public static String today;
	public static int noticeNumber;
	

	static {
		board = Path.BOARD;
		today = Today.day();
		noticeNumber = 1;
	}

	
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

	}// boardManagement

	private static void boardWrite() {

		try {
			 // 작성자 ID 설정
            String writerId = Identify.auth;

            // 공지사항 번호 설정
            int noticeId = noticeNumber++;
            
			BufferedWriter writer = new BufferedWriter(new FileWriter(board, true));
			
			String deleteDate = ""; // 삭제할 날짜
			String title = ""; // 제목
//			String contents = ""; //내용
			StringBuilder contents = new StringBuilder(); // 내용을 저장할 StringBuilder

			Scanner scan = new Scanner(System.in);

			System.out.println();
			MainView.doubleLine();
			System.out.println("날짜: " + BoardManagement.today);
			MainView.doubleLine();

			System.out.print("삭제할 날짜: ");
			deleteDate = scan.nextLine(); //삭제할 날짜 유효성 검사 필요
			System.out.print("제목: ");
			title = scan.nextLine();
			System.out.print("내용(종료하려면 빈 줄에서 엔터를 두 번 입력하세요) : ");
			while (true) {
                String line = scan.nextLine(); // 한 줄씩 입력받음
                if (line.isEmpty()) { // 입력이 빈 줄인 경우 반복문 종료
                    break;
                }
                contents.append(line).append("\\n"); //줄바꿈된 상태로 저장하지 말고  줄바꿈 문자를 추가하여 표시
                //contents.append(line).append("\n"); // 입력된 줄을 StringBuilder에 추가
            }
			
			// 파일에 공지사항 정보 작성
			//공지사항번호■작성자ID(사원번호)■제목■내용■작성일■삭제할날짜
            writer.write(noticeId + "■" + writerId + "■" + title + "■" + contents.toString().trim() + "■" + today + "■" + deleteDate);
            writer.newLine();
            writer.close();

            System.out.println("게시글이 성공적으로 작성되었습니다.");
            
            MainView.pause();
            
		} catch (Exception e) {
			System.out.println("BoardManagement.boardWrite");
			e.printStackTrace();
		}
	}

	private static void boardEdit() {
		// TODO Auto-generated method stub

	}

	private static void boardDelete() {
		// TODO Auto-generated method stub

	}
}
