package com.project.factory.resource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import com.project.factory.resource.user.Board;

//TODO Board 클래스 추가
public class BoardData {
	
	public static ArrayList<Board> boardList = new ArrayList<Board>();
	public static int noticeNumber; //공지사항 번호

	public static void load() {
		try {

			BufferedReader reader = new BufferedReader(new FileReader(Path.BOARD));

			String line = null;
			while ((line = reader.readLine()) != null) {
				//공지사항번호■작성자ID(사원번호)■제목■내용■작성일■삭제할날짜
				String[] temp = line.split("■");

				Board boardItem = new Board(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4], temp[5]);

				boardList.add(boardItem);

			}
			
			reader.close();

		} catch (Exception e) {
			System.out.println("BoardData.load");
			e.printStackTrace();
		}

	}
	
	// 마지막 공지사항의 번호를 가져오는 메서드
    public static int getLastNoticeNumber() {
        if (boardList.isEmpty()) {
            return 0; // 공지사항이 없는 경우 0 반환
        } else {
            Board lastBoard = boardList.get(boardList.size() - 1); // 마지막 공지사항 가져오기
            return lastBoard.getNoticeNumber(); //Board의 getNoticeNumber() 메서드
        }
    }

    // 새로운 공지사항의 번호를 설정하는 메서드
    public static void setNewNoticeNumber() {
        noticeNumber = BoardData.getLastNoticeNumber() + 1; // 마지막 공지사항 번호에 1을 더한 값을 설정
    }

    // 현재 누적된 공지사항 번호를 가져오는 메서드
    public static int getNoticeNumber() {
        return noticeNumber;
    }
    

//	public static void save() {
//
//		try {
//			BufferedWriter writer = new BufferedWriter(new FileWriter(Path.BOARD));
//
//			for (Board boardItem : BoardData.boardList) {
//
//				//공지사항번호■작성자ID(사원번호)■제목■내용■작성일■삭제할날짜
//				String line = String.format("\r\n%d■%s■%s■%s■%s■%s", 
//						boardItem.getNoticeNumber(), 
//						boardItem.getId(),
//						boardItem.getTitle(), 
//						boardItem.getContents(), 
//						boardItem.getToday(),
//						boardItem.getDeleteDate());
//
//				writer.write(line);
//
//			}
//
//			writer.close();
//
//		} catch (Exception e) {
//			System.out.println("BoardData.save");
//			e.printStackTrace();
//		}
//
//	}
}
