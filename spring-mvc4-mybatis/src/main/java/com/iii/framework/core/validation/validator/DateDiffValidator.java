package com.iii.framework.core.validation.validator;

import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import com.iii.framework.core.tools.utils.M3DateUtil;
import com.iii.framework.core.validation.DateDiff;

public class DateDiffValidator implements ConstraintValidator<DateDiff, Object> {

	private String start;
	private String end;
	private String diff;

	@Override
	public void initialize(DateDiff dateDiff) {
		this.start = dateDiff.start();
		this.end = dateDiff.end();
		this.diff = dateDiff.diff();
	}

	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		try {
			// valid obj bean's start field and end field
			Object inputStartDate = PropertyUtils.getProperty(obj, this.start);
			Object inputEndDate = PropertyUtils.getProperty(obj, this.end);

			return isDateDiffValid(inputStartDate, inputEndDate, diff);

		} catch (Throwable e) {
			// error
		}
		return false;
	}

	public static boolean isDateDiffValid(Object inputStartDate, Object inputEndDate, String diff) {
		if (inputStartDate == null || inputEndDate == null) {
			return true;
		}
		try {

			DateTime startDate = getDateTime(inputStartDate);
			DateTime endDate = getDateTime(inputEndDate);
			if (startDate == null || endDate == null) {
				return false;
			}
			if (StringUtils.isBlank(diff)) {
				return endDate.isAfter(startDate.plusDays(-1));
			}
			// diff = "<1y", y
			String diffBase = diff.substring(diff.length() - 1);
			// diff = "<1y", <
			String operator = diff.substring(0, 1);
			// diff = "<1y", 1
			Integer diffRange = Integer.valueOf(Integer.parseInt(diff.substring(1, diff.length() - 1)));

			DateTime beSummedDate;
			if (StringUtils.equals(diffBase, "d")) {
				beSummedDate = startDate.plusDays(diffRange.intValue());
			} else {
				if (StringUtils.equals(diffBase, "m")) {
					beSummedDate = startDate.plusMinutes(diffRange.intValue());
				} else {
					if (StringUtils.equals(diffBase, "y")) {
						beSummedDate = startDate.plusYears(diffRange.intValue());
					} else {
						// diffBase is null
						return false;
					}
				}
			}
			// plus 1, -1 let same day can be ok
			if (">".equals(operator)) {
				// start and end range need >= range year，or range month，or range day
				return (endDate.isAfter(beSummedDate.plusDays(-1)) && (endDate.isAfter(startDate.plusDays(-1))));
			}
			if ("<".equals(operator)) {
				// start and end range need <= range year，or range month，or range day
				return (endDate.isBefore(beSummedDate.plusDays(1)) && (endDate.isAfter(startDate.plusDays(-1))));
			}
			if ("=".equals(operator)) {
				// start and end range need == range year，or range month，or range day
				return endDate.isEqual(beSummedDate);
			}
		} catch (Exception e) {
			// throw new ServiceException....
		}

		return false;
	}

	private static DateTime getDateTime(Object date) {
		DateTime dateTime = null;
		try {
			if (date instanceof String) {
				// format... M3DateUtil
				dateTime = new DateTime(M3DateUtil.toDate((String) date));
			} else if (date instanceof Date) {
				dateTime = new DateTime((Date) date);
				dateTime = new DateTime(dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(), 0, 0,
						0);
			} else if (date instanceof DateTime) {
				dateTime = (DateTime) date;
				dateTime = new DateTime(dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth(), 0, 0,
						0);
			} else {
				// unsupported date
			}
		} catch (Exception e) {
			// error
		}
		return dateTime;
	}

}
