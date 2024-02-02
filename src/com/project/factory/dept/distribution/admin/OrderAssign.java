package com.project.factory.dept.distribution.admin;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import com.project.factory.resource.Path;
import com.project.factory.view.MainView;

public class OrderAssign {
	// OrderAssign.orderView();
	public static void orderView() {
		
		boolean loop = true;
		
		while(loop) {
			Scanner scan = new Scanner(System.in);
			
			MainView.doubleLine();
			System.out.println();
			System.out.println("1. 주문서 확인");
			System.out.println();
			System.out.println("2. 배정 수정");
			System.out.println();
			MainView.doubleLine();
			System.out.println();
			
			System.out.println("엔터를 누르면 초기 화면으로 돌아갑니다.");
			System.out.println();
			System.out.print("번호 입력: ");
			String num = scan.nextLine();
			if(num.equals("1")) {
				//주문서 확인 화면 넘어가기
				checkOrder();
			} else if (num.equals("2")) {
				//배정 수정 화면 넘어가기
				
			} else if (num.equals("\n")) {
				//엔터 누르면 초기 화면 넘어가기
				loop = false;
			} else {
				System.out.println("다시 입력하세요.");
			}
			
		}
	}// orderView()
	
	public static void checkOrder() {
		
			//주문서 리스트 불러오기
			
			System.out.println();
			System.out.println("________________________________________________________________________________________________________________________________________________________");
			System.out.println("|                                                                                                                					|");
			System.out.println("|                                                                                                                					|");
			System.out.println("|                                                   			 주 문 서                  	                                    	|");
			System.out.println("|                                            			 _____________________														|");
			System.out.println("|                                                                                                                					|");
			orderList("k3");
			orderList("k5");
			orderList("k7");
			orderList("k9");
			
		}// checkOrder()

	private static void orderList(String model)  {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(Path.ORDER));
			System.out.printf("%s 주문서\n", model);
			System.out.println("[주문서 번호]\t[날짜]\t\t[대리점 명칭]\t[대리점 번호]\t[주문 댓수]\t[납기일]\t\t[주소]");
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("■");
				if(temp[7].equals(model)) {
					System.out.println(temp[0] + "\t\t" 
							+ temp[1] + "\t" 
							+ temp[2] + "\t" 
							+ temp[4] + "\t" 
							+ temp[5] + "\t\t" 
							+ temp[6] + "\t"
							+ temp[3]);
				}
			}
			System.out.println();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// orderList()
	
	
	public static void assignOrder(String model) {
		//자동 배정
		try {
			//출근한 인원 리스트 받아서 랜덤으로 자동 배치 시키기
			BufferedReader reader = new BufferedReader(new FileReader("C:\\class\\code\\java\\project\\Production_Project\\data\\test.txt"));
			String delivery = null;
			
			String deliveryMember = "";
			while ((delivery = reader.readLine()) != null) {
				String[] temp = delivery.split("■");
				if(temp[5].equals("2") && temp[6].equals("유통")) {
					deliveryMember += Arrays.toString(temp) + "\r\n";
				}
			}
			String[] lines = deliveryMember.split("\n");
//			for (int i = 0; i < lines.length; i++) {
//				System.out.print(lines[i]);
//			}
			System.out.println(lines[0]);
//			String[] a = new String[7];
//			String a = {"745944B", "정희현", "880522", "010-5135-3548", "서울특별시 관악구 신림로78길", "2", "유통"};
			String a = lines[0];
			System.out.println(a);
			String[] deliveryName = a.split(",");
//			cccc[0].replace("[", "");
//			System.out.println(deliveryName[0].replace("[", ""));
//			System.out.println(deliveryName[1]);
			
			
			reader = new BufferedReader(new FileReader(Path.ORDER));
			System.out.printf("%s 주문서\n", model);
			System.out.println("[주문서 번호]\t[날짜]\t\t[대리점 명칭]\t[대리점 번호]\t[주문 댓수]\t[납기일]\t\t[담당사원 이름]\t\t[사원번호]");
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("■");
				if(temp[7].equals(model)) {
					System.out.println(temp[0] + "\t\t" 
							+ temp[1] + "\t" 
							+ temp[2] + "\t" 
							+ temp[4] + "\t" 
							+ temp[5] + "\t\t" 
							+ temp[6] + "\t"
							+ cccc[1] + "\t\t\t"
							+ cccc[0].replace("[", ""));
				}
			}
			System.out.println();
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}// assignOrder()
	
	private void modifyAssign(int orderId, String id) {
		//수정할 주문서 번호 받기
		//수정
	}// modifyAssign()
	
	
	
}
