package com.project.factory.member;

import java.util.Scanner;

import com.project.factory.view.member.FindView;


public class Find {

	public static void main(String[] args) {

		Data.load();
		
		Scanner scan = new Scanner(System.in);
		
		FindView.findMenu();
		
		String selNum = scan.nextLine();
		
		if(selNum.equals("1")) {
			findId();
		}else if(selNum.equals("2")) {
			findPw();
		}
		
		
	}//main


private static void findId() {
	Scanner scan = new Scanner(System.in);

	System.out.println("-----------------------------");
	
	System.out.print("이름: ");
	String name = scan.nextLine();

	System.out.print("전화번호: ");
	String phoneNum = scan.nextLine();

	String memberId = findMemberId(name, phoneNum);
	
	System.out.println("-----------------------------");

	if (memberId != null) {
		System.out.println("아이디(사원번호): " + memberId + " 입니다.");
	} else {
		System.out.println("아이디를 찾을 수 없습니다.");
		System.out.println();
		System.out.println("계속 진행하시겠습니까?(Y/N)");
		System.out.print("입력: ");
		
		String answer = scan.nextLine();

		
	}
}//findId
	

public static String findMemberId(String name, String phoneNum) {
	for (TempMember member : Data.list) {
		// 이름과 전화번호가 일치하는 경우 해당 멤버의 아이디를 반환
		if (member.getName().equals(name) && member.getPhoneNum().equals(phoneNum)) {
			return member.getMemberId();
		}
	}
	// 일치하는 멤버가 없는 경우 null 반환
	return null;
}

private static void findPw() {
	Scanner scan = new Scanner(System.in);

	System.out.print("아이디(사원번호): ");
	String Id = scan.nextLine();

	System.out.print("전화번호: ");
	String phoneNum = scan.nextLine();

	String memberPw = findMemberPw(Id, phoneNum);

	if (memberPw != null) {
		System.out.println("비밀번호: " + memberPw);
	} else {
		System.out.println("비밀번호를 찾을 수 없습니다.");
	}
}


private static String findMemberPw(String Id, String phoneNum) {
	for (TempMember member : Data.list) {
		// 이름과 전화번호가 일치하는 경우 해당 멤버의 아이디를 반환
		if (member.getMemberId().equals(Id) && member.getPhoneNum().equals(phoneNum)) {
			return member.getPw();
		}
	}
	return null;
}


}//find

