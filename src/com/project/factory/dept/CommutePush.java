package com.project.factory.dept;

import java.io.FileWriter;
import java.util.Scanner;

import com.project.factory.Main;
import com.project.factory.Today;
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
	        	
	            String currentTime = Today.time();
	            System.out.println();
	            System.out.println(currentTime + " 출근하셨습니다.");
	            gowork(Identify.auth);
	        	
	        }
	        
	    } else  {
	        commutePushView.commutePushViewEnd();
	        Main.selectNum = scan.nextLine();

	        if (Main.selectNum.equals("2")) {
	        	

	            String currentTime = Today.time();
	            System.out.println();
	            System.out.println(currentTime + " 퇴근하셨습니다.");
	            
	            // 퇴근 처리를 위한 메서드 호출 등 추가
	            

	        }
	    }

	}
	
	
	
	private static boolean checkGoWork(String auth) {
		
		System.out.println("CommuteData.commuteMemberList " + CommuteData.commuteMemberList);
		
		for (Commute commuteMember : CommuteData.commuteMemberList) {
			if (commuteMember.getId().equals(auth) ) {

				return true;
			}
		}

		return false;
	}
	
	//commute.txt에 퇴근 등록
	private static void leaveOut(String auth) {
		
		try {
			
			FileWriter writer = new FileWriter(Path.COMMUTE,true);
			
			//날짜■사원번호■이름■부서■직급■출근시간
			for (Members member : Data.memberList) {
				if(member.getId().equals(auth)) {
					   String commuteRecord = Today.day() + "■" + member.getId() + "■" + member.getName() + "■" 
							   				+ member.getDept() + "■" + member.getLevel() + "■" + Today.time() +"■" + "퇴근"; 
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
		
	//commute.txt에 출근 등록
	private static void gowork(String auth) {
		
		try {
			
			FileWriter writer = new FileWriter(Path.COMMUTE,true);
			
			//날짜■사원번호■이름■부서■직급■출근시간
			for (Members member : Data.memberList) {
				if(member.getId().equals(auth)) {
					   String commuteRecord = Today.day() + "■" + member.getId() + "■" + member.getName() + "■" 
							   				+ member.getDept() + "■" + member.getLevel() + "■" + Today.time() +"■" + "출근";

		               writer.write(commuteRecord);
		               writer.write("\r\n");

				
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
