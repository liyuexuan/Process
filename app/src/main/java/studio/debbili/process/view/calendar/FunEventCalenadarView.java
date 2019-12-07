package studio.debbili.process.view.calendar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import java.util.Calendar;
import java.util.List;

import studio.debbili.process.R;
import studio.debbili.process.data.calendar.DayData;

/**
 * Created by Debbili on 2019/11/24.
 */
public class FunEventCalenadarView extends LinearLayout {
	private FunCalendarHeaderView headerView;
	private CalendarGridView gridView;
	public FunEventCalenadarView(Context context) {
		super(context, null);
	}

	public FunEventCalenadarView(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		inflate(context, R.layout.fun_event_calendar_main, this);
		initView(context);
	}

	private void initView(Context context) {
		headerView = findViewById(R.id.calendar_header);
		gridView = findViewById(R.id.calendar_grid);
	}

	public void setData(List<DayData> dayList) {
		gridView.setData(dayList);
	}

	public void setHeaderView() {
		Calendar calendar = Calendar.getInstance();
		int currentYear = calendar.get(Calendar.YEAR);
		int currentMonth = calendar.get(Calendar.MONTH) + 1;
		int currentDay = calendar.get(Calendar.DATE);
		headerView.setMonth("十二月");
	}
}
