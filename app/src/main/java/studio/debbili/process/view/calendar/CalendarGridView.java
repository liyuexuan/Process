package studio.debbili.process.view.calendar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import studio.debbili.process.R;

/**
 * Created by Debbili on 2019/11/24.
 */
public class CalendarGridView extends View {
	public CalendarGridView(Context context) {
		super(context);
		inflate(context, R.layout.event_calendar_grid, null);
		initView();
	}

	public CalendarGridView(Context context, AttributeSet attrs) {
		this(context);
	}

	private void initView() {

	}
}
