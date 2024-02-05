package com.project.factory;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Today {

	public static String time() {
		Calendar commuteTime = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String currentTime = sdf.format(commuteTime.getTime());
		return currentTime;
	}
	
	
	public static String day() {
		Calendar today = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = dateFormat.format(today.getTime());
		return formattedDate;

	}
	
	// 차량 주문 현재일 부터 5일 후 배송(납기)
	public static String daysLater() {
		Calendar daysLater = Calendar.getInstance();
		daysLater.add(Calendar.DATE, 5);
		SimpleDateFormat daysLaterFormat = new SimpleDateFormat("yyyy-MM-dd");
		String fiveDaysLater = daysLaterFormat.format(daysLater.getTime());
		return fiveDaysLater;

	}
}
