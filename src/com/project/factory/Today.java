package com.project.factory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Pattern;

//TODO Today 메서드 추가 생성
public class Today {
	
	//변수명 today에서 calendar로 변경
	public static Calendar calendar = Calendar.getInstance();

	//당일 시간
	public static String time() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String currentTime = sdf.format(Today.calendar.getTime());
		return currentTime;
	}

	//당일 날짜
	public static String day() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = dateFormat.format(Today.calendar.getTime());
		return formattedDate;

	}
	
	//날짜 형식 유효성 검사
	public static boolean checkDate(String date) {
        String regex = "\\d{4}-\\d{2}-\\d{2}";
        return Pattern.matches(regex, date);
    }
	
	//날짜 유효성 검사
	public static boolean inValidDate(String date) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setLenient(false); // 엄격한 모드로 설정

            Today.calendar.setTime(dateFormat.parse(date));

            // ParseException이 발생하지 않으면 유효한 날짜
            return true;
        } catch (ParseException e) {
            // ParseException이 발생하면 유효하지 않은 날짜
            return false;
        }
    }
}
