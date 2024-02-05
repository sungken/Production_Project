package com.project.factory.sub.agency;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

import com.project.factory.Main;
import com.project.factory.Today;
import com.project.factory.member.Identify;
import com.project.factory.resource.Path;
import com.project.factory.resource.dept.BoardData;
import com.project.factory.resource.sub.OrderData;
import com.project.factory.view.MainView;
import com.project.factory.view.sub.MyOrderView;

public class MyOrder {
	
	static Scanner scan = new Scanner(System.in);
	
	private static String id; //대리점ID
	private static String writeDate; //주문일
	private static String agencyName; //대리점명
	private static String agencyAddress; //대리점 주소
	private static String agencyPhoneNum; //대리점 전화번호
	private static int quantity; //수량
	private static String dueDate; //납기일
	private static String modelId; //모델ID
	
	public static void myOrder() {
		
		OrderData.load();
		
		MyOrderView.myOrderMenu();
		Main.selectNum = scan.nextLine();
		
		if (Main.selectNum.equals("1")) {
			MyOrder.orderAdd();
		} else if (Main.selectNum.equals("2")) {
			MyOrder.orderEdit();
		} else if (Main.selectNum.equals("3")) {
			MyOrder.orderDelete();
		} else if (Main.selectNum.equals("4")) {
			MyOrder.orderView();
		} else {
			System.out.println();
			System.out.println("잘못된 번호입니다.");
			if (MainView.checkContinueBoolean()) {
				MyOrder.myOrder();
				return;
			} else {
				MainView.pause();
				return;
			}
		}
	}//MyOrder
	
	private static void orderAdd() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(Path.BOARD, true)); // true인 경우 이어쓰기
			
			while (true) {
				
				MyOrderView.orderAddMenu();
				MyOrder.id = scan.nextLine();
				
				if (MyOrder.checkModelExists()) {

					if (MyOrder.writeQuantity()) {

						if (BoardManagement.writeTitle()) {

							if (BoardManagement.writeContents()) {
								// 공지사항번호■작성자ID(사원번호)■부서■제목■내용■작성일■삭제할날짜
								writer.write(BoardData.getNoticeNumber() + "■" + Identify.auth + "■" + Identify.dept
										+ "■" + BoardManagement.title + "■" + BoardManagement.contents.toString().trim()
										+ "■" + Today.day() + "■" + BoardManagement.deleteDate);
								writer.newLine();
								writer.close();

								System.out.println("게시글이 성공적으로 작성되었습니다.");
								MainView.pauseToSel();

								BoardManagement.boardManagement();
								return;
							} else {
								MainView.pauseToSel();

								BoardManagement.boardManagement();
								return;
							}
						} else {
							MainView.pauseToSel();

							BoardManagement.boardManagement();
							return;
						}
					} else {
						MainView.pauseToSel();

						BoardManagement.boardManagement();
						return;
					}

				} else {
					System.out.println();
					System.out.println("잘못된 번호입니다.");
					if (MainView.checkContinueBoolean()) {
						continue;
					} else {
						MyOrder.myOrder();;
						return;
					}
				}
			}
			
		} catch (Exception e) {
			System.out.println("MyOrder.orderAdd");
			e.printStackTrace();
		}
	}

	private static boolean writeQuantity() {
		while(true) {
			System.out.println("원하는 수량을 입력하세요: ");
			MyOrder.quantity = scan.nextInt();
			
			
		}
		return false;
	}

	private static void orderEdit() {
		// TODO Auto-generated method stub
		
	}

	private static void orderDelete() {
		// TODO Auto-generated method stub
		
	}

	private static void orderView() {
		// TODO Auto-generated method stub
		
	}
	
	//유효성 검사
	private static boolean checkModelExists() {
		if (MyOrder.id.equals("1") || MyOrder.id.equals("2") || MyOrder.id.equals("3") || MyOrder.id.equals("4")) {
			return true;
		}
		return false;
	}
	
//	private static void createOrderId() {
//
//		Random random = new Random(); // 랜덤 객체 생성
//
//		while (true) {
//			Order.id = 100000 + random.nextInt(900000); // 6자리 랜덤 숫자 (100000~999999)
//
//			boolean isDuplicate = false;
//
//			for (Members member : Data.memberList) {
//				if (member.getLevel().equals("3") && member.getId().equals(AgencyManagement.id)) {
//					isDuplicate = true;
//					break;
//				}
//			}
//
//			if (!isDuplicate) {
//				// 중복이 없으면 반복문 종료
//				break;
//			}
//		}
//	}// createOrderId

}
