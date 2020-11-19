package sample.kingja.loadsir.rtl.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

import androidx.core.text.TextUtilsCompat;
import androidx.core.view.ViewCompat;

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

    public boolean isRtl(Context context) {
        return TextUtilsCompat.getLayoutDirectionFromLocale(context.getResources().getConfiguration().locale) ==ViewCompat.LAYOUT_DIRECTION_RTL;
    }


    //是否使用RTL布局
    public boolean shouldUseLayoutRtl(Context context) {
        final Configuration config = context.getApplicationContext().getResources().getConfiguration();
        if (android.os.Build.VERSION.SDK_INT >=
                android.os.Build.VERSION_CODES.JELLY_BEAN_MR1) {
            return View.LAYOUT_DIRECTION_RTL == config.getLayoutDirection();
        } else {
            return false;
        }
    }

    public static Drawable setAutoMirrored(Context context, int resourceId){
        Drawable drawable = context.getResources().getDrawable(resourceId);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (drawable != null) {
                drawable.setAutoMirrored(true);
            }
        }
        return drawable;
    }


}
