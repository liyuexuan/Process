package studio.debbili.process.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import studio.debbili.process.data.calendar.DayData;
import studio.debbili.process.data.calendar.MonthData;

/**
 * Created by Debbili on 2019/11/21.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
	private static final String DB_NAME = "DB_PROCESS";
	private static final int VERSION = 1;

	private static final String MONTH_TABLE_NAME = "MONTH_TABLE";
	private static final String DAY_TABLE_NAME = "DAY_TABLE";

	public DatabaseHelper(Context context) {
		this(context, DB_NAME, null, VERSION);
	}
	public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase sqLiteDatabase) {
		createMonthTable(sqLiteDatabase);
		createDayTable(sqLiteDatabase);
	}

	@Override
	public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

	}

	private void createMonthTable(SQLiteDatabase sqLiteDatabase) {
		String createMonthStr = "CREATE TABLE " + MONTH_TABLE_NAME + " ( "
				+ MonthData.MONTH_KEY + " INTEGER PRIMARY KEY, "
				+ MonthData.MONTH + " INTEGER, "
				+ MonthData.DAYS + " INTEGER, "
				+ MonthData.PRE_DAYS + " INTEGER, "
				+ MonthData.BEHIND_DAYS + " INTEGER "
				+ ")";
		sqLiteDatabase.execSQL(createMonthStr);
	}

	private void createDayTable(SQLiteDatabase sqLiteDatabase) {
		String createDayStr = "CREATE TABLE " + DAY_TABLE_NAME + " ( "
				+ DayData.DAY_KEY + " INTEGER PRIMARY KEY, "
				+ DayData.DAY + " INTEGER, "
				+ DayData.MONTH + " INTEGER, "
				+ DayData.IS_CURRENT_MONTH + " BOOLEAN, "
				+ DayData.EVENT_STATUS + " INTEGER "
				+ ")";
		sqLiteDatabase.execSQL(createDayStr);
	}
}
