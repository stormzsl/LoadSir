package sample.kingja.loadsir.rtl.titlebar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;

import sample.kingja.loadsir.R;

/**
 * Created by chenlong on 16/10/25.
 */
public class DefaultTitleRightView extends FrameLayout {

    private TextView mRightBtn;

    public DefaultTitleRightView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    public DefaultTitleRightView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public DefaultTitleRightView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        inflate(context, R.layout.driver_sdk_titlebar_default_right, this);
        mRightBtn = (TextView) findViewById(R.id.titlebar_right_btn);
    }

    public void setText(String text) {
        mRightBtn.setText(text);
    }

    public void setTextColor(Integer color) {
        if (color != null) {
            mRightBtn.setTextColor(color);
        }
    }
}
