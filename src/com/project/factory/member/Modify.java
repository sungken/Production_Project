package com.project.factory.member;

import java.util.Scanner;

import com.project.factory.view.member.ModifyView;

public class Modify {
//	String name;
//	String pw;
//	String address;
//	String phoneNum;
	
	//TODO modify 메서드 생성
	public static void modify() {
		Scanner scan = new Scanner(System.in);
		
		ModifyView.modifyMenu();
		
		String selNum = scan.nextLine();

        if (selNum.equals("1")) {
        	Modify.modifyName();
        } else if (selNum.equals("2")) {
        	Modify.modifyPw();
        } else if (selNum.equals("3")) {
        	Modify.modifyAddress();
        } else if (selNum.equals("4")) {
        	Modify.modifyName();
        }
		
	}
	
	//TODO modifyName 메서드 생성
	public static void modifyName() {
		
	}
	
	//TODO modifyPw 메서드 생성
	public static void modifyPw() {
		
	}
	
	//TODO modifyAddress 메서드 생성
	public static void modifyAddress() {
		
	}
	
	//TODO modifyPhoneNum 메서드 생성
	public static void modifyPhoneNum() {
		
	}
	
	
//	public void setName(String name) {
//		this.name = name;
//	}
//	public void setPw(String pw) {
//		this.pw = pw;
//	}
//	public void setAddress(String address) {
//		this.address = address;
//	}
//	public void setPhoneNum(String phoneNum) {
//		this.phoneNum = phoneNum;
//	}
	
	
//	public static boolean checkNameExist(String name) {
//		
//	}
//	public static boolean checkPwExist(String pw) {
//		
//	}
//	public static boolean checkAddressExist(String address) {
//		
//	}
//	public static boolean checkPhoneNumExist(String phoneNum) {
//		
//	}
	
}
