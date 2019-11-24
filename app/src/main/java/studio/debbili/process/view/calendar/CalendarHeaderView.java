package studio.debbili.process.view.calendar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import studio.debbili.process.R;

/**
 * Created by Debbili on 2019/11/24.
 */
public class CalendarHeaderView extends View {

	private TextView tvMonth;
	private TextView tvDetail;
	private TextView tvToDo;

	public CalendarHeaderView(Context context) {
		super(context);
		inflate(context, R.layout.event_calendar_header, null);
		initView();
	}

	public CalendarHeaderView(Context context, @Nullable AttributeSet attrs) {
		this(context);
	}

	private void initView() {
		tvMonth = findViewById(R.id.calendar_header_month);
		tvDetail = findViewById(R.id.calendar_header_detail);
		tvToDo = findViewById(R.id.calendar_header_todo);
	}

	public void setData(String month, String detail, String toDo) {
		setMonth(month);
		setDetail(detail);
		setToDo(toDo);
	}

	public void setMonth(String month) {
		if(tvMonth != null) {
			tvMonth.setText(month);
		}
	}

	public void setDetail(String detail) {
		if(tvDetail != null) {
			tvDetail.setText(detail);
		}
	}

	public void setToDo(String toDo) {
		if(tvToDo != null) {
			tvToDo.setText(toDo);
		}
	}
}
