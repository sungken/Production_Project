package com.project.factory.member;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class SignUp {

	// 사원번호
	String id;
	// 이름
	String name;
	// 생년월일
	String humanNum;
	// 핸드폰 번호
	String phoneNum;
	// 주소
	String address;
	// 부서
	String depart;


	public static void cheackid() {

		System.out.print("사원번호: ");
		Scanner scan = new Scanner(System.in);
		String loadId = scan.nextLine();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:\\class\\code\\java\\project\\Production_Project\\data\\member.txt"));

			String line = null;
			
			
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("■");
				if (temp[0].equals(loadId)) {
					String id = temp[0];
					String name = temp[2];
					String humanNum = temp[3];
					String phoneNum = temp[4];
					String address = temp[5];
					String depart = temp[7];
//				System.out.printf("%s\n%s\n%s\n%s\n%s\n%s ", id, name, humanNum, phoneNum , address, depart);
					System.out.println("이름: " + name);
					System.out.println("생년월일: " + humanNum);
					System.out.println("전화번호: " + phoneNum);
					System.out.println("주소: " + address);
					System.out.println("부서: " + depart);
					
					System.out.println("비밀번호를 설정해주세요");
					System.out.println("비밀번호: ");
					
					
//				} else {
//					System.out.println("사원번호를 잘못 입력하셨습니다.");
//					System.out.println();
//					System.out.println("계속 진행하시겠습니까?(Y/N)");
//					System.out.print("입력: ");
					
				}
			}

			reader.close();

		} catch (Exception e) {
			System.out.println("몰라");
			e.printStackTrace();
		}

	}
//	public void setPw(String pw) {
//		this.pw = pw;
//	}

//	if(pw != null) {
//		안됨
//	}

}
