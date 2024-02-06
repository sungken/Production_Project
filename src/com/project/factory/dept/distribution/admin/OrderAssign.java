package com.project.factory.dept.distribution.admin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

import com.project.factory.Today;
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
				System.out.println();

				checkContinue();
		
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
		//주문 리스트 확인
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
							+ Today.day() + "\t" 
							+ temp[2] + "\t\t" 
							+ temp[4] + "\t" 
							+ temp[5] + "\t\t" 
							+ Today.daysLater() + "\t"
							+ temp[3]);
				}
			}
			System.out.println();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// orderList()
	
	
	public static void assignOrder() {
		// 배송자 배정
		try {
			//출근한 인원 리스트 받아서 랜덤으로 자동 배치 시키기
			
			//1. 출근자 목록중 유통직원 확인
			BufferedReader reader = new BufferedReader(new FileReader("data\\출근자 목록 test.txt"));
			String delivery = null;
			
			String deliveryMember = "";
			while ((delivery = reader.readLine()) != null) {
				String[] temp = delivery.split("■");
				if(temp[5].equals("2") && temp[6].equals("유통")) {
					deliveryMember += Arrays.toString(temp) + "\r\n";
				}
			}
			
			//출근한 유통 가능직원 추출 후 목록(파일) 생성
			BufferedWriter writer = new BufferedWriter(new FileWriter(Path.DELIVERYMEMBER));
			writer.write(deliveryMember.replace(", ", "■").replace("[", "").replace("]", ""));
			writer.close();
			
			// 유통(출근한)직원 과 주문 리스트(order) 합치기
			BufferedReader readerMember = new BufferedReader(new FileReader(Path.DELIVERYMEMBER));
			BufferedReader readerOrder = new BufferedReader(new FileReader(Path.ORDER));
			BufferedWriter orderFinish = new BufferedWriter(new FileWriter("data\\최종 유통.txt"));
			
//			String lineMember = readerMember.readLine();
//            String lineOrder = readerOrder.readLine();
            
            String line1;
            String line2;
            String orderFinishMember = "";
            
            while ((line1 = readerMember.readLine()) != null && (line2 = readerOrder.readLine()) != null) {
                String mergedLine = line1 + "■" + line2 + "\r\n";
                orderFinishMember += mergedLine;
            }
            
//            System.out.println(orderFinishMember);
            orderFinish.write(orderFinishMember);
            orderFinish.close();
            
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}// assignOrder()
	
	private static void orderFinishList(String model)  {
		//주문서와 유통자 리스트 출력
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("data\\최종 유통.txt"));
			System.out.printf("%s 주문서\n", model);
			System.out.println("[주문서 번호]\t[날짜]\t\t[대리점 명칭]\t[대리점 번호]\t[주문 댓수]\t[납기일]\t\t[담당자 이름]\t[사원번호]");
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("■");
				
				if(temp[14].equals(model)) {
					System.out.println(temp[7] + "\t\t" 
							+ temp[8] + "\t" 
							+ temp[9] + "\t\t" 
							+ temp[11] + "\t" 
							+ temp[12] + "\t\t" 
							+ temp[13] + "\t"
							+ temp[1] + "\t\t"
							+ temp[0]);
				}
			}
			System.out.println();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// orderList()
	
	
	public static void modifyAssign() {
		//수정할 주문서 번호 받기
		try {
			BufferedReader reader = new BufferedReader(new FileReader("data\\최종 유통.txt"));
			BufferedReader reader2 = new BufferedReader(new FileReader("data\\deliveryMember.txt"));
			Scanner scan = new Scanner(System.in);
			Scanner scan2 = new Scanner(System.in);
			
			String EmployeeNum = "";
			String name = "";
			String humanNum = "";
			String phonNum = "";
			String address = "";
			
			System.out.println();
			System.out.println("배정된 주문서");
			orderFinishList("k3");
			orderFinishList("k5");
			orderFinishList("k7");
			orderFinishList("k9");
			System.out.println();
			MainView.doubleLine();
			System.out.println();
			System.out.print("수정 할 주문서 번호를 입력하세요: ");
			String orderNum = scan.nextLine();
			
			String line = null;
			boolean loop = true;
			while(loop) {
				while ((line = reader.readLine()) != null) {
					String[] temp = line.split("■");
					if (orderNum.equals(temp[7])) {
						System.out.println("[주문서 번호]\t[날짜]\t\t[대리점 명칭]\t[대리점 번호]\t[주문 댓수]\t[납기일]\t\t[담당자 이름]\t[사원번호]");
						System.out.println(temp[7] + "\t\t" 
								+ temp[8] + "\t" 
								+ temp[9] + "\t\t" 
								+ temp[11] + "\t" 
								+ temp[12] + "\t\t" 
								+ temp[13] + "\t"
								+ temp[1] + "\t\t"
								+ temp[0]);
						System.out.println();
						System.out.print("해당 주문을 담당할 사원번호를 입력하세요: ");
						String memberNum = scan2.nextLine();
						
						while ((line = reader2.readLine()) != null) {
							String[] temp2 = line.split("■");
							if (memberNum.equals(temp2[0])) {
							System.out.println("[사원번호]\t\t[이름]\t\t[생년월일]\t\t[전화번호]");
							System.out.println(temp2[0] + "\t\t" + temp2[1] + "\t\t" + temp2[2] + "\t\t" + temp2[3]);
							System.out.println();
							EmployeeNum = temp2[0];
							name = temp2[1];
							humanNum = temp2[2];
							phonNum = temp2[3];
							address = temp2[4];
							}
						}
						System.out.print("해당 직원으로 진행하시겠습니까? (Y/N) ");
						String check = scan.nextLine();
						System.out.println();
						if (check.equals("Y") || check.equals("y")) {
							MainView.singnleLine();
							System.out.println();
							System.out.println("해당 주문서의 담당자가 수정되었습니다.");
							
							BufferedReader reader3 = new BufferedReader(new FileReader("data\\최종 유통.txt"));
							String txt = "";
							while ((line = reader3.readLine()) != null) {
								txt += line.replace(temp[0], EmployeeNum)
										   .replace(temp[1], name)
										   .replace(temp[2], humanNum)
										   .replace(temp[3], phonNum)
										   .replace(temp[4], address) + "\r\n";
							}
							BufferedWriter modifyDelivery = new BufferedWriter(new FileWriter("data\\최종 유통.txt"));
							modifyDelivery.write(txt);
							modifyDelivery.close();
							
							
						} else if (check.equals("N") || check.equals("n")) {
							
						} else {
							System.out.println();
							MainView.singnleLine();
							System.out.println();
							System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
							checkContinue();
						}
						
					}
//			System.out.println("주문서 번호를 정확히 입력해 주세요.");
//			modifyAssign();
				}
				
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		//수정
		
		
		
		
	}// modifyAssign()

	private static void checkContinue() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println();
		System.out.print("유통사원을 배정하시겠습니까?(Y/N) ");
		String check = scan.nextLine();
		System.out.println();
		
		if (check.equals("Y") || check.equals("y")) {
			assignOrder();
			orderFinishList("k3");
			orderFinishList("k5");
			orderFinishList("k7");
			orderFinishList("k9");
			System.out.println();
			System.out.println("선택화면으로 돌아갑니다.");
			
		} else if (check.equals("N") || check.equals("n")) {
			
		} else {
			System.out.println();
			MainView.singnleLine();
			System.out.println();
			System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			checkContinue();
		}
	}
	
	
	
}
