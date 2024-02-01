package com.project.factory;

import java.text.SimpleDateFormat;
import java.util.Calendar;

//TODO Today 메서드 추가 생성
public class Today {
	
	public static Calendar today = Calendar.getInstance();

	public static String time() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String currentTime = sdf.format(Today.today.getTime());
		return currentTime;
	}
	
	
	public static String day() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = dateFormat.format(Today.today.getTime());
		return formattedDate;

	}
}
