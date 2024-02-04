package com.project.factory.view.sub;

import java.util.Collections;
import java.util.Comparator;

import com.project.factory.resource.Data;
import com.project.factory.resource.Members;
import com.project.factory.view.MainView;

public class AgencyManagementView {

	public static void agencyManagementMenu() {
		System.out.println();
		MainView.doubleLine();
		System.out.println("\t\t\t\t대리점 관리");
		MainView.doubleLine();

		AgencyManagementView.agencyManagementListView();

		System.out.println();
		MainView.singnleLine();
		System.out.println();
		System.out.println("1. 대리점 등록");
		System.out.println("2. 대리점 삭제");
		System.out.println();
		MainView.singnleLine();
		System.out.print("번호 입력: ");
	}

	public static void deleteAgencyMenu() {
		System.out.println();
		MainView.singnleLine();
		System.out.println("\t\t\t\t대리점 삭제");
		MainView.singnleLine();
		System.out.println();
		System.out.println("삭제하실 대리점 ID를 입력해주세요.");
		MainView.singnleLine();
		System.out.print("대리점 ID: ");
	}

	private static void agencyManagementListView() {
	    System.out.printf("%-10s\t%-12S\t%-10S\t%-40S\r\n", "[대리점 명]", "[전화번호]", "[구역]", "[주소]");
	    
	    // Comparator를 사용하여 getDept()를 기준으로 오름차순으로 정렬
	    Comparator<Members> deptComparator = new Comparator<Members>() {
	        @Override
	        public int compare(Members m1, Members m2) {
	            return m1.getDept().compareTo(m2.getDept());
	        }
	    };
	    
	    // 멤버 목록을 getDept()를 기준으로 오름차순으로 정렬
	    Collections.sort(Data.memberList, deptComparator);

	    for (Members member : Data.memberList) {
	        if (member.getLevel().equals("3")) {
	            System.out.printf("%-10s\t%-12S\t%-10S\t%-40S\n", member.getName(), member.getPhoneNum(),
	                    member.getArea(member.getDept()), member.getAddress());
	        }
	    }
	}//agencyManagementListView

}
