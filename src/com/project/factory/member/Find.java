package com.project.factory.member;

import java.util.Scanner;

import com.project.factory.Main;
import com.project.factory.resource.Data;
import com.project.factory.resource.Members;
import com.project.factory.view.MainView;
import com.project.factory.view.member.FindView;

public class Find {
	
	//TODO find 메서드 추가
	//1. 아이디 찾기
	//2. 비밀먼호 찾기
    public static void find() {
        //Data.load();

        Scanner scan = new Scanner(System.in);

        FindView.findMenu();

        String selNum = scan.nextLine();

        if (selNum.equals("1")) {
            findId();
        } else if (selNum.equals("2")) {
            findPw();
        }

        // 다른 코드...
    }

    //TODO findId 메서드 추가
    //입력받은 이름과 전화번호를 memberList에 있는 이름과 전화번호를 비교해서 
    //해당하는 아이디를 반환하는 메서드
    private static void findId() {
        Scanner scan = new Scanner(System.in);

        System.out.print("이름: ");
        String name = scan.nextLine();

        System.out.print("전화번호: ");
        String phoneNum = scan.nextLine();

        String memberId = findMemberId(name, phoneNum);



        if (memberId != null) {
        	System.out.println();
            System.out.println("아이디: " + memberId + " 입니다.");
        } else {
        	System.out.println();
            System.out.println("아이디를 찾을 수 없습니다.");
            MainView.checkContinue();

            if(Main.answer.equals("Y") || Main.answer.equals("y")) {
            	find();
            	
            }
         
        }
    }

    //TODO findMemberId 메서드 추가
    //memberList에 있는 name과 phoneNum을 비교 후 해당하는 아이디 반환
    public static String findMemberId(String name, String phoneNum) {
        for (Members member : Data.memberList) {
            if (member.getName().equals(name) && member.getPhoneNum().equals(phoneNum)) {
                return member.getId();
            }
        }
        return null;
    }

    //TODO findId 메서드 추가
    //입력받은 아이디과 전화번호를 memberList에 있는 아이디과 전화번호를 비교해서 
    //해당하는 비밀번호를 반환하는 메서드
    private static void findPw() {
        Scanner scan = new Scanner(System.in);

        System.out.print("아이디: ");
        String Id = scan.nextLine();

        System.out.print("전화번호: ");
        String phoneNum = scan.nextLine();

        String memberPw = findMemberPw(Id, phoneNum);

        if (memberPw != null) {
        	System.out.println();
            System.out.println("비밀번호: " + memberPw);
        } else {
        	System.out.println();
            System.out.println("비밀번호를 찾을 수 없습니다.");
            MainView.checkContinue();

            if(Main.answer.equals("Y") || Main.answer.equals("y")) {
            	find();
            }
        }
    }

    //TODO findPw 메서드 추가
    //memberList에 있는 아이디와 phoneNum을 비교 후 해당하는 비밀번호 반환
    private static String findMemberPw(String Id, String phoneNum) {
        for (Members member : Data.memberList) {
            if (member.getId().equals(Id) && member.getPhoneNum().equals(phoneNum)) {
                return member.getPw();
            }
        }
        return null;
    }
}
