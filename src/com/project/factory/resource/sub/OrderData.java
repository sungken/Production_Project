//package com.project.factory.resource.sub;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.util.ArrayList;
//
//import com.project.factory.board.admin.BoardManagement;
//import com.project.factory.resource.Path;
//import com.project.factory.resource.dept.Board;
//
//public class OrderData {
//	public static ArrayList<Order> orderList = new ArrayList<Order>();
//	//public static int noticeNumber; // 공지사항 번호
//
//	public static void load() {
//		try {
//
//			boardList.clear(); // 기존 데이터 초기화
//
//			BufferedReader reader = new BufferedReader(new FileReader(Path.BOARD));
//
//			String line = null;
//			while ((line = reader.readLine()) != null) {
//				// 공지사항번호■작성자ID(사원번호)■부서■제목■내용■작성일■삭제할날짜
//				String[] temp = line.split("■");
//
//				Board boardItem = new Board(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4], temp[5],
//						temp[6]);
//
//				// boardList.add(boardItem);
//
//				// 삭제일 지났으면 삭제하기
//				if (BoardManagement.checkDeleteDate(temp[6])) {
//					continue;
//				} else {
//					boardList.add(boardItem);
//				}
//
//			}
//
//			reader.close();
//
//		} catch (Exception e) {
//			System.out.println("OrderData.load");
//			e.printStackTrace();
//		}
//
//	}
//}
