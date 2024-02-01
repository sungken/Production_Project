package com.project.factory.dept;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import com.project.factory.Main;
import com.project.factory.member.Identify;
import com.project.factory.resource.CommuteData;
import com.project.factory.resource.Data;
import com.project.factory.resource.Members;
import com.project.factory.resource.Path;
import com.project.factory.resource.user.Commute;
import com.project.factory.view.dept.commutePushView;

public class CommutePush {
	
	//근태 등록
	
	//출근, 퇴근 누적시키기
	
	public static void commutePush() {
		
		CommuteData.load();
	
		boolean isGoWork = checkGoWork(Identify.auth);
		
		System.out.println(isGoWork);
		System.out.println(Identify.auth);
		
		Scanner scan = new Scanner(System.in);
	    commutePushView.commutePushViewMain();

		
		//출근을 안 하면 
	    if (!isGoWork) {
	        commutePushView.notCommutePushView();
	        Main.selectNum = scan.nextLine();

	        if (Main.selectNum.equals("1")) {
	            String currentTime = currentTime();
	            System.out.println();
	            System.out.println(currentTime + " 출근하셨습니다.");
	            gowork(Identify.auth);
	        }
	    } else {
	        commutePushView.CommutePushView();
	        Main.selectNum = scan.nextLine();

	        if (Main.selectNum.equals("2")) {
	            String currentTime = currentTime();
	            System.out.println();
	            System.out.println(currentTime + " 퇴근하셨습니다.");
	            
	            // 퇴근 처리를 위한 메서드 호출 등 추가
	            
	            leaveOut(Identify.auth);
	        }
	    }

	}
	
	
	private static boolean checkGoWork(String auth) {
		
		for (Commute commuteMember : CommuteData.commuteMemberList) {
			if (commuteMember.getId().equals(auth) ) {

				return true;
			}
		}

		return false;
	}

	private static void leaveOut(String auth) {
		
		try {
			
			FileWriter writer = new FileWriter(Path.COMMUTE,true);
			
			//날짜■사원번호■이름■부서■직급■출근시간
			for (Members member : Data.memberList) {
				if(member.getId().equals(auth)) {
					   String commuteRecord = currentDay() + "■" + member.getId() + "■" + member.getName() + "■" 
							   				+ member.getDept() + "■" + member.getLevel() + "■" + currentTime() +"■" + "퇴근"; 
		                writer.write(commuteRecord);
		                writer.write(System.getProperty("line.separator")); // 개행 문자 추가
				
		                break;
				}
			}
			
			System.out.println("완료");
			writer.close();
			
		} catch (Exception e) {
			System.out.println("CommutePush.gowork");
			e.printStackTrace();
		}
		
	

    }
		
		


	private static String currentTime() {
		Calendar commuteTime = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String currentTime = sdf.format(commuteTime.getTime());
		return currentTime;
	}
	
	
	private static String currentDay() {
		Calendar today = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = dateFormat.format(today.getTime());
		return formattedDate;

	}

	private static void gowork(String auth) {
		
		try {
			
			FileWriter writer = new FileWriter(Path.COMMUTE,true);
			
			//날짜■사원번호■이름■부서■직급■출근시간
			for (Members member : Data.memberList) {
				if(member.getId().equals(auth)) {
					   String commuteRecord = currentDay() + "■" + member.getId() + "■" + member.getName() + "■" 
							   				+ member.getDept() + "■" + member.getLevel() + "■" + currentTime() +"■" + "출근"; 
		                writer.write(commuteRecord);
		                writer.write(System.getProperty("line.separator")); // 개행 문자 추가
				
		                break;
				}
			}
			
			System.out.println("완료");
			writer.close();
			
		} catch (Exception e) {
			System.out.println("CommutePush.gowork");
			e.printStackTrace();
		}
		
		
	}


}
