package com.project.factory.board.admin;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import com.project.factory.Main;
import com.project.factory.Today;
import com.project.factory.member.Identify;
import com.project.factory.resource.Data;
import com.project.factory.resource.Members;
import com.project.factory.resource.Path;
import com.project.factory.resource.dept.Board;
import com.project.factory.resource.dept.BoardData;
import com.project.factory.view.BoardManagementView;
import com.project.factory.view.MainView;

//TODO WriteBoard 클래스명 > BoardManagement으로 수정 
public class BoardManagement {

	public static String regex = ""; // 유효성 검사를 위한 변수
	public static int noticeNumber = 0; // 공지사항 번호
	public static String title = ""; // 제목
	public static StringBuilder contents = new StringBuilder(); // 내용을 저장할 StringBuilder
	public static String deleteDate = ""; // 삭제할 날짜

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
			System.out.println();
			System.out.println("잘못된 번호입니다.");
			if (MainView.checkContinueBoolean()) {
				BoardManagement.boardManagement();
				return;
			} else {
				MainView.pause();
				return;
			}
		}

	}// boardManagement

	private static void boardWrite() {

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(Path.BOARD, true)); // true인 경우 이어쓰기

			BoardData.setNewNoticeNumber(); // 공지사항 번호 설정

			Scanner scan = new Scanner(System.in);

			System.out.println();
			MainView.singnleLine();
			System.out.println("          공지사항 작성");
			MainView.singnleLine();
			System.out.println();
			// MainView.doubleLine();
			System.out.println("날짜: " + Today.day());
			MainView.doubleLine();

			if (BoardManagement.writeDeleteDate(scan)) {

				if (BoardManagement.writeTitle(scan)) {

					if (BoardManagement.writeContents(scan)) {
						// 공지사항번호■작성자ID(사원번호)■제목■내용■작성일■삭제할날짜
						writer.write(BoardData.getNoticeNumber() + "■" + Identify.auth + "■" + BoardManagement.title
								+ "■" + BoardManagement.contents.toString().trim() + "■" + Today.day() + "■"
								+ BoardManagement.deleteDate);
						writer.newLine();
						writer.close();

						System.out.println("게시글이 성공적으로 작성되었습니다.");
						BoardManagement.pause(scan);

						BoardManagement.boardManagement();
						return;
					} else {
						BoardManagement.pause(scan);

						BoardManagement.boardManagement();
						return;
					}
				} else {
					BoardManagement.pause(scan);

					BoardManagement.boardManagement();
					return;
				}
			} else {
				BoardManagement.pause(scan);

				BoardManagement.boardManagement();
				return;
			}

		} catch (Exception e) {
			System.out.println("BoardManagement.boardWrite");
			e.printStackTrace();
		}
	}

	// 공지사항 수정
	private static void boardEdit() {

		Scanner scan = new Scanner(System.in);

		// int 값만 입력 가능
		while (true) {
			BoardManagementView.boardEditView();

			if (scan.hasNextInt()) {

				BoardManagement.noticeNumber = scan.nextInt(); // 수정할 공지사항 번호

				scan.nextLine(); // 비우기

				// 유효한 공지사항 번호인지 확인
				if (checkNoticeNumberExists()) {
					while (true) {
						BoardManagementView.boardEditMenu();

						Main.selectNum = scan.nextLine();

						if (Main.selectNum.equals("1")) {
							BoardManagement.boardEditDeleteDate(scan, BoardManagement.noticeNumber);
							break;
						} else if (Main.selectNum.equals("2")) {
							BoardManagement.boardEditTitle(scan, BoardManagement.noticeNumber);
							break;
						} else if (Main.selectNum.equals("3")) {
							BoardManagement.boardEditcontents(scan, BoardManagement.noticeNumber);
							break;
						} else {
							System.out.println("잘못된 번호입니다.");
							if (MainView.checkContinueBoolean()) {
								continue;
							} else {
								BoardManagement.pause(scan);

								BoardManagement.boardEdit();
								return;
							}
						}
					}
				} else {
					System.out.println("잘못된 번호입니다.");

					if (MainView.checkContinueBoolean()) {
						continue;
					} else {
						BoardManagement.pause(scan);

						BoardManagement.boardManagement();
						return;
					}
				}

				break;

			} else {
				System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
				scan.nextLine(); // 비우기

				if (MainView.checkContinueBoolean()) {
					continue;
				} else {
					BoardManagement.boardManagement();
					return;
				}
			}
		} // while
	}// boardEdit

	private static void boardDelete() {
		boolean loop = true;
		Scanner scan = new Scanner(System.in);

		// int 값만 입력 가능
		while (true) {
			BoardManagementView.boardDeleteView();

			if (scan.hasNextInt()) {
				BoardManagement.noticeNumber = scan.nextInt(); // 수정할 공지사항 번호

				scan.nextLine(); // 비우기

				for (Board board : BoardData.boardList) {
					if (board.getNoticeNumber() == BoardManagement.noticeNumber) {
						BoardData.boardList.remove(board);// 해당 board 삭제

						BoardData.save();

						System.out.println();
						System.out.println("공지사항이 성공적으로 삭제되었습니다.");

						break;
					}
				}

				if (loop) {
					BoardManagement.pause(scan);
					
					BoardManagement.boardManagement();
					return;
				} else {
					System.out.println("잘못된 번호입니다.");

					if (MainView.checkContinueBoolean()) {
						continue;
					} else {
						BoardManagement.pause(scan);

						BoardManagement.boardManagement();
						return;
					}
				}

			} else {
				System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
				scan.nextLine(); // 비우기

				if (MainView.checkContinueBoolean()) {
					continue;
				} else {
					BoardManagement.pause(scan);
					
					BoardManagement.boardManagement();
					return;
				}
			}
		} // while
	}// boardDelete

	// 수정 메서드
	private static void boardEditDeleteDate(Scanner scan, int noticeNumber) {

		while (true) {
			if (BoardManagement.writeDeleteDate(scan)) {
				if (checkDeleteDateChange(noticeNumber, BoardManagement.deleteDate)) {
					BoardData.save();

					System.out.println();
					System.out.println("삭제 날짜가 성공적으로 수정되었습니다.");
					BoardManagement.pause(scan);

					BoardManagement.boardManagement();
					return;

				} else {
					System.out.println("변경된 내용이 없습니다.");

					if (MainView.checkContinueBoolean()) {
						BoardManagement.pause(scan);

						continue;

					} else {
						BoardManagement.pause(scan);

						BoardManagement.boardEdit();
						return;
					}
				}
			} else {

				BoardManagement.boardManagement();
				return;
			}
		}

	}// boardEditDeleteDate

	private static void boardEditTitle(Scanner scan, int noticeNumber) {
		while (true) {
			if (BoardManagement.writeTitle(scan)) {
				if (checkTitleChange(noticeNumber, BoardManagement.title)) {
					BoardData.save();

					System.out.println();
					System.out.println("제목이 성공적으로 수정되었습니다.");
					BoardManagement.pause(scan);

					BoardManagement.boardManagement();
					return;

				} else {
					System.out.println("변경된 내용이 없습니다.");

					if (MainView.checkContinueBoolean()) {
						BoardManagement.pause(scan);

						continue;

					} else {
						BoardManagement.pause(scan);

						BoardManagement.boardEdit();
						return;
					}
				}
			} else {
				BoardManagement.boardManagement();
				return;
			}
		}
	}// boardEditTitle

	private static void boardEditcontents(Scanner scan, int noticeNumber) {
		while (true) {
			// TODO 공지사항 내용 출력 수정
			for (Board board : BoardData.boardList) {
				if (board.getNoticeNumber() == noticeNumber) {
					System.out.println("기존 내용 :" + board.getContents());
					break;
				}
			}

			if (BoardManagement.writeContents(scan)) {
				if (checkContentsChange(noticeNumber, BoardManagement.contents)) {
					BoardData.save();

					System.out.println();
					System.out.println("내용이 성공적으로 수정되었습니다.");
					BoardManagement.pause(scan);

					BoardManagement.boardManagement();
					return;

				} else {
					System.out.println("변경된 내용이 없습니다.");

					if (MainView.checkContinueBoolean()) {
						BoardManagement.pause(scan);

						continue;

					} else {
						BoardManagement.pause(scan);

						BoardManagement.boardEdit();
						return;
					}
				}
			} else {
				BoardManagement.boardManagement();
				return;
			}
		}
	}// boardEditcontents

	// 작성 메서드
	private static boolean writeDeleteDate(Scanner scan) {
		while (true) {
			System.out.print("삭제할 날짜: ");
			BoardManagement.deleteDate = scan.nextLine();

			if (!Today.checkDate(BoardManagement.deleteDate) || !Today.inValidDate(deleteDate)) {
				System.out.println();
				System.out.println("잘못된 형식의 날짜입니다.");
				System.out.println("날짜는 10글자(하이픈 포함), 숫자만 입력 가능합니다.");

				if (MainView.checkContinueBoolean()) {
					continue;
				} else {
					return false;
				}

			} else {
				if (checkDeleteDate(BoardManagement.deleteDate)) {
					System.out.println();
					System.out.println("삭제할 날짜는 작성일보다 과거로 설정할 수 없습니다.");

					if (MainView.checkContinueBoolean()) {
						continue;
					} else {
						return false;
					}

				} else {
					return true;
				}
			}
		}
	}

	private static boolean writeTitle(Scanner scan) {
		while (true) {
			System.out.print("제목: ");
			BoardManagement.title = scan.nextLine();

			if (BoardManagement.invalidateTitle(BoardManagement.title)) {
				System.out.println();
				System.out.println("제목은 최대 30글자까지 입력 가능합니다.");

				if (MainView.checkContinueBoolean()) {
					continue;
				} else {
					return false;
				}

			} else {
				return true;
			}
		}
	}

	private static boolean writeContents(Scanner scan) {
		while (true) {
			System.out.print("내용(종료하려면 빈 줄에서 엔터를 두 번 입력하세요.) : ");
			while (true) {
				String line = scan.nextLine(); // 한 줄씩 입력받음
				if (line.isEmpty()) { // 입력이 빈 줄인 경우 반복문 종료
					break;
				}
				BoardManagement.contents.append(line).append("\\n"); // 줄바꿈된 상태로 저장하지 말고 줄바꿈 문자를 추가하여 표시
			}
			if (invalidateContents(BoardManagement.contents.toString())) {
				System.out.println();
				System.out.println("내용은 최대 200자까지 입력 가능합니다.");

				if (MainView.checkContinueBoolean()) {
					continue;
				} else {
					return false;
				}
			} else {
				return true;
			}
		}
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
			return deleteDateCal.before(Today.calendar);

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

	private static boolean checkNoticeNumberExists() {
		for (Board board : BoardData.boardList) {
			if (board.getNoticeNumber() == BoardManagement.noticeNumber) {
				return true;
			}
		}
		return false;
	}

	// 중복성 검사
	private static boolean checkDeleteDateChange(int noticeNumber, String deleteDate) {
		for (Board board : BoardData.boardList) {
			if (board.getNoticeNumber() == noticeNumber) {
				if (board.getDeleteDate().equals(deleteDate)) {
					return false;

				} else {
					board.setDeleteDate(deleteDate); // 수정
					return true;
				}
			}
		} // for
		return false;
	}

	public static boolean checkTitleChange(int noticeNumber, String title) {
		for (Board board : BoardData.boardList) {
			if (board.getNoticeNumber() == noticeNumber) {
				if (board.getTitle().equals(title)) {
					return false;

				} else {
					board.setTitle(title); // 수정
					return true;
				}
			}
		} // for
		return false;
	}

	private static boolean checkContentsChange(int noticeNumber, StringBuilder contents) {
		for (Board board : BoardData.boardList) {
			if (board.getNoticeNumber() == noticeNumber) {
				if (board.getContents().equals(contents)) {
					return false;
				} else {
					board.setContents(contents.toString().trim()); // 수정
					return true;
				}
			}
		} // for
		return false;
	}

	private static void pause(Scanner scan) {
		System.out.println("엔터를 치면 선택 화면으로 돌아갑니다.");
		scan.nextLine();
		System.out.println();
	}
}
