package com.iii.framework.core.tools.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

/**
 * M3 DateUtil
 */
public class M3DateUtil {

	private static final SimpleDateFormat TO_DATE_FORMATTER = new SimpleDateFormat("yyyyMMdd");

	public static Date toDate(String rocDate) {
		if ((rocDate == null) || (rocDate.length() != 7)) {
			throw new IllegalArgumentException("RocDate[" + rocDate + "] is not valid");
		}

		if ((!(rocDate.substring(3, 5).matches("[01][\\d]")))
				|| (!(rocDate.substring(5, 7).matches("([012][\\d])|[3][01]")))) {
			throw new IllegalArgumentException("RocDate month or day [" + rocDate + "] is not valid");
		}

		int year = Integer.parseInt(rocDate.substring(0, 3));
		String date = Integer.toString(year + 1911) + rocDate.substring(3);
		try {
			synchronized (TO_DATE_FORMATTER) {
				DateTime rocFirstDayOfMonth = new DateTime(TO_DATE_FORMATTER.parse(date.substring(0, 6).concat("01")));

				if (Integer.valueOf(rocDate.substring(5, 7)).intValue() > rocFirstDayOfMonth.dayOfMonth()
						.withMaximumValue().getDayOfMonth()) {
					throw new IllegalArgumentException("RocDate[" + rocDate + "] parsing error , 該月份天數不合法");
				}
				return TO_DATE_FORMATTER.parse(date);
			}
		} catch (Exception ex) {
			throw new IllegalArgumentException("RocDate[" + rocDate + "] parsing error", ex);
		}
	}

	public static String toRocDateString(Date date) {
		return toRocDateString(date, "eeeMMdd");
	}

	public static String toRocDateString(Date date, String format) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat();

		int yearCnt = 0;

		boolean useROCYear = false;

		cal.setTime(date);
		int year = cal.get(1);

		int index = 0;
		int yearPos = -1;
		while (index < format.length()) {
			char token = format.charAt(index);
			if ((token == 'e') || (token == 'y')) {
				if (token == 'e') {
					useROCYear = true;
				}
				yearPos = index;
				do
					++index;
				while ((index < format.length()) && (token == format.charAt(index)));
				yearCnt = index - yearPos;
				break;
			}
			++index;
		}

		if (yearCnt == 0) {
			dateFormat.applyPattern(format);
			return dateFormat.format(date);
		}

		String beforeYear = format.substring(0, yearPos);
		String afterYear = format.substring(index, format.length());
		dateFormat.applyPattern(beforeYear);
		String tmpDate = dateFormat.format(date);
		dateFormat.applyPattern(afterYear);
		String dateString = dateFormat.format(date);

		String yearStr = "";
		String signNegative = "-";
		if (useROCYear) {
			if (yearCnt < 2) {
				yearCnt = 2;
			}
			year -= 1911;

			if (year <= 0) {
				year = Math.abs(year) + 1;

				yearStr = StringUtils.leftPad(Integer.toString(year), yearCnt, '0');

				yearStr = signNegative.concat(yearStr.substring(yearStr.length() - yearCnt + 1, yearStr.length()));
			} else {
				yearStr = StringUtils.leftPad(Integer.toString(year), yearCnt, '0');
			}
		} else {
			if (yearCnt == 3) {
				yearCnt = 4;
			}
			yearStr = StringUtils.leftPad(Integer.toString(year), yearCnt, '0');
		}

		return tmpDate + yearStr + dateString;
	}

}
