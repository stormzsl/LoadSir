package sample.kingja.loadsir.rtl;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import sample.kingja.loadsir.R;
import sample.kingja.loadsir.rtl.utils.RtlUtils;

/**
 * 作者:created by storm
 */

public class RtlMainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rtl_main);
        Log.e("stormzsl", "shouldUseLayoutRtl:"+RtlUtils.getInstance().shouldUseLayoutRtl(this));
    }



}
