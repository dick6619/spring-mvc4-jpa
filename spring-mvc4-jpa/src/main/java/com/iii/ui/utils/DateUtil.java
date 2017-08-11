package com.iii.ui.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	/**
	 * 是否滿18歲，滿足為true
	 * 
	 * @param birthday
	 * @return boolean
	 */
	public static boolean isAdult(Date birthday) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(birthday);
		calendar.add(Calendar.YEAR, +18);
		return calendar.getTime().before(new Date());
	}

}
