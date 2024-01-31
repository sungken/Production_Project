package com.project.factory.dept;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import com.project.factory.Main;
import com.project.factory.member.Identify;
import com.project.factory.view.dept.commutePushView;

public class CommutePush {
	//근태 등록
	
	boolean goWork;
	
	//출근 리스트에 추가메서드 작성 필요
	
	public static void commutePush() {
		
		Scanner scan = new Scanner(System.in);
		
		commutePushView.commutePushView();

		Main.selectNum = scan.nextLine();
		
        if (Main.selectNum.equals("1")) {
            
            Calendar commuteTime = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            String currentTime = sdf.format(commuteTime.getTime());
            System.out.println();
            System.out.println(currentTime + "출근하셨습니다.");
            
            
            System.out.println(Identify.auth);
        	
        } 
			
		
	}


}
