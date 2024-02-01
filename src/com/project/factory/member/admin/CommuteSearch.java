package com.project.factory.member.admin;

import java.util.Scanner;
import java.util.regex.Pattern;

import com.project.factory.member.Identify;
import com.project.factory.resource.CommuteData;
import com.project.factory.resource.user.Commute;
import com.project.factory.view.CommuteView;
import com.project.factory.view.MainView;

public class CommuteSearch {
	// 직원 근태 확인
	
	private static String date;



	public static void commuteSearch() {

			CommuteData.load();
			Scanner scan = new Scanner(System.in);
			
			System.out.println();
			MainView.doubleLine();
			System.out.println("     사원 출/퇴근 조회");
			MainView.doubleLine();
			
			
			System.out.println();
			System.out.print("날짜 입력(YYYY-MM-DD): ");

			
			date = scan.nextLine();

			
			boolean isdate = memberCommute(date);
	
			
			if(checkDate(date)) {
				
				if(isdate) {
					memberCommute(date);
					CommuteView.CommuteViewMain();
					
				} else {
					System.out.println();
					System.out.println("존재하지 않는 날짜입니다.");
					MainView.pause();
				}
			} else {
				System.out.println();
				System.out.println("잘못된 형식의 날짜입니다.");
				MainView.pause();
			}
			
			


	}



	private static boolean checkDate(String date) {
		
        String regex = "\\d{4}-\\d{2}-\\d{2}";
        return Pattern.matches(regex, date);
	}



	public static boolean memberCommute(String date) {
		
		for(Commute commuteMember : CommuteData.commuteMemberList) {
			if(commuteMember.getCal().equals(date)) {
				return true;
			}
	
		}
		return false;

	}
//	public static void productionCommute() {
//		
//	}
//	public static void humanCommute() {
//		
//	}
//	public static void distributionCommute() {
//		
//	}

}