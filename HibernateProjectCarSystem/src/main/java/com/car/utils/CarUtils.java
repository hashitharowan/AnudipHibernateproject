package com.car.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class CarUtils {
	
	private static String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	private static String DATE_FORMAT ="yyyy-MM-dd";
	
	private static String EMPTY_SPACE = " ";
	
	public static LocalDateTime convertStringToDate(String date,String time) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
		LocalDateTime formattedDate = LocalDateTime.parse(date+ EMPTY_SPACE  + time, formatter);
		return formattedDate;
	}

	public static int getRentedHours(LocalDateTime rentalDateTime, LocalDateTime returnDateTime) {
	//Period duration = Period.(rentalDateTime, returnDateTime);
		long chUnit = ChronoUnit.HOURS.between(rentalDateTime, returnDateTime);
		return (int) chUnit;
	}
	
	public static String getCurrentDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
		String currentDate = formatter.format(LocalDate.now());
		return currentDate;
	}

}
