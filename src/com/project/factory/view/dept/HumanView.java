package com.project.factory.view.dept;

import java.util.HashMap;
import java.util.Map;

import com.project.factory.Today;
import com.project.factory.resource.CommuteData;
import com.project.factory.resource.user.Commute;
import com.project.factory.view.MainView;

/** 인사부 관리자의 로그인시 보이는 화면을 관리하는 클래스이다.
 *  
 */
public class HumanView {
	
	public static int count;
	
	/** 인사부 관리자의 사원관리 메뉴 뷰를 출력하는 메서드이다.
	 * 
	 */
	public static void hrmTitle() {
		System.out.println();
		MainView.doubleLine();
		System.out.println("\t\t\t\t\t\t\t사원관리(입사,퇴사)");
		MainView.doubleLine();
	}
	
	// 인사부 관리자의 로그인시 보이는 화면을 출력하는 메서드이다.
	public static void HumanAdminView() {
		//2024-02-08
		//현재 생산부 출근인원 : 10명
		//현재 유통부 출근인원 : 15명
		//현재 인사부 출근인원 : 20명
		//현재 경영부 출근인원 : 25명
		
		CommuteData.load();
		
		System.out.println(Today.day());
		System.out.println();
		
		countMembersByDept();
		System.out.println();
		MainView.doubleLine();
		System.out.println();
	}
	
		
	/** 부서별 출근인원을 보여주는 메서드이다.
	 * 
	 */
    public static void countMembersByDept() {
        Map<String, Integer> deptCounts = new HashMap<>();

        for (Commute commuteMember : CommuteData.commuteMemberList) {
            String dept = commuteMember.getDept();

            // 부서별로 카운트 유지
            if(commuteMember.getCal().equals(Today.day()) && commuteMember.getCommute().equals("출근")) {
            deptCounts.put(dept, deptCounts.getOrDefault(dept, 0) + 1);
            }
        }

        // 결과 출력
        for (Map.Entry<String, Integer> entry : deptCounts.entrySet()) {
            System.out.printf("%s부 출근 인원: %d명\n", entry.getKey(), entry.getValue());
        }
    }


    /** 찾고자하는 부서의 출근인원을 보여주는 메서드이다.
     * 
     * @param specificDept 찾고자하는 부서
     */
    public static void countMembersBySpecificDept(String specificDept) {
        int count = 0;

        for (Commute commuteMember : CommuteData.commuteMemberList) {
            String dept = commuteMember.getDept();

            // 특정 부서에 대한 카운트만 증가
            if (specificDept.equals(dept)) {
            	if( commuteMember.getCal().equals(Today.day()) && commuteMember.getCommute().equals("출근")) {
            		count++;
            		
            	}
            }
        }

        // 결과 출력
        System.out.printf("%s부 출근 인원: %d명\n", specificDept, count);
    }

}
