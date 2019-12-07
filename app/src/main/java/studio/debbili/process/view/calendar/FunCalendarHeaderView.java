package studio.debbili.process.view.calendar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import studio.debbili.process.R;
import studio.debbili.process.view.FunImageView;

/**
 * Created by Debbili on 2019/11/24.
 */
public class FunCalendarHeaderView extends LinearLayout {

	private FunImageView fvMonth;
	private TextView tvDetail;
	private TextView tvToDo;

	public FunCalendarHeaderView(Context context) {
		super(context, null);
	}

	public FunCalendarHeaderView(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		inflate(context, R.layout.fun_event_calendar_header, this);
		initView(context);
	}

	private void initView(Context context) {
		fvMonth = findViewById(R.id.calendar_header_month);
		tvDetail = findViewById(R.id.calendar_header_detail);
		tvToDo = findViewById(R.id.calendar_header_todo);
	}

	public void setData(String month, String detail, String toDo) {
		setMonth(month);
		setDetail(detail);
		setToDo(toDo);
	}

	public void setMonth(String month) {
		if(fvMonth != null) {
			fvMonth.setShowText(month);
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
