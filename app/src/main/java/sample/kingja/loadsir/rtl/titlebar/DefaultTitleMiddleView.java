package sample.kingja.loadsir.rtl.titlebar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;

import sample.kingja.loadsir.R;


/**
 * Created by chenlong on 16/10/25.
 */
public class DefaultTitleMiddleView extends FrameLayout {

    private TextView mTitleName;

    public DefaultTitleMiddleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    public DefaultTitleMiddleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public DefaultTitleMiddleView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        inflate(context, R.layout.driver_sdk_titlebar_default_middle, this);
        mTitleName = (TextView) findViewById(R.id.title_bar_name);
    }

    public String getText() {
        final CharSequence text = mTitleName.getText();
        return null == text ? "" : text.toString();
    }

    public void setText(String text) {
        mTitleName.setText(text);
    }

    public void setTextColor(Integer color) {
        if (color != null) {
            mTitleName.setTextColor(color);
        }
    }
}
