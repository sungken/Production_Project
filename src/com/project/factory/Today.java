package com.project.factory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Pattern;

//TODO Today 메서드 추가 생성
public class Today {
	
	public static Calendar today = Calendar.getInstance();

	//당일 시간
	public static String time() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String currentTime = sdf.format(Today.today.getTime());
		return currentTime;
	}

	//당일 날짜
	public static String day() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = dateFormat.format(Today.today.getTime());
		return formattedDate;

	}
	
	//날짜 형식 유효성 검사
	public static boolean checkDate(String date) {
        String regex = "\\d{4}-\\d{2}-\\d{2}";
        return Pattern.matches(regex, date);
    }
}
