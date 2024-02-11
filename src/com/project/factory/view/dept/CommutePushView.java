package com.project.factory.view.dept;


import com.project.factory.view.MainView;

//TODO 근태 등록 뷰 클래스 추가
/** 근태 등록 메뉴 뷰 기능을 하는 클래스이다.
 *  
 */
public class CommutePushView {
	
	//TODO 근태 등록 뷰 메서드
	/** 근태 등록 메뉴를 보여주는 메서드이다.
	 * 
	 */
	public static void commutePushViewMain() {
		System.out.println();
		MainView.doubleLine();
		System.out.println("\t\t\t\t\t\t\t근태 등록");
		MainView.doubleLine();
	}

	//TODO 근태 등록 뷰 메서드 (출근을 하지 않은 경우)
	/** 출근을 하지 않은 경우의 출근하기 메뉴를 보여주는 메서드이다.
	 * 
	 */
	public static void notCommutePushView() {
		

		//로그인이 안 된 상태이면
			System.out.println();
			System.out.println("1. 출근하기");
			System.out.println();
			MainView.singleLine();
			
			
			System.out.print("번호 입력: ");
			
	}
	
	/** 출근을 한 경우 퇴근하기 메뉴를 보여주는 메서드이다.
	 * 
	 */
	
	public static void commutePushViewEnd() {
		

		//로그인이 된 상태이면
			System.out.println();
			System.out.println("2. 퇴근하기");
			System.out.println();
			MainView.singleLine();
			
			
			System.out.print("번호 입력: ");
			
	}
	
	/** 출/퇴근을 등록한 경우, 안내 메세지를 보여주는 메서드이다.
	 * 
	 */
	public static void alreadyCommute() {
			System.out.println();
			System.out.println("이미 출/퇴근을 완료했습니다.");
			System.out.println();
			MainView.pause();
	}
}