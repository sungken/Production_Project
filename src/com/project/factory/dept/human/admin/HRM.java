package com.project.factory.dept.human.admin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.project.factory.Main;
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
            // deleteUser();
        } else if (Main.selectNum.equals("3")) {
            // searchUser();
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

    private static void deleteUser(String userId) {

    }

    private static void searchUser(String name) {

    }

    private static void createUserId() {
        Iterator<NewMembers> iterator = NewMemberData.NewMemberList.iterator();
        List<NewMembers> tempList = new ArrayList<>(); // 새로운 데이터를 임시로 저장할 리스트

        while (iterator.hasNext()) {
            NewMembers newMember = iterator.next();
            String department = newMember.getDept();

            // 각 부서에 따른 사원번호 생성
            String employeeIdDept = "";
            switch (department) {
                case "생산":
                	employeeIdDept = "A";
                    break;
                case "유통":
                	employeeIdDept = "B";
                    break;
                case "인사":
                	employeeIdDept= "C";
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


            tempList.add(newMember); // 임시 리스트에 추가
        }

        NewMemberData.NewMemberList.clear(); // 기존 리스트 초기화

        // 임시 리스트의 데이터를 다시 복사하여 기존 리스트에 추가
        for (NewMembers tempMember : tempList) {
            NewMemberData.NewMemberList.add(tempMember);
        }

        // 생성된 아이디가 추가된 리스트를 파일에 저장
        NewMemberData.save();
        
        System.out.println("사원 번호가 생성되었습니다.");
        MainView.pause();
    }


    private static void newMemberList() {
        MainView.doubleLine();
        System.out.println();
        System.out.println("[신입사원 리스트]");
        System.out.println("[이름]\t[전화번호]\t\t[생년월일]\t\t[주소]\t\t[부서]\t[직급]");
        for (NewMembers newMember : NewMemberData.NewMemberList) {
            System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\n", newMember.getName(), newMember.getPhoneNum(),
                    newMember.getBirth(), newMember.getAddress(), newMember.getDept(), newMember.getLevel());
        }
    }

}
