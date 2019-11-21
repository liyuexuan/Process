package studio.debbili.process.data.calendar;

/**
 * Created by Debbili on 2019/11/21.
 */
public class MonthData {
	public static final String MONTH_KEY = "MONTH_KEY";
	public static final String MONTH = "MONTH";
	public static final String DAYS = "DAYS";
	public static final String PRE_DAYS = "PRE_DAYS";
	public static final String BEHIND_DAYS = "BEHIND_DAYS";

	int key;
	int month;
	int days;
	int preDays;
	int behindDays;

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public int getPreDays() {
		return preDays;
	}

	public void setPreDays(int preDays) {
		this.preDays = preDays;
	}

	public int getBehindDays() {
		return behindDays;
	}

	public void setBehindDays(int behindDays) {
		this.behindDays = behindDays;
	}
}
