package sample.kingja.loadsir.rtl.titlebar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.ColorInt;
import sample.kingja.loadsir.R;


/**
 * 标题栏视图
 *
 * @author Stephen He
 * @since 2014-5-26
 */
public class TitleBar extends RelativeLayout {
    /**
     * titleBar的整体布局
     */
    private RelativeLayout mTitleBarLayoutMain;
    /**
     * titleBar的左侧布局
     */
    private LinearLayout mLayoutTopLeft;
    /**
     * titleBar的中间布局
     */
    private LinearLayout mLayoutTopMiddle;
    /**
     * titleBar的右侧布局
     */
    private LinearLayout mLayoutTopRight;
    /**
     * titleBar的默认左侧布局
     */
    private DefaultTitleLeftView mDefaultTitleLeftView;
    /**
     * titleBar的默认中间布局
     */
    private DefaultTitleMiddleView mDefaultTitleMidTextView;
    /**
     * titleBar的默认右侧布局
     */
    private DefaultTitleRightView mDefaultTitleRightView;


    public TitleBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleBar(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        inflate(context, R.layout.driver_sdk_titlebar, this);
        mTitleBarLayoutMain = findViewById(R.id.main_layout);
        mLayoutTopLeft = (LinearLayout) findViewById(R.id.layout_top_back);
        mLayoutTopMiddle = (LinearLayout) findViewById(R.id.layout_top_middle);
        mLayoutTopRight = (LinearLayout) findViewById(R.id.layout_top_right);
        mDefaultTitleLeftView = new DefaultTitleLeftView(context);
        mDefaultTitleMidTextView = new DefaultTitleMiddleView(context);
        mDefaultTitleRightView = new DefaultTitleRightView(context);
    }

    public String getTitle() {
        return this.mDefaultTitleMidTextView.getText();
    }

    /**
     * 获取有返回键的标题栏
     */
    public void setTitleHasBack(String titleName, OnClickListener backListener) {
        setTitle(titleName, backListener, null, null);
    }

    /**
     * 设置titlebar背景色
     */
    public void setTitleBgColor(@ColorInt int color) {
        mTitleBarLayoutMain.setBackgroundColor(color);
    }


    /**
     * 获取有返回键的标题栏
     */
    public void setTitleHasBack(int resId, OnClickListener backListener) {
        setTitle(resId, backListener, 0, null);
    }

    /**
     * 设置 标题栏 title name
     */
    public void setTitleName(int titleNameResId) {
        Context context = getContext();
        String titleName = null;
        if (titleNameResId != 0) {
            titleName = context.getString(titleNameResId);
        }
        setTitleName(titleName);
    }

    /**
     * 设置 标题栏 title name
     */
    public void setTitleName(String titleName) {
        setTitle(titleName, null, null);
    }

    /**
     * 设置完整的自定义titarbar view
     *
     * @param titleName
     * @param leftView
     * @param rightView
     */
    public void setTitle(String titleName, View leftView, View rightView) {
        if (TextUtils.isEmpty(titleName)) {
            mLayoutTopMiddle.setVisibility(View.GONE);
        } else {
            mDefaultTitleMidTextView.setText(titleName);
            replaceView(mLayoutTopMiddle, mDefaultTitleMidTextView);
        }
        if (leftView != null) {
            replaceLeftView(leftView);
        }
        if (rightView != null) {
            replaceRightView(rightView);
        }

    }


    /**
     * 设置完整标题栏
     *
     * @param titleNameResId
     * @param leftListener
     * @param rightStrResId
     * @param rightListener
     */
    public void setTitle(int titleNameResId, OnClickListener leftListener,
                         int rightStrResId, OnClickListener rightListener) {

        Context context = getContext();
        String titleName = null;
        if (titleNameResId != 0) {
            titleName = context.getString(titleNameResId);
        }
        String rightStr = null;
        if (rightStrResId != 0) {
            rightStr = context.getString(rightStrResId);
        }

        setTitle(titleName, leftListener, rightStr, rightListener);
    }

    public void setTitle(String titleName, OnClickListener leftListener,
                         String rightStr, OnClickListener rightListener) {
        setTitle(titleName, null, leftListener, rightStr, null, rightListener);
    }

    /**
     * 设置完整的默认展示样式的标题栏, 左中右布局的visible在这控制
     *
     * @param titleName     为空,则gone
     * @param titleColor    title颜色
     * @param leftListener  为空,则gone
     * @param rightStr      为空,则gone
     * @param rightListener 为空,则gone
     * @param rightColor    right 按钮颜色
     */
    public void setTitle(String titleName, Integer titleColor, OnClickListener leftListener,
                         String rightStr, Integer rightColor, OnClickListener rightListener) {
        if (TextUtils.isEmpty(titleName)) {
            mLayoutTopMiddle.setVisibility(View.GONE);
        } else {
            mDefaultTitleMidTextView.setText(titleName);
            mDefaultTitleMidTextView.setTextColor(titleColor);
            replaceView(mLayoutTopMiddle, mDefaultTitleMidTextView);
        }
        if (leftListener != null) {
            mLayoutTopLeft.setOnClickListener(leftListener);
            replaceView(mLayoutTopLeft, mDefaultTitleLeftView);
        } else {
            mLayoutTopLeft.setVisibility(View.INVISIBLE);
        }
        if (!TextUtils.isEmpty(rightStr) && rightListener != null) {
            mDefaultTitleRightView.setText(rightStr);
            mDefaultTitleRightView.setTextColor(rightColor);
            mLayoutTopRight.setOnClickListener(rightListener);
            replaceView(mLayoutTopRight, mDefaultTitleRightView);
        } else {
            mLayoutTopRight.setVisibility(View.INVISIBLE);
        }

    }


    /**
     * 替换左侧布局, view == null 则左侧布局gone
     *
     * @param view
     */
    public void replaceLeftView(View view) {
        if (null == view) {
            mLayoutTopLeft.setVisibility(View.GONE);
            return;
        }
        replaceView(mLayoutTopLeft, view);
    }

    public void setLeftViewBg(int res) {
        if (mLayoutTopLeft != null) {
            mLayoutTopLeft.setBackgroundResource(res);
        }
    }

    /**
     * 替换中间布局, view == null 则中间布局gone
     */
    public void replaceMiddleView(View view) {
        if (null == view) {
            mLayoutTopMiddle.setVisibility(View.GONE);
            return;
        }
        replaceView(mLayoutTopMiddle, view);
    }

    /**
     * 替换右侧布局, view == null 则右侧布局gone
     */
    public void replaceRightView(View view) {
        if (null == view) {
            mLayoutTopRight.setVisibility(View.GONE);
            return;
        }
        replaceView(mLayoutTopRight, view);
    }

    private void replaceView(LinearLayout viewGroup, View view) {
        if (null != view && null != viewGroup) {
            viewGroup.removeAllViews();
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
            viewGroup.addView(view, params);
            viewGroup.setVisibility(View.VISIBLE);
        }
    }

    public void setLeftVisible(boolean visible) {
        if (null != mLayoutTopLeft) {
            if (visible) {
                mLayoutTopLeft.setVisibility(View.VISIBLE);
            } else {
                mLayoutTopLeft.setVisibility(View.GONE);
            }
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
