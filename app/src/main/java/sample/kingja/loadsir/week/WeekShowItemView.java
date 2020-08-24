package sample.kingja.loadsir.week;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import sample.kingja.loadsir.R;
import sample.kingja.loadsir.utils.DensityUtils;

/**
 * 作者:created by storm
 */

public class WeekShowItemView extends LinearLayout implements View.OnClickListener {

    private TextView mTitleTv;

    private TextView mSubTitleTv;

    private Context mContext;

    private WeekViewModel mWeekViewModel;

    private boolean mIsTodayFlag=false;

    public WeekShowItemView(Context context) {
        super(context);
        init(context);
    }

    public WeekShowItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public WeekShowItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public WeekShowItemView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width= DensityUtils.dp2px(mContext,40f);
        int height= DensityUtils.dp2px(mContext,55f);
        setMeasuredDimension(width,height);
    }

    private void init(Context context) {
        mContext=context;
        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER);
        LayoutInflater.from(context).inflate(R.layout.week_show_item_layout, this, true);
        mTitleTv = findViewById(R.id.week_title_tv);
        mSubTitleTv = findViewById(R.id.week_subtitle_tv);
        setOnClickListener(this::onClick);
    }

    public void setData(String title, String subTitle,WeekViewModel weekViewModel) {
        mTitleTv.setText(title);
        mSubTitleTv.setText(subTitle);
        mWeekViewModel=weekViewModel;
    }

    @Override
    public void onClick(View v) {
        if (mWeekViewModel.changeWeekItemBackground.getValue()!=this){
            mWeekViewModel.changeWeekItemBackground.setValue(this);
        }
    }

    public void setTodayColorStyle(){
        if(mIsTodayFlag){
            return;
        }
        mIsTodayFlag=true;
        mTitleTv.setTextColor(Color.parseColor("#FFFFDC16"));
        mSubTitleTv.setTextColor(Color.parseColor("#FFFFDC16"));
    }

    public void setSelected(boolean selected){
        if(selected){
            Drawable drawable=getResources().getDrawable(R.mipmap.week_shape_bg);
            setBackground(drawable);
        }else {
            setBackground(null);
        }

        if(mIsTodayFlag){
            if(selected){
                mTitleTv.setTextColor(Color.parseColor("#FF333333"));
                mSubTitleTv.setTextColor(Color.parseColor("#FF333333"));
            }else {
                mTitleTv.setTextColor(Color.parseColor("#FFFFDC16"));
                mSubTitleTv.setTextColor(Color.parseColor("#FFFFDC16"));
            }

        }

    }
}
