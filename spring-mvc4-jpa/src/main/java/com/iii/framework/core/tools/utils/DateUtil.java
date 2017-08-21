package com.iii.framework.core.tools.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	/**
	 * 有滿這個歲數了嗎？滿足: true
	 * 
	 * @param birthday
	 * @param year
	 * @return boolean
	 */
	public static boolean isMeetTheAge(Date birthday, int age) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(birthday);
		cal.add(Calendar.YEAR, +age);
		return cal.getTime().equals(new Date()) || cal.getTime().before(new Date());
	}

}
