package com.project.factory.view.dept;

import com.project.factory.view.MainView;

/** 사원 출/퇴근 조회 뷰 기능을 하는 클래스이다.
 * 
 */
public class CommuteView {
// 근태 목록

	/** 사원 출/퇴근 조회 기능의 제목을 보여주는 메서드이다.
	 * 
	 */
	public static void commuteTitle() {
		System.out.println();
		MainView.doubleLine();
		System.out.println("\t\t\t\t사원 출/퇴근 조회");
		MainView.doubleLine();
	}

}
