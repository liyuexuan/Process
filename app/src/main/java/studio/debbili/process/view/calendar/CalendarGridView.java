package studio.debbili.process.view.calendar;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import studio.debbili.process.R;
import studio.debbili.process.data.calendar.DayData;

/**
 * Created by Debbili on 2019/11/24.
 */
public class CalendarGridView extends LinearLayout {
	private Context mContext;
	private GridView mGridView;
	private int mMeasureWidth;
	private List<DayData> mDataList;
	private boolean needSetData = false;
	public CalendarGridView(Context context) {
		this(context, null);
		mContext = context;
	}

	public CalendarGridView(Context context, AttributeSet attrs) {
		super(context, attrs);
		inflate(context, R.layout.event_calendar_grid, this);
		mContext = context;
		initView();
	}

	private void initView() {
		mGridView = findViewById(R.id.gv_calendar_weekday);
		ViewTreeObserver observer = mGridView.getViewTreeObserver();
		observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
			@Override
			public void onGlobalLayout() {
				mMeasureWidth = mGridView.getWidth();
				Log.i("dayView", "grid View width = "+mMeasureWidth);
				if(needSetData) {
					GridAdapter adapter = new GridAdapter(mContext, mDataList, mMeasureWidth);
					mGridView.setAdapter(adapter);
					adapter.notifyDataSetChanged();
					needSetData = false;
				}
			}
		});
	}

	public void setData(List<DayData> dataList) {
		needSetData = true;
		mDataList = dataList;
	}

	private class GridAdapter extends BaseAdapter {

		private Context mContext;
		private List<DayData> dayList = new ArrayList<>();
		private int totalWidth;

		public GridAdapter(Context context, List<DayData> dataList, int width) {
			mContext = context;
			dayList = dataList;
			totalWidth = width;
		}

		@Override
		public int getCount() {
			return dayList.size();
		}

		@Override
		public Object getItem(int i) {
			return dayList.get(i);
		}

		@Override
		public long getItemId(int i) {
			return i;
		}

		@Override
		public View getView(int i, View view, ViewGroup viewGroup) {
			ViewHolder holder;
			if(view == null) {
				view = View.inflate(mContext, R.layout.item_calendar, null);
				holder = new ViewHolder();
				holder.tvDay = view.findViewById(R.id.calendar_item_day);
				int singleWidth = totalWidth / 7;
				LinearLayout.LayoutParams params = new LayoutParams(singleWidth, singleWidth);
				Log.i("dayView", "item View width = "+singleWidth);
				view.setLayoutParams(params);
				view.setTag(holder);
			} else {
				holder = (ViewHolder) view.getTag();
			}
			DayData dayData = dayList.get(i);
			holder.tvDay.setText(dayData.getDay()+"");
			if(dayData.isCurrentMonth()) {
				holder.tvDay.setTextColor(Color.BLACK);
			} else {
				holder.tvDay.setTextColor(Color.GRAY);
			}
			if(dayData.isCurrentDay()) {
				holder.tvDay.setTextSize(20);
			} else {
				holder.tvDay.setTextSize(16);
			}
			return view;
		}

		private class ViewHolder {
			TextView tvDay;
		}
	}
}
