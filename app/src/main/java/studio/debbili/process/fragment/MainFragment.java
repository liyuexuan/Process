package studio.debbili.process.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Calendar;

import studio.debbili.process.R;
import studio.debbili.process.utils.CalendarUtil;
import studio.debbili.process.view.calendar.CalendarHeaderView;
import studio.debbili.process.view.calendar.EventCalenadarView;
import studio.debbili.process.view.calendar.FunEventCalenadarView;

/**
 * Created by Debbili on 2019/12/1.
 */
public class MainFragment extends Fragment {

	public static MainFragment newInstance() {
		MainFragment fragment = new MainFragment();
		Bundle args = new Bundle();
		fragment.setArguments(args);
		return fragment;
	}
	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_main, container, false);
		return view;
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		initView(view);
	}

	private void initView(View rootView) {
		EventCalenadarView eventCalenadarView = rootView.findViewById(R.id.event_calendar_view);
		eventCalenadarView.setData(Calendar.getInstance());
		eventCalenadarView.setVisibility(View.VISIBLE);

		FunEventCalenadarView funEventCalenadarView = rootView.findViewById(R.id.fun_event_calendar_view);
		funEventCalenadarView.setVisibility(View.GONE);
//		funEventCalenadarView.setData(CalendarUtil.getCurrentDataList());
//		funEventCalenadarView.setHeaderView();
		Log.i("dayList", "vie "+eventCalenadarView.toString());
//		eventCalenadarView.setData("12", "2019/12/01", "0 todo");
	}
}
