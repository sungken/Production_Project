package com.project.factory.board.admin;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.project.factory.Main;
import com.project.factory.Today;
import com.project.factory.member.Identify;
import com.project.factory.resource.BoardData;
import com.project.factory.resource.Path;
import com.project.factory.view.BoardManagementView;
import com.project.factory.view.MainView;

//TODO WriteBoard 클래스명 > BoardManagement으로 수정 
public class BoardManagement {

	public static String regex = ""; // 유효성 검사를 위한 변수

	// TODO 공지사항 데이터에 작성일 추가
	// 공지사항번호■작성자ID(사원번호)■제목■내용■작성일■삭제할날짜

	public static void boardManagement() {

		BoardData.load();

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
			MainView.pause();
		}

	}// boardManagement

	private static void boardWrite() {

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(Path.BOARD, true)); // true인 경우 이어쓰기

			BoardData.setNewNoticeNumber(); // 공지사항 번호 설정

			// 공지사항번호■작성자ID(사원번호)■제목■내용■작성일■삭제할날짜
			int noticeNumber = BoardData.getNoticeNumber();
			String id = Identify.auth;
			String title = ""; // 제목
			StringBuilder contents = new StringBuilder(); // 내용을 저장할 StringBuilder
			String deleteDate = ""; // 삭제할 날짜

			Scanner scan = new Scanner(System.in);

			System.out.println();
			MainView.doubleLine();
			System.out.println("날짜: " + Today.day());
			MainView.doubleLine();

			while (true) {
				System.out.print("삭제할 날짜: ");
				deleteDate = scan.nextLine();

				if (!Today.checkDate(deleteDate)) {
					System.out.println();
					System.out.println("잘못된 형식의 날짜입니다.");
					System.out.println("날짜는 10글자(하이픈 포함), 숫자만 입력 가능합니다.");
					System.out.println();
				} else {
					if (checkDeleteDate(deleteDate)) {
						System.out.println();
						System.out.println("삭제할 날짜는 작성일보다 과거로 설정할 수 없습니다.");
						System.out.println();
					} else {
						break;
					}
				}
			} // while

			while (true) {
				System.out.print("제목: ");
				title = scan.nextLine();

				if (BoardManagement.invalidateTitle(title)) {
					System.out.println();
					System.out.println("제목은 최대 30글자까지 입력 가능합니다.");
					System.out.println();
				} else {
					break;
				}
			} // while

			System.out.print("내용(종료하려면 빈 줄에서 엔터를 두 번 입력하세요.) : ");
			while (true) {
				String line = scan.nextLine(); // 한 줄씩 입력받음
				if (line.isEmpty()) { // 입력이 빈 줄인 경우 반복문 종료
					break;
				}
				contents.append(line).append("\\n"); // 줄바꿈된 상태로 저장하지 말고 줄바꿈 문자를 추가하여 표시
			}
			if (invalidateContents(contents.toString())) {
				System.out.println();
				System.out.println("내용은 최대 200자까지 입력 가능합니다.");
				System.out.println();
			} else {
				// 공지사항번호■작성자ID(사원번호)■제목■내용■작성일■삭제할날짜
				writer.write(noticeNumber + "■" + id + "■" + title + "■" + contents.toString().trim() + "■" + Today.day() + "■" + deleteDate);
				writer.newLine();
				writer.close();

				System.out.println("게시글이 성공적으로 작성되었습니다.");
				System.out.println("선택 화면으로 돌아갑니다.");

				BoardManagement.boardManagement();
			}
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

	// 유효성 검사
	// java.util.Date와 java.sql.Date는 서로 다른 클래스입니다. 따라서 직접적인 형변환이 불가능
	private static boolean checkDeleteDate(String deleteDate) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

			// 삭제 날짜를 Calendar 객체로 변환
			Calendar deleteDateCal = Calendar.getInstance();
			deleteDateCal.setTime(dateFormat.parse(deleteDate));

			// 삭제 날짜가 현재 날짜보다 이전인지 검사
			return deleteDateCal.before(Today.today);

		} catch (ParseException e) {
			System.out.println("BoardManagement.checkDeleteDate");
			e.printStackTrace();
		}
		return false;
	}

	private static boolean invalidateTitle(String title) {
		// 제목 > 최대 30글자
		return title.length() > 30;
	}

	private static boolean invalidateContents(String contents) {
		// 내용 > 최대 200글자
		return contents.length() > 200;
	}

//	private static void checkContinue() {
//
//		MainView.checkContinue();
//
//		if (Main.answer.equals("Y") || Main.answer.equals("y")) {
//			BoardManagement.boardManagement();
//		} else if (Main.answer.equals("N") || Main.answer.equals("n")) {
//			MainView.pause();
//		} else {
//			System.out.println();
//			MainView.singnleLine();
//			System.out.println();
//			System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
//			BoardManagement.checkContinue();
//		}
//
//	}
}
