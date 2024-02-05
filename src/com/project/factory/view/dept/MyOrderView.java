package com.project.factory.view.dept;

import com.project.factory.view.MainView;

public class MyOrderView {

	public static void myOrderMenu() {
		System.out.println();
		MainView.doubleLine();
		System.out.println("\t\t\t\t주문서 관리");
		MainView.doubleLine();
		
		System.out.println();
		System.out.println("1. 주문서 작성");
		System.out.println("2. 주문서 수정");
		System.out.println("3. 주문서 취소");
		System.out.println("4. 주문서 조회");
		System.out.println();
		MainView.singnleLine();
		System.out.print("번호 입력: ");
	}

		
	
	/*
	public void orderListView() {
		
		System.out.println("____________________________________________________________________________________________________________________");
		System.out.println("|                                                                                                                   |");
		System.out.println("|                                                                                                                   |");
		System.out.println("|                                                    주 문 서                                                         |");
		System.out.println("|                                             _____________________                                                 |");
		System.out.println("|                                                                                                                   |");
		System.out.println("| K3 주문서                                                                                                           |");
		System.out.println("| [주문서 번호]\t[날짜]\t     [대리점 명칭]\t\t    [주소]\t\t[대리점 번호]\t[모델별 수량]\t[납기일]      |");
		for(int i=0; i<list.length; i++) {
			System.out.printf("|    %d     %s       %s\t   %s\t       %s        %d\t       %s   |\n", order, date, agency, address, agencyNum, modelnum, dueDate);
			
		}
		System.out.println("|                                                                                                                   |");
		System.out.println("|                                                                                                                   |");
		System.out.println("|                                                                                                                   |");
		System.out.println("|                                                                                                                   |");
		System.out.println("|___________________________________________________________________________________________________________________|");
		
	}
	*/
}
