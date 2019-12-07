package studio.debbili.process.view.calendar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import studio.debbili.process.R;
import studio.debbili.process.data.calendar.DayData;
import studio.debbili.process.utils.CalendarUtil;

/**
 * Created by Debbili on 2019/11/24.
 */
public class EventCalenadarView extends LinearLayout {
	private CalendarHeaderView headerView;
	private CalendarGridView gridView;
	public EventCalenadarView(Context context) {
		super(context);
		inflate(context, R.layout.event_calendar_main, this);
		initView(context);
	}

	public EventCalenadarView(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		inflate(context, R.layout.event_calendar_main, this);
		initView(context);
	}

	private void initView(Context context) {
		headerView = findViewById(R.id.calendar_header);
		gridView = findViewById(R.id.calendar_grid);
	}

	public void setData(Calendar calendar) {
		List<DayData> dataList = CalendarUtil.getInstance().getCurrentDataList(calendar);
		setData(dataList);

		setHeaderView(calendar);
	}

	public void setData(List<DayData> dayList) {
		gridView.setData(dayList);
	}

	public void setHeaderView(Calendar calendar) {
		if(calendar == null) {
			calendar = Calendar.getInstance();
		}

		int currentYear = calendar.get(Calendar.YEAR);
		int currentMonth = calendar.get(Calendar.MONTH);
		int currentDay = calendar.get(Calendar.DATE);
		int curDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String month = CalendarUtil.formatUpMonth(currentMonth);
		String detail = sdf.format(calendar.getTime())+" "+CalendarUtil.formatUpDayOfWeek(curDayOfWeek);
		headerView.setData(month, detail, "0 todo");
	}
}
