package studio.debbili.process.data.calendar;

/**
 * Created by Debbili on 2019/11/21.
 */
public class DayData {
	public static final String DAY_KEY = "DAY_KEY";
	public static final String DAY = "DAY";
	public static final String MONTH = "MONTH";
	public static final String IS_CURRENT_MONTH = "IS_CURRENT_MONTH";
	public static final String EVENT_STATUS = "EVENT_STATUS";
	private int key;
	private int day;
	private int month;
	private boolean isCurrentMonth;
	private boolean isCurrentDay;
	private int eventStatus;

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public boolean isCurrentMonth() {
		return isCurrentMonth;
	}

	public void setCurrentMonth(boolean currentMonth) {
		isCurrentMonth = currentMonth;
	}

	public boolean isCurrentDay() {
		return isCurrentDay;
	}

	public void setCurrentDay(boolean currentDay) {
		isCurrentDay = currentDay;
	}

	public int getEventStatus() {
		return eventStatus;
	}

	public void setEventStatus(int eventStatus) {
		this.eventStatus = eventStatus;
	}
}
