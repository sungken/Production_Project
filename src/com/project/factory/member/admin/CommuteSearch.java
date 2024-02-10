package com.project.factory.member.admin;

import java.util.Scanner;

import com.project.factory.Main;
import com.project.factory.Today;
import com.project.factory.member.Identify;
import com.project.factory.resource.CommuteData;
import com.project.factory.resource.user.Commute;
import com.project.factory.view.MainView;
import com.project.factory.view.dept.CommuteView;

/** 관리자의 공통기능으로 사원 출/퇴근 조회 기능을 하는 클래스이다.
 * 
 */
public class CommuteSearch {
    public static String date;

    public static void commuteSearch() {
        CommuteData.load();

        if (Identify.dept.equals("인사")) {
            CommuteView.commuteTitle();
            CommuteListHuman();
        } else {
            CommuteView.commuteTitle();
            if (Date() == 1) {
                printCommuteMember(Identify.dept, date);
            } else {
                MainView.pause();
            }
        }
    }

    /** 해당 멤버가 해당 날짜에 출/퇴근을 등록했는지 확인하는 메서드이다.
     * 
     * @param date 찾을 날짜
     * @return 존재하는 날짜면 true, 아니면 false
     */
    public static boolean isMemberCommuteExists(String date) {
        for (Commute commuteMember : CommuteData.commuteMemberList) {
            if (commuteMember.getCal().equals(date)) {
                return true;
            }
        }
        return false;
    }
    
    
    /** 인사관리자일 경우 부서별로 출/퇴근 멤버를 보여주는 메서드이다.
     * 
     */
    public static void CommuteListHuman() {
        System.out.println();
        System.out.println("1. 생산부");
        System.out.println("2. 유통부");
        System.out.println("3. 인사부");
        System.out.println("4. 경영부");
        System.out.println();
        MainView.singleLine();
        System.out.print("번호 입력: ");

        Scanner scan = new Scanner(System.in);
        Main.selectNum = scan.nextLine();

        int num = Integer.parseInt(Main.selectNum);

        if (num >= 1 && num <= 4) {
            String dept = "";
            if (num == 1) {
                dept = "생산";
            } else if (num == 2) {
                dept = "유통";
            } else if (num == 3) {
                dept = "인사";
            } else if (num == 4) {
                dept = "경영";
            }

            if (Date() == 1) {
                printCommuteMember(dept, date);
            } else {
                MainView.pause();
            }
        } else {
        	System.out.println();
            System.out.println("잘못된 번호입니다.");
            MainView.checkContinue();
            if (Main.answer.equalsIgnoreCase("Y")) {
                commuteSearch();
            } else if (Main.answer.equalsIgnoreCase("N")) {
                // Do nothing or handle accordingly
            } else {
                System.out.println();
                MainView.singleLine();
                System.out.println();
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                MainView.checkContinue();
            }
        }
    }

    /** 찾고자 하는 날짜를 입력받는 메서드이다.
     * 
     * @return 존재하는 날짜이면 1, 존재하지 않는 날짜거나 형식에 맞지 않으면 0
     */
    public static int Date() {
        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.print("날짜 입력(YYYY-MM-DD): ");
        date = scan.nextLine();

        if (Today.checkDate(date)) {
            if (isMemberCommuteExists(date)) {
                return 1;
            } else {
            	System.out.println();
                System.out.println("존재하지 않는 날짜입니다.");
                if(MainView.checkContinueBoolean()) {
                	commuteSearch();
                	
                }
                return 0;
            }
        } else {
        	System.out.println();
            System.out.println("잘못된 형식의 날짜입니다.");
            if(MainView.checkContinueBoolean()) {
            	commuteSearch();
            }
        }

       
        return 0;
    }

    /** 찾고자하는 날짜와 부서의 출/퇴근 리스트를 출력하는 메서드이다.
     * 
     * @param dept 찾고자 하는 부서
     * @param date 찾고자 하는 날짜
     */
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

        System.out.println();
        MainView.pauseToSel();
        CommuteSearch.commuteSearch();
        return;
    }
}
