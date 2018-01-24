package com.stone.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Explain:Date Tools Purpose:Date Format
 * 
 * @author evan.yao
 * @date 2015年9月29日
 */
public class DateTool {

	public static void main(String[] args) {

		// System.out.println(parseAccDate("090111", "111111"));
		// Long s = getMinuteBetween("2010-11-07 18:55:41",
		// "2010-11-06 18:56:41");
		//
		// System.out.println(s < 24 * 60);
		// System.out.println(getWeekOfToday(new Date()));
		// getCurrentDay("201509271800");
		// System.out.println(getCurrentDate(null));
		System.out.println(stringToTimestamp("2015-09-27 18:00:00",
				"yyyy-MM-dd hh:mm:ss"));
		// System.out.println(strToDate(toStringDate("201509271800")));
		// System.out.println(addDays(2,
		// strToDate(toStringDate("201509271800"))));
	}

	/**
	 * Get current day
	 * 
	 * @param sdate
	 *            yyyymmddhhmm[ss]
	 * @return int
	 */
	public static int getCurrentDay(String sdate) {
		sdate = toStringDate(sdate);
		if ("".equals(sdate) || null == sdate) {
			return 0;
		}
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		try {
			date = dateFormat.parse(sdate);
			System.out.println(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date.getDate();
	}

	public static int getWeekOfToday(Date sdate) {
		Calendar c = Calendar.getInstance();
		c.setTime(sdate);
		return c.get(Calendar.DAY_OF_WEEK);
	}

	public static String dateToStr(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(date);
	}

	public static String getCurrentDate() {
		Date now = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(now);
	}

	public static String getNowMonthDay() {
		Date now = new Date();
		DateFormat dateFormat = new SimpleDateFormat("MM-dd");
		return dateFormat.format(now);
	}

	public static String getCurrenHour() {
		Date now = new Date();
		DateFormat dateFormat = new SimpleDateFormat("HH");
		return dateFormat.format(now);
	}

	public static String getCurrentHHMM() {
		Date now = new Date();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		return dateFormat.format(now);
	}

	public static String getCurrentTime() {
		Date now = new Date();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		return dateFormat.format(now);
	}

	public static String getCurrentFullTime() {
		Date now = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH");
		return dateFormat.format(now);
	}

	public static String getNowDate() {
		Date now = new Date();
		DateFormat dateFormat = new SimpleDateFormat("MM-dd");
		return dateFormat.format(now);
	}

	public static String getCurrentAccurateTime() {
		Date now = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(now);
	}

	public static String getCurrentAccurateMinute() {
		Date now = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return dateFormat.format(now);
	}

	// public static String getDate(String strDate) {
	// Date date = strToDate(strDate);
	// DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	// return dateFormat.format(date);
	// }

	public static long getPeriod(String date1, String date2) {
		if (date1 == null || date1.equals(""))
			return 0;
		if (date2 == null || date2.equals(""))
			return 0;

		SimpleDateFormat myFormatter = new SimpleDateFormat("MM-dd");
		Date date = null;
		Date mydate = null;
		try {
			date = myFormatter.parse(date1);
			mydate = myFormatter.parse(date2);
		} catch (Exception e) {
		}
		long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
		return day;
	}

	public static long getLengthOfPeriod(String date1, String date2) {
		if (date1 == null || date1.equals(""))
			return 0;
		if (date2 == null || date2.equals(""))
			return 0;

		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		Date mydate = null;
		try {
			date = myFormatter.parse(date1);
			mydate = myFormatter.parse(date2);
		} catch (Exception e) {
		}
		long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
		return day;
	}

	public static long getHourBetween(String date1, String date2) {
		if (date1 == null || date1.equals(""))
			return 0;
		if (date2 == null || date2.equals(""))
			return 0;
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = null;
		Date mydate = null;
		try {
			date = myFormatter.parse(date1);
			mydate = myFormatter.parse(date2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		long day = (date.getTime() - mydate.getTime()) / (1000 * 60 * 60);
		return day;
	}

	public static long getMinuteBetween(String date1, String date2) {
		if (date1 == null || date1.equals(""))
			return 0;
		if (date2 == null || date2.equals(""))
			return 0;
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = null;
		Date mydate = null;
		try {
			date = myFormatter.parse(date1);
			mydate = myFormatter.parse(date2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		long day = (date.getTime() - mydate.getTime()) / (1000 * 60);
		return day;

	}

	public static String getWeek() {
		return getWeek(new Date());
	}

	public static String getWeek(String sdate) {

		Date date = DateTool.strToDate(sdate);
		return getWeek(date);
	}

	public static String getWeek(Date sdate) {
		Calendar c = Calendar.getInstance();
		c.setTime(sdate);
		return new SimpleDateFormat("EEEE").format(c.getTime());
	}

	public static Date strToDate(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}

	public static String getLastDayOfWeek() {
		return getLastDayOfWeek(new Date());
	}

	public static String getLastDayOfWeek(String sdate) {
		Date date = DateTool.strToDate(sdate);
		return getLastDayOfWeek(date);
	}

	public static String getLastDayOfWeek(Date date) {
		int mondayPlus = getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus + 6);
		Date monday = currentDate.getTime();
		DateFormat df = DateFormat.getDateInstance();
		String preMonday = df.format(monday);
		return preMonday;
	}

	public static String getFirstDayOfWeek() {
		return getFirstDayOfMonth(new Date());
	}

	public static String getFirstDayOfWeek(String sdate) {
		Date date = DateTool.strToDate(sdate);
		return getFirstDayOfMonth(date);
	}

	public static String getFirstDayOfWeek(Date date) {
		int mondayPlus = getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.setTime(date);
		currentDate.add(GregorianCalendar.DATE, mondayPlus);
		Date monday = currentDate.getTime();
		DateFormat df = DateFormat.getDateInstance();
		String preMonday = df.format(monday);
		return preMonday;
	}

	public static String getLastDayOfMonth() {
		return getLastDayOfMonth(new Date());
	}

	public static String getLastDayOfMonth(String sdate) {
		Date date = DateTool.strToDate(sdate);
		return getLastDayOfMonth(date);
	}

	public static String getLastDayOfMonth(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.setTime(date);
		lastDate.set(Calendar.DATE, 1);
		lastDate.add(Calendar.MONTH, 1);
		lastDate.add(Calendar.DATE, -1);
		return sdf.format(lastDate.getTime());
	}

	public static String getFirstDayOfMonth() {
		return getFirstDayOfMonth(new Date());
	}

	public static String getFirstDayOfMonth(String sdate) {
		Date date = DateTool.strToDate(sdate);
		return getFirstDayOfMonth(date);
	}

	private static String getFirstDayOfMonth(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.setTime(date);
		lastDate.set(Calendar.DATE, 1);
		return sdf.format(lastDate.getTime());
	}

	public static String getLastDayOfYear() {
		return getLastDayOfYear(new Date());
	}

	public static String getLastDayOfYear(String sdate) {
		Date date = DateTool.strToDate(sdate);
		return getLastDayOfYear(date);
	}

	private static String getLastDayOfYear(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.setTime(date);
		lastDate.set(Calendar.DAY_OF_YEAR, 1);
		lastDate.roll(Calendar.DAY_OF_YEAR, -1);
		return sdf.format(lastDate.getTime());
	}

	public static String getFirstDayOfYear() {
		return getFirstDayOfYear(new Date());
	}

	public static String getFirstDayOfYear(String sdate) {
		Date date = DateTool.strToDate(sdate);
		return getFirstDayOfYear(date);
	}

	private static String getFirstDayOfYear(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.setTime(date);
		lastDate.set(Calendar.DAY_OF_YEAR, 1);
		return sdf.format(lastDate.getTime());
	}

	public static boolean isWeekend() {
		return isWeekend(new Date());
	}

	public static boolean isWeekend(String sdate) {
		Date date = DateTool.strToDate(sdate);
		return isWeekend(date);
	}

	public static boolean isWeekend(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int week = c.get(Calendar.DAY_OF_WEEK);
		if (week == 7 || week == 1) {
			return true;
		}
		return false;
	}

	private static int getMondayPlus() {
		Calendar cd = Calendar.getInstance();

		int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 1;
		if (dayOfWeek == 1) {
			return 0;
		} else {
			return 1 - dayOfWeek;
		}
	}

	@SuppressWarnings("unused")
	private static int getYearPlus() {
		Calendar cd = Calendar.getInstance();
		int yearOfNumber = cd.get(Calendar.DAY_OF_YEAR);
		cd.set(Calendar.DAY_OF_YEAR, 1);
		cd.roll(Calendar.DAY_OF_YEAR, -1);
		int MaxYear = cd.get(Calendar.DAY_OF_YEAR);
		if (yearOfNumber == 1) {
			return -MaxYear;
		} else {
			return 1 - yearOfNumber;
		}
	}

	public static String addDays(int day) {
		return addDays(day, new Date());
	}

	@SuppressWarnings("unused")
	public static String addDays(int day, String sdate) {
		Date date = DateTool.strToDate(sdate);
		return addDays(day, sdate);
	}

	public static String addDays(int day, Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, day);
		return sdf.format(calendar.getTime());
	}

	/** date to start time */
	public static String dateToStartTime(String date) {
		return date + " 00:00:00";
	}

	/** date to end time */
	public static String dateToEndTime(String date) {
		return date + " 23:59:59";
	}

	public static boolean isLeapYear(int year) {
		GregorianCalendar gregorianCalendar = (GregorianCalendar) GregorianCalendar
				.getInstance();
		return gregorianCalendar.isLeapYear(year);
	}

	public static boolean isBetween(String date1, String date2) {
		String now = getNowMonthDay();

		long preiod1 = getPeriod(now, date1);
		long preiod2 = getPeriod(date2, now);
		if (now.equals(date1) || now.equals(date2)) {
			return true;
		}

		if (preiod1 > 0 && preiod2 > 0) {
			return true;
		}

		return false;

	}

	public static String formatDate(String date) {

		date.replace("~", " ");
		date.replace("^", " ");

		if (date.indexOf("M") == -1) {
			return date;
		}

		date = date.substring(0, date.indexOf("M") + 1);

		date = date.trim();
		// System.out.println(date);
		int index = date.indexOf(":");
		String formateDate = null;
		if (index != -1) {
			int day = Integer.parseInt(date.substring(0, index));
			if (date.substring(date.indexOf(" ") + 1, date.indexOf(" ") + 3)
					.equals("PM")) {
				day += 12;
			}
			if (day < 10) {
				formateDate = "0" + day
						+ date.substring(date.indexOf(":"), date.indexOf(" "));
			} else {
				formateDate = day
						+ date.substring(date.indexOf(":"), date.indexOf(" "));
			}
		} else {
			return date;
		}

		return formateDate;
	}

	public static String calendarToDate(Calendar c) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(c.getTime());
	}

	public static String parseAccDate(String s, String ss) {
		String s1 = s.substring(0, 2);
		String s2 = s.substring(2, 4);
		String s3 = s.substring(4, 6);

		String ss1 = ss.substring(0, 2);
		String ss2 = ss.substring(2, 4);
		String ss3 = ss.substring(4, 6);

		return "20" + s1 + "-" + s2 + "-" + s3 + " " + ss1 + ":" + ss2 + ":"
				+ ss3;
	}

	/**
	 * String change to sdate(yyyy-MM-dd hh:mm:ss)
	 * 
	 * @param s
	 *            yyyyMMddhhmm[ss]
	 * @return String
	 */
	public static String toStringDate(String s) {
		if ("".equals(s) || null == s) {
			return null;
		}
		int len = s.length();
		if (len == 12) {
			s = s + "00";
		}
		String s1 = s.substring(0, 4);
		String s2 = s.substring(4, 6);
		String s3 = s.substring(6, 8);

		String ss1 = s.substring(8, 10);
		String ss2 = s.substring(10, 12);
		String ss3 = s.substring(12, 14);

		return s1 + "-" + s2 + "-" + s3 + " " + ss1 + ":" + ss2 + ":" + ss3;
	}

	public static String calendarToTime(Calendar c) {
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		return df.format(c.getTime());
	}

	/**
	 * 把string转换成timestamp
	 * 
	 * @param timestampStr
	 *            string类型的日期
	 * @param format
	 *            日期格式
	 * @return Timestamp
	 */
	public static Timestamp stringToTimestamp(String timestampStr, String format) {
		if (format == null || format.equals("")) {
			format = "yyyy-MM-dd HH:mm:ss";
		}
		if (timestampStr == null || timestampStr.trim().equals("")) {
			return null;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		try {
			Date date = dateFormat.parse(timestampStr);
			return new Timestamp(date.getTime());
		} catch (Exception e) {
			return null;
		}
	}

	public static String getCurrentDateTime(String format) {
		if ((format == null) || (format.equals(""))) {
			format = "yyyy-MM-dd HH:mm:ss";
		}
		Date curDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(curDate);
	}

	public static String getAccurateTime(long time) {
		Date now = new Date(time);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(now);
	}

}
