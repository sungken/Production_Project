package com.project.factory.member.admin;

import java.util.Scanner;
import java.util.regex.Pattern;

import com.project.factory.Main;
import com.project.factory.Today;
import com.project.factory.member.Identify;
import com.project.factory.resource.CommuteData;
import com.project.factory.resource.user.Commute;
import com.project.factory.view.CommuteView;
import com.project.factory.view.MainView;
import com.project.factory.view.dept.commutePushView;

public class CommuteSearch {
	// 직원 근태 확인

	public static String date;

	
	
	// 출/퇴근 기록을 확인하는 메서드
	public static void commuteSearch() {
		
		CommuteData.load();

		CommuteView.commuteTitle();
		
		if (Identify.dept.equals("인사")) {
			CommuteListHuman();
		} else 
			askDate();
			printCommuteMember(Identify.dept, date);
			
		}
		


	//날짜 유효성 검사 및 존재하는 날짜인지 확인 하는 메서드
    public static void checkDate() {
   

        if (Today.checkDate(date)) {
            if (isMemberCommuteExists(date)) {
                // 이미 클래스 변수로 저장되어 있으므로 반환할 필요 없음
            } else {
                System.out.println();
                System.out.println("존재하지 않는 날짜입니다.");
                System.out.println();
                // 여기서 필요하다면 다른 처리를 수행할 수 있습니다.
            }
        } else {
            System.out.println();
            System.out.println("잘못된 형식의 날짜입니다.");
            System.out.println();
           
            // 여기서 필요하다면 다른 처리를 수행할 수 있습니다.
        }
       
    }



	private static void askDate() {
		Scanner scan = new Scanner(System.in);

        System.out.print("날짜 입력(YYYY-MM-DD): ");
        
        date = scan.nextLine();
	}

	//출퇴근 리스트에 멤버가 존재하는지 확인하는 메서드
	public static boolean isMemberCommuteExists(String date) {
		for (Commute commuteMember : CommuteData.commuteMemberList) {
			if (commuteMember.getCal().equals(date)) {
				return true;
			}
		}
		return false;
	}
	
	
	public static void CommuteListHuman() {
			
			System.out.println();
			System.out.println("1. 생산부");
			System.out.println("2. 유통부");
			System.out.println("3. 인사부");
			System.out.println("4. 경영부");
			System.out.println();
			MainView.singnleLine();
			System.out.print("번호 입력: ");

			Scanner scan = new Scanner(System.in);

			Main.selectNum = scan.nextLine();
			
			int num = Integer.parseInt(Main.selectNum);
			
			if (num >=1 && num <= 4) {
				if(num ==1) {
					String dept = "생산";	
					checkDate();
					askDate();
					printCommuteMember(dept, date) ;
				}else if(num ==2) {
					String dept = "유통";
					checkDate();
					askDate();
					printCommuteMember(dept, date);
				}else if(num ==3) {
					checkDate();
					askDate();
					String dept = "인사";
					printCommuteMember(dept, date);
				}else if(num ==4) {
					checkDate();
					askDate();
					String dept = "경영";
					printCommuteMember(dept, date);
				}
				
			}else {
				System.out.println("잘못된 번호입니다.");
				MainView.checkContinue();
				if (Main.answer.equals("Y") || Main.answer.equals("y")) {
					CommuteListHuman();
				} else if (Main.answer.equals("N") || Main.answer.equals("n")) {

					MainView.pause();

				} else {
					System.out.println();
					MainView.singnleLine();
					System.out.println();
					System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
					MainView.checkContinue();
				}
			}
			
			
	
	}
	
	
	// 실질적으로 리스트 출력하는 메서드
	private static void printCommuteMember(String dept, String date) {
		
		System.out.println();

		System.out.println("[날짜]\t\t[사원번호]\t[이름]\t[부서]\t[직급]\t[시간]\t[출/퇴근]");
		
		for (Commute commuteMember : CommuteData.commuteMemberList) {
			if (commuteMember.getDept().equals(dept) && commuteMember.getCal().equals(date)) {
				System.out.printf("%s\t%s\t\t%s\t%s\t%s\t%s\t%s%n", commuteMember.getCal(), commuteMember.getId(),
						commuteMember.getName(), commuteMember.getDept(), commuteMember.getLevel(),
						commuteMember.getCurrentTime(), commuteMember.getCommute());
			}
		}
		MainView.pause();
	}
	
}
