package studio.debbili.process.utils;

import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import studio.debbili.process.data.calendar.DayData;

/**
 * Created by Debbili on 2019/12/1.
 */
public class CalendarUtil {

	private volatile static CalendarUtil mInstance;

	public static CalendarUtil getInstance() {
		if(mInstance == null) {
			synchronized (CalendarUtil.class) {
				if(mInstance == null) {
					mInstance = new CalendarUtil();
				}
			}
		}
		return mInstance;
	}

	//日历视图显示42天
	private static final int LIST_SIZE = 42;
	private static final Map<Integer, Integer> dayCountMap;
	static {
		dayCountMap = new HashMap<>();
		dayCountMap.put(1, 31);
		dayCountMap.put(2, 28);
		dayCountMap.put(3, 31);
		dayCountMap.put(4, 30);
		dayCountMap.put(5, 31);
		dayCountMap.put(6, 30);
		dayCountMap.put(7, 31);
		dayCountMap.put(8, 31);
		dayCountMap.put(9, 30);
		dayCountMap.put(10, 31);
		dayCountMap.put(11, 30);
		dayCountMap.put(12, 31);
	}
	private static final String[] upMonth = new String[]{
			"一月","二月","三月","四月","五月","六月",
			"七月","八月","九月","十月","十一月","十二月"
	};
	private static final String[] upWeek = new String[]{
			"星期日","星期一","星期二","星期三","星期四","星期五","星期六"
	};
	public static List<DayData> getCurrentDataList() {
		return getCurrentDataList(null);
	}
	public static List<DayData> getCurrentDataList(Calendar calendar) {
		if(calendar == null) {
			calendar = Calendar.getInstance();
		}
		int currentYear = calendar.get(Calendar.YEAR);
		int currentMonth = calendar.get(Calendar.MONTH) + 1;
		int currentDay = calendar.get(Calendar.DATE);

		Calendar calendar1 = Calendar.getInstance();
		calendar1.set(currentYear, currentMonth - 1, 1);
		int firstDayOfWeek = calendar1.get(Calendar.DAY_OF_WEEK);
		Log.i("dayList", "currentYear = "+currentYear);
		Log.i("dayList", "currentMonth = "+currentMonth);
		Log.i("dayList", "currentDay = "+currentDay);
		Log.i("dayList", "currentDayOfWeek = "+firstDayOfWeek);

		int preMonth = currentMonth == 1 ? 12 : currentMonth - 1;
		int preYear = preMonth == 12 ? currentYear - 1 : currentYear;
		int nextMonth = currentMonth == 12 ? 1 : currentMonth + 1;
		int nextYear = nextMonth == 1 ? currentYear + 1 : currentYear;
		Log.i("dayList", "preMonth = "+preMonth);
		Log.i("dayList", "preYear = "+preYear);
		Log.i("dayList", "nextMonth = "+nextMonth);
		Log.i("dayList", "nextYear = "+nextYear);

		int curMonthKey = getMonthKey(currentYear, currentMonth);
		int preMonthKey = getMonthKey(preYear, preMonth);
		int nextMonthKey = getMonthKey(nextYear, nextMonth);
		Log.i("dayList", "curMonthKey = "+curMonthKey);
		Log.i("dayList", "preMonthKey = "+preMonthKey);
		Log.i("dayList", "nextMonthKey = "+nextMonthKey);

		int currentMonthDayCount = getDayCount(currentYear, currentMonth);
		int preMonthDayCount = getDayCount(preYear, preMonth);
		int preDayCount = getPreDayCount(firstDayOfWeek);
		int nextDayCount = LIST_SIZE - currentMonthDayCount - preDayCount;
		Log.i("dayList", "currentMonthDayCount = "+currentMonthDayCount);
		Log.i("dayList", "preMonthDayCount = "+preMonthDayCount);
		Log.i("dayList", "preDayCount = "+preDayCount);
		Log.i("dayList", "nextDayCount = "+nextDayCount);

		List<DayData> dayDataList = new ArrayList<>();
		for(int i = preDayCount - 1; i >= 0; i--) {
			int day = preMonthDayCount - i;
			DayData dayData = new DayData();
			dayData.setCurrentMonth(false);
			dayData.setDay(day);
			dayData.setMonth(preMonth);
			dayData.setKey(getDayKey(preMonthKey, day));
			dayDataList.add(dayData);
			Log.i("dayList", "day = "+dayData.getKey());
		}

		for(int i = 1; i <= currentMonthDayCount; i++) {
			DayData dayData = new DayData();
			dayData.setCurrentMonth(true);
			dayData.setDay(i);
			dayData.setMonth(currentMonth);
			dayData.setKey(getDayKey(curMonthKey, i));
			if(i == currentDay) {
				dayData.setCurrentDay(true);
			}
			dayDataList.add(dayData);
			Log.i("dayList", "day = "+dayData.getKey());
		}

		for(int i = 1; i <= nextDayCount; i++) {
			DayData dayData = new DayData();
			dayData.setCurrentMonth(false);
			dayData.setDay(i);
			dayData.setMonth(nextMonthKey);
			dayData.setKey(getDayKey(nextMonthKey, i));
			dayDataList.add(dayData);
			Log.i("dayList", "day = "+dayData.getKey());
		}

		Log.i("dayList", "dayDataList.size = "+dayDataList.size());
		return dayDataList;
	}

	private static int getDayCount(int curYear, int curMonth) {
		if(curMonth == 0) {
			curYear = curYear - 1;
			curMonth = 12;
		}
		if(curMonth == 2 && isLeapYear(curYear)) {
			return 29;
		}
		return dayCountMap.get(curMonth);
	}

	private static boolean isLeapYear(int curYear) {
		return (curYear % 4 == 0 && curYear % 100 != 0) || curYear % 400 == 0;
	}

	private static int getPreDayCount(int curDayOfWeek) {
		return 7 - curDayOfWeek;
	}

	private static int getMonthKey(int year, int month) {
		return year * 100 + month;
	}

	private static int getDayKey(int monthKey, int day) {
		return monthKey * 100 + day;
	}

	public static String formatUpMonth(int month) {
		return upMonth[month];
	}

	public static String formatUpDayOfWeek(int days) {
		return upWeek[days];
	}
}
