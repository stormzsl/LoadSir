package sample.kingja.loadsir.rtl.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;

/**
 * 作者:created by storm
 */

public class RtlUtils {
    private static final RtlUtils INSTANCE = new RtlUtils();

    public static RtlUtils getInstance() {
        return INSTANCE;
    }

    private RtlUtils() {
    }

    public boolean shouldUseLayoutRtl(Context context) {
        final Configuration config = context.getApplicationContext().getResources().getConfiguration();
        if (android.os.Build.VERSION.SDK_INT >=
                android.os.Build.VERSION_CODES.JELLY_BEAN_MR1) {
            return View.LAYOUT_DIRECTION_RTL == config.getLayoutDirection();
        } else {
            return false;
        }
    }
}
