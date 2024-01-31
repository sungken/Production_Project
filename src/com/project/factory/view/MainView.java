package com.project.factory.view;

import java.util.Scanner;

import com.project.factory.member.Identify;

public class MainView {

	// TODO mainMenu 메서드 추가
	public static void mainMenu() {
		System.out.println("==============================");
		System.out.println("           쌍용 테크");
		System.out.println("==============================");
		System.out.println();

		// TODO Member 클래스 생성 필요
		if (Identify.auth == null) {
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("4. 아이디(사원번호) / 비밀번호 찾기");
		} else {
			System.out.println("3. 로그아웃");
		}

		// Identify.level.equals("3")
		// 사원, 관리자 공통
		if (Identify.auth != null && (Identify.level.equals("1") || Identify.level.equals("2"))) {
			System.out.println("5. 개인정보 조회 및 수정");
			System.out.println("6. 근태 등록");
			System.out.println("7. 공지 사항");
		}

		// 관리자 공통
		if (Identify.auth != null && Identify.level.equals("2")) {
			System.out.println("10. 사원 출근 조회");
			System.out.println("11. 재고 확인");
			System.out.println("12. 공지사항 관리");
		}
		
		//생산부 직원
		if (Identify.auth != null && Identify.level.equals("1") && Identify.dept.equals("생산")) {
			System.out.println("8. 부품 재고 파악 및 발주");			
		}
		
		//유통부 직원
		if (Identify.auth != null && Identify.level.equals("1") && Identify.dept.equals("유통")) {
			System.out.println("9. 배송지 조회 및 유통");
		}
		
		//생산부 관리자
		if (Identify.auth != null && Identify.level.equals("2") && Identify.dept.equals("생산")) {
			System.out.println("14. 생산 목표량 입력 및 수정");
			System.out.println("15. 생산 관리");
		}
		
		//유통부 관리자
		if (Identify.auth != null && Identify.level.equals("2") && Identify.dept.equals("유통")) {
			System.out.println("16. 주문서 확인 및 배정 수정");
			System.out.println("17. 사원 배송 구역 관리");
		}
		
		//인사부 관리자
		if (Identify.auth != null && Identify.level.equals("2") && Identify.dept.equals("인사")) {
			System.out.println("13. 사원 관리");
		}
		
		//경영부 관리자
		if (Identify.auth != null && Identify.level.equals("2") && Identify.dept.equals("경영")) {
			System.out.println("18. 대리점 관리");
			System.out.println("19. 대리점 주문 관리");
			System.out.println("20. 모델 관리");
			System.out.println("21. 하청 업체 관리");
		}
		
		//이메일(경영부 관리자, 대리점)
		if (Identify.auth != null && ((Identify.level.equals("2") && Identify.dept.equals("경영")) || Identify.level.equals("3")))
		System.out.println("22. 이메일");
		
		//대리점
		if (Identify.auth != null && Identify.level.equals("3")) {
			System.out.println("23. 주문서 관리");
		}

		System.out.println("0. 종료");
		System.out.println("-------------------------------");
		System.out.print("번호 입력 : ");
		System.out.println();
	}

	//TODO title 메서드 추가 
	public static void title(String title) {
		System.out.println("-------------------------------");
		System.out.println("             " + title);
		System.out.println("-------------------------------");
	}

	//TODO pause 메서드 추가
	public static void pause() {
		Scanner scan = new Scanner(System.in);

		System.out.println();
		System.out.print("엔터를 치면 초기화면으로 돌아갑니다.");
		scan.nextLine();
		System.out.println();
	}

}
