package sample.kingja.loadsir.rtl.titlebar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import sample.kingja.loadsir.R;

/**
 * Created by chenlong on 16/10/25.
 */
public class DefaultTitleLeftView extends FrameLayout {

    public DefaultTitleLeftView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public DefaultTitleLeftView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DefaultTitleLeftView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        inflate(context, R.layout.driver_sdk_titlebar_default_left, this);
    }

}
