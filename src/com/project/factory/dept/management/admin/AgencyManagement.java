package com.project.factory.dept.management.admin;

import java.util.Scanner;

import com.project.factory.Main;
import com.project.factory.board.admin.BoardManagement;
import com.project.factory.view.MainView;
import com.project.factory.view.sub.AgencyManagementView;

//대리점 ID■비밀번호■대리점 명■전화번호■이메일■주소■지역 번호
//S8132101■1234■강남1호점■010-1234-4567■gangnam1@auto.com■서울특별시 강남구 테헤란로 132■2
public class AgencyManagement {
	
	public static Scanner scan = new Scanner(System.in);
	
	public static void agencyManagement() {
		
		AgencyManagementView.agencyManagementMenu();
		
		Main.selectNum = scan.nextLine();

		if (Main.selectNum.equals("1")) {
			AgencyManagement.registerAgency();;
		} else if (Main.selectNum.equals("2")) {
			AgencyManagement.deleteAgency();
		} else {
			System.out.println();
			System.out.println("잘못된 번호입니다.");
			if (MainView.checkContinueBoolean()) {
				AgencyManagement.agencyManagement();;
				return;
			} else {
				MainView.pause();
				return;
			}
		}
	}//agencyManagement
	
	private static void registerAgency() {
		
	}
	
	private static void deleteAgency() {
		
	}
	
//	private static void registerAgency(String agencyName, String agencyPhoneNum, String regionNum, String agencyAddress) {
//		String firstPw = "0000";
//	}
	
//	private static void deleteAgency(String agencyId) {
//		
//	}
	
//	private void searchAgency() {
//		
//	}	
	
}
