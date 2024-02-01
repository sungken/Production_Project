package com.project.factory.view;

import com.project.factory.resource.CommuteData;
import com.project.factory.resource.user.Commute;

public class CommuteView {
	//근태 목록
	
	public static void CommuteViewMain(){
		System.out.println();
		MainView.singnleLine();
		System.out.println("            출근자 목록");
		System.out.println();
		System.out.println("[날짜]\t\t[사원번호]\t[이름]\t[부서]\t[직급]\t[시간]\t[출/퇴근]");
		for (Commute commuteMember : CommuteData.commuteMemberList) {
		    System.out.printf("%s\t%s\t\t%s\t%s\t%s\t%s\t%s%n",
		            commuteMember.getCal(),
		            commuteMember.getId(),
		            commuteMember.getName(),
		            commuteMember.getDept(),
		            commuteMember.getLevel(),
		            commuteMember.getCurrentTime(),
		            commuteMember.getCommute()); 
		}
		MainView.singnleLine();
		MainView.pause();
	}
	
}
