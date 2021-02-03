package sample.kingja.loadsir;

import android.app.Application;
import android.util.Log;

import com.didiglobal.android.advanced.monitor.BlockMonitorManager;
import com.didiglobal.android.advanced.monitor.MonitorCore;
import com.kingja.loadsir.core.LoadSir;
import com.squareup.leakcanary.LeakCanary;
import sample.kingja.loadsir.callback.CustomCallback;
import sample.kingja.loadsir.callback.EmptyCallback;
import sample.kingja.loadsir.callback.ErrorCallback;
import sample.kingja.loadsir.callback.LoadingCallback;
import sample.kingja.loadsir.callback.TimeoutCallback;
import sample.kingja.loadsir.utils.KVUtils;

/**
 * Description:TODO
 * Create Time:2017/9/3 14:02
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        String rootDir = KVUtils.INSTANCE.init(this);
        Log.e("stormzsl","rootDir="+rootDir);
        if (setupLeakCanary()) {
            return;
        }

        LoadSir.beginBuilder()
                .addCallback(new ErrorCallback())
                .addCallback(new EmptyCallback())
                .addCallback(new LoadingCallback())
                .addCallback(new TimeoutCallback())
                .addCallback(new CustomCallback())
                .setDefaultCallback(LoadingCallback.class)
                .commit();
        BlockMonitorManager.getInstance().start();
    }

    private boolean setupLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return true;
        }
        LeakCanary.install(this);
        return false;
    }
}
