package com.project.factory.member;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

import com.project.factory.resource.Data;
import com.project.factory.resource.Members;
import com.project.factory.resource.Path;

public class SignUp {

	private static final Object[] String = null;
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
	//비밀번호
	String pw;


	public static void cheackid() {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(Path.NEWMEMBER));

			String line = null;
			
			while ((line = reader.readLine()) != null) {
				System.out.println("--------------------------------------------------------------------------------");
				System.out.print("사원번호: ");
				Scanner scan = new Scanner(System.in);
				String loadId = scan.nextLine();
				System.out.println("--------------------------------------------------------------------------------");
				System.out.println();
				
				String[] temp = line.split("■");
				if (temp[0].equals(loadId)) {
					String id = temp[0];
					String phoneNum = temp[2];
					String depart = temp[4];
					String name = temp[5];
					String humanNum = temp[6];
					String address = temp[7];
//				System.out.printf("%s\n%s\n%s\n%s\n%s\n%s ", id, name, humanNum, phoneNum , address, depart);

					System.out.println("[기존 정보]");
					System.out.println();
					System.out.println("이름: " + name);
					System.out.println("생년월일: " + humanNum);
					System.out.println("전화번호: " + phoneNum);
					System.out.println("주소: " + address);
					System.out.println("부서: " + depart);
					System.out.println();
					System.out.println("--------------------------------------------------------------------------------");
					System.out.println();
					
					Boolean loop = true;
					
					while(loop) {
						System.out.println("비밀번호를 설정해주세요");
						System.out.println("(길이: 10 ~ 16자, 영문자, 숫자만 가능)");
						System.out.println();
						System.out.println("--------------------------------------------------------------------------------");
						
						System.out.println();
						System.out.print("비밀번호: ");
						String pw = scan.nextLine();
						System.out.println();
						System.out.println("--------------------------------------------------------------------------------");
		
						if (pw.matches("^[a-zA-Z0-9]{10,16}+$")) {
							System.out.println();
							System.out.println("회원가입이 완료되었습니다.");
							Members member = new Members(id, pw, name, humanNum, phoneNum, address, "2", depart, id + "@auto.com");
							Data.memberList.add(member);
							System.out.println("엔터를 치시면 초기화면으로 돌아갑니다.");
							String a = scan.nextLine();
							loop = false;
						} else {
							System.out.println("비밀번호를 조건에 맞게 다시 입력하세요.");
						}
					}
											//엔터 추가 
					
					
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
