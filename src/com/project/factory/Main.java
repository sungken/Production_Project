package com.project.factory;

import java.util.Scanner;

import com.project.factory.member.Find;
import com.project.factory.member.Identify;
import com.project.factory.member.Login;
import com.project.factory.member.Modify;
import com.project.factory.resource.Data;
import com.project.factory.view.MainView;

public class Main {

	// TODO selectNum String으로 변경
	public static String selectNum;
	public static String answer;

	public static void main(String[] args) {

		// TODO loop 변수 추가 > 초기 화면 메뉴 반복문
		boolean loop = true;
		Scanner scan = new Scanner(System.in);

		Data.load();
		
		while (loop) {

			MainView.mainMenu();


			// TODO sel 변수 추가 > 메뉴 번호 답변 받는 변수
			String sel = scan.nextLine();

			// 로그인하지 않은 경우
			if (Identify.auth == null) {
				if (sel.equals("1")) {
					// 회원가입
					// SignUp.signUp(); > 메서드 생성 필요
				} else if (sel.equals("2")) {
					// 로그인
					Login.login();
				} else if (sel.equals("4")) {
					// 아이디/비번 찾기
					Find.find();
				} else if (sel.equals("0")) {
					// 종료
					loop = false;
					Data.save();
				} else {
					System.out.println("잘못된 번호입니다.");
				}
			} else if (Identify.auth != null) {
				if (sel.equals("3")) {
					// 로그아웃
					// Logout.logout(); > 메서드 생성 필요
				} else if (sel.equals("5")) {
					// 개인정보 조회 및 수정
					Modify.modify(); 
				} else if (sel.equals("6")) {
					// 근태 등록
					// CommutePush.commutePush(); > 메서드 생성 필요
				} else if (sel.equals("7")) {
					// 공지 사항(읽기)
					// ReadBoard board = new ReadBoard();
					// board.list(); > 메서드 생성 필요
				} else if (sel.equals("8")) {
					// 부품 재고 파악 및 발주
					// CheckPiece.checkPiece(); > 메서드 생성 필요
				} else if (sel.equals("9")) {
					// 배송지 조회 및 유통
					// CheckDest.checkDest(); > 메서드 생성 필요
				} else if (sel.equals("10")) {
					// 사원 출/퇴근 조회
					// CommuteSearch.commuteSearch(); > 메서드 생성 필요
				} else if (sel.equals("11")) {
					// 재고 확인
					// InventorySearch.inventorySearch(); > 메서드 생성 필요
				} else if (sel.equals("12")) {
					// 공지사항 관리
					// WriteBoard.writeBoared(); > 메서드 생성 필요
				} else if (sel.equals("13")) {
					// 사원 관리(입사, 퇴사)
					// HRD.hrd(); > 메서드 생성 필요
				} else if (sel.equals("14")) {
					// 생산 목표량 입력 및 수정
					// ProductionTarget.productionTarget(); > 메서드 생성 필요
				} else if (sel.equals("15")) {
					// 생산 관리
					// ProductionManagement.productionManagement(); > 메서드 생성 필요
				} else if (sel.equals("16")) {
					// 주문서 확인 및 배정 수정
					// OrderAssign.orderAssign(); > 메서드 생성 필요
				} else if (sel.equals("17")) {
					// 사원 배송 구역 관리
					// DestManagement.destManagement(); > 메서드 생성 필요
				} else if (sel.equals("18")) {
					// 대리점 관리
					// AgencyManagement.agencyManagement(); > 메서드 생성 필요
				} else if (sel.equals("19")) {
					// 대리점 주문 관리
					// OrderManagement.orderManagement(); > 메서드 생성 필요
				} else if (sel.equals("20")) {
					// 모델 관리
					// ModelManagement.modelManagement(); > 메서드 생성 필요
				} else if (sel.equals("21")) {
					// 하청 업체 관리
					// SubContractorManagement.subContractorManagement(); > 메서드 생성 필요
				} else if (sel.equals("22")) {
					// 이메일
					// Mail.mail(); > 메서드 생성 필요
				} else if (sel.equals("23")) {
					// 주문서 관리
					// MyOrder.MyOrder(); > 메서드 생성 필요
				} else if (sel.equals("0")) {
					// 종료
					loop = false;
					Data.save();
				} else {
					System.out.println("잘못된 번호입니다.");
				}

			}
		} // while

		scan.close();

	}// main

}
