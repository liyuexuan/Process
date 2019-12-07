package studio.debbili.process.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import studio.debbili.process.R;

/**
 * Created by Debbili on 2019/12/7.
 */
public class FunImageView extends LinearLayout {

	private Context mContext;
	private LinearLayout mRootView;

	public FunImageView(Context context) {
		super(context, null);
	}

	public FunImageView(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		inflate(context, R.layout.fun_image_view, this);
		initView();
	}

	private void initView() {
		mRootView = findViewById(R.id.fun_image_root);
	}

	public void setShowText(String showText) {
		mRootView.removeAllViews();
		char[] showArray = showText.toCharArray();
		for(int i=0; i<showArray.length; i++) {
			ImageView imageView = new ImageView(mContext);
			imageView.setImageDrawable(mContext.getDrawable(matchImageId(showArray[i])));
			LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
			imageView.setLayoutParams(params);
			mRootView.addView(imageView);
		}
	}

	private int matchImageId(char chr) {
		switch (chr) {
			case '一':
				return R.drawable.up_one;
			case '二':
				return R.drawable.up_two;
			case '三':
				return R.drawable.up_three;
			case '四':
				return R.drawable.up_four;
			case '五':
				return R.drawable.up_five;
			case '六':
				return R.drawable.up_six;
			case '七':
				return R.drawable.up_seven;
			case '八':
				return R.drawable.up_eight;
			case '九':
				return R.drawable.up_nine;
			case '十':
				return R.drawable.up_ten;
			case '月':
				return R.drawable.up_month;
			case '日':
				return R.drawable.up_day;
			case '年':
				return R.drawable.up_year;
			default:
				return R.drawable.up_one;
		}
	}
}
