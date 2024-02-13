package com.project.factory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Pattern;

//TODO Today 메서드 추가 생성
/**
 * 당일시간, 당일날짜, 납기일, 날짜 유효성 확인을 담당하는 클래스이다.
 * 
 */

public class Today {

	// 당일 시간
	/**
	 * 오늘 시간을 hh:mm 형식으로 반환하는 메서드이다.
	 * 
	 * @return 오늘 시간
	 */
	public static String time() {

		Calendar Today = Calendar.getInstance();

		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String currentTime = sdf.format(Today.getTime());
		return currentTime;
	}

	// 당일 날짜
	/**
	 * 오늘 날짜를 yyyy-mm-dd 형식으로 반환하는 메서드이다.
	 * 
	 * @return 오늘 날짜
	 */
	public static String day() {
		Calendar Today = Calendar.getInstance();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = dateFormat.format(Today.getTime());
		return formattedDate;

	}

	// 날짜 형식 유효성 검사
	/**
	 * 주어진 날짜가 형식에 맞는지 확인하는 메서드이다.
	 * 
	 * @param date
	 * @return 형식에 맞으면 true, 아니면 false
	 */
	public static boolean checkDate(String date) {
		String regex = "\\d{4}-\\d{2}-\\d{2}";
		return Pattern.matches(regex, date);
	}

}
