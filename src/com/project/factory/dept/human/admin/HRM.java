package com.project.factory.dept.human.admin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.project.factory.Main;
import com.project.factory.resource.Data;
import com.project.factory.resource.Members;
import com.project.factory.resource.NewMemberData;
import com.project.factory.view.MainView;
import com.project.factory.view.dept.HumanView;

public class HRM {

	private static String employeeId;

	public static void hrd() {
		NewMemberData.load();
		HumanView.hrmTitle();
		hrmSelect();
	}

	public static void hrmSelect() {
		Scanner scan = new Scanner(System.in);

		System.out.println();
		System.out.println("1. 입사 관리");
		System.out.println("2. 퇴사 관리");
		System.out.println("3. 사원 조회");
		System.out.println();
		MainView.singnleLine();
		System.out.println();

		System.out.print("번호 입력: ");

		Main.selectNum = scan.nextLine();

		if (Main.selectNum.equals("1")) {
			addUser();
		} else if (Main.selectNum.equals("2")) {
			deleteUser();
		} else if (Main.selectNum.equals("3")) {
			 searchUser();
		}

	}

	private static void addUser() {
		newMemberList();

		System.out.println();
		System.out.println("1. 사원번호 생성하기");
		MainView.singnleLine();
		System.out.print("번호 입력: ");

		Scanner scan = new Scanner(System.in);

		Main.selectNum = scan.nextLine();

		if (Main.selectNum.equals("1")) {
			createUserId();
		} else {
			System.out.println("잘못된 번호입니다.");
			MainView.pause();
		}
	}

	private static void deleteUser() {
	    System.out.println();
	    System.out.print("사원 번호 입력: ");

	    Scanner scan = new Scanner(System.in);

	    String id = scan.nextLine();

	    Iterator<Members> iterator = Data.memberList.iterator();
	    while (iterator.hasNext()) {
	        Members member = iterator.next();

	        if (member.getId().equals(id)) {
	            MainView.doubleLine();
	            System.out.println();
	            System.out.println("[사원번호]\t[이름]\t[생년월일]\t\t[전화번호]\t\t[주소]\t[부서]");
	            System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\n", member.getId(), member.getName(), member.getBirth(),
	                    member.getPhoneNum(), member.getAddress(), member.getDept());

	            System.out.println();
	            MainView.doubleLine();
	            
	            System.out.println();
	            System.out.print("퇴사 처리하시겠습니까? (Y/N): ");
	            String answer = scan.nextLine().toUpperCase();

	            if (answer.equals("Y")) {
	                iterator.remove(); // Remove the member from the list
	                System.out.println("퇴사 처리가 완료되었습니다.");
	            } else  {
	                System.out.println("퇴사 처리가 취소되었습니다.");
	                
	            }

	            break; // Exit the loop once the member is found and processed
	        }
	    }
	}


	private static void searchUser() {
		
	    System.out.println();
	    System.out.print("사원 이름 입력: ");

	    Scanner scan = new Scanner(System.in);

	    String name = scan.nextLine();

	    Iterator<Members> iterator = Data.memberList.iterator();
	    boolean found = false; // 일치하는 회원이 있는지 여부를 나타내는 변수

	    while (iterator.hasNext()) {
	        Members member = iterator.next();

	        if (member.getName().contains(name)) { // 수정: getId()에서 getName()으로 변경, contains 메서드 사용
	            if (!found) {
	                MainView.doubleLine();
	                System.out.println();
	                System.out.println("[사원번호]\t[이름]\t[생년월일]\t\t[전화번호]\t\t[주소]\t[부서]");
	            }

	            System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\n", member.getId(), member.getName(), member.getBirth(),
	                    member.getPhoneNum(), member.getAddress(), member.getDept());
	            System.out.println();

	            found = true; // 일치하는 회원이 있음을 표시

	        }
	    }

	    if (!found) {
	        System.out.println("일치하는 회원이 없습니다.");
	    } else {
	        MainView.doubleLine();
	        System.out.println();
	        MainView.pause();
	    }
	}


	private static void createUserId() {
	    Iterator<NewMembers> iterator = NewMemberData.NewMemberList.iterator();
	    List<NewMembers> tempList = new ArrayList<>();

	    while (iterator.hasNext()) {
	        NewMembers newMember = iterator.next();
	        String department = newMember.getDept();
	        String employeeIdDept = "";
	        
	        // ID가 이미 설정되어 있지 않은 경우에만 새로운 ID 생성
	        if(newMember.getId().equals("0")) {
	            switch (department) {
	                case "생산":
	                    employeeIdDept = "A";
	                    break;
	                case "유통":
	                    employeeIdDept = "B";
	                    break;
	                case "인사":
	                    employeeIdDept = "C";
	                    break;
	                case "경영":
	                    employeeIdDept = "D";
	                    break;
	                // 다른 부서에 대한 처리 추가
	            }

	            Random random = new Random();
	            int randomNumber = 100000 + random.nextInt(900000); // 6자리 랜덤 숫자 (100000~999999)
	            newMember.setId(String.valueOf(randomNumber) + employeeIdDept);

	            // 생성된 사원번호 출력
	            System.out.println("생성된 사원번호: " + newMember.getId());
	        }

	        tempList.add(newMember);
	    }

	    NewMemberData.NewMemberList.clear();

	    for (NewMembers tempMember : tempList) {
	        NewMemberData.NewMemberList.add(tempMember);
	    }

	    NewMemberData.save();

	    System.out.println("사원 번호가 생성되었습니다.");
	    MainView.pause();
	}


	private static void newMemberList() {
		MainView.doubleLine();
		System.out.println();
		System.out.println("[신입사원 리스트]");
		System.out.println("[사원번호]\t[이름]\t[전화번호]\t\t[생년월일]\t\t[주소]\t\t[부서]\t[직급]");
		for (NewMembers newMember : NewMemberData.NewMemberList) {
			System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\n",newMember.getId(), newMember.getName(), newMember.getPhoneNum(),
					newMember.getBirth(), newMember.getAddress(), newMember.getDept(), newMember.getLevel());
		}
	}

}
