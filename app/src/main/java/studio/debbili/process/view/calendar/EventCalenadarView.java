package studio.debbili.process.view.calendar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import studio.debbili.process.R;

/**
 * Created by Debbili on 2019/11/24.
 */
public class EventCalenadarView extends View {
	public EventCalenadarView(Context context) {
		super(context);
		inflate(context, R.layout.event_calendar_main, null);
	}

	public EventCalenadarView(Context context, @Nullable AttributeSet attrs) {
		this(context);
	}
}
