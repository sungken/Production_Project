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
}
