//package com.project.factory.resource;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.util.ArrayList;
//
//import com.project.factory.resource.user.Board;
//
////TODO Board 클래스 추가
//public class BoardData {
//	public static ArrayList<Board> boardList = new ArrayList<Board>();
//
//	public static void load() {
//		try {
//
//			BufferedReader reader = new BufferedReader(new FileReader(Path.BOARD));
//
//			String line = null;// reader.readLine();
//			while ((line = reader.readLine()) != null) {
//				// 홍길동,100,90,80
//				String[] temp = line.split("■");
//
//				Commute commuteMember = new Commute(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6]);
//
//				commuteMemberList.add(commuteMember);
//
//			}
//
//			reader.close();
//
//		} catch (Exception e) {
//			System.out.println("Data.load");
//			e.printStackTrace();
//		}
//
//	}
//
//	public static void save() {
//
//		try {
//			BufferedWriter writer = new BufferedWriter(new FileWriter(Path.MEMBER));
//
//			for (Commute commuteMember : CommuteData.commuteMemberList) {
//
//				// Score 객체 1개 > 홍길동, 100, 90, 80
//				String line = String.format("\r\n%s■%s■%s■%s■%d■%s", commuteMember.getCal(), commuteMember.getId(),
//						commuteMember.getName(), commuteMember.getDept(), commuteMember.getLevel(),
//						commuteMember.getCurrentTime());
//
//				writer.write(line);
//
//			}
//
//			writer.close();
//
//		} catch (Exception e) {
//			System.out.println("Data.save");
//			e.printStackTrace();
//		}
//
//	}
//}
