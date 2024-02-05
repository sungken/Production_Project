package com.project.factory;

//자주하는 메서드 모음
public class Toolkit {

	// 문자열이 정수값인지 확인하는 메서드
	// BoardManagement, ReadBoard, AgencyManagement, MyOrder에서 사용 중
	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
