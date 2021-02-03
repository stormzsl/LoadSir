package com.didiglobal.android.advanced.monitor;

import android.os.Looper;

/**
 * 作者:created by storm
 */

public class BlockMonitorManager {

    private MonitorCore monitorCore;

    private static class Holder {
        static BlockMonitorManager INSTANCE = new BlockMonitorManager();
    }

    private BlockMonitorManager() {

    }

    public static BlockMonitorManager getInstance() {
        return Holder.INSTANCE;
    }

    public void start() {
        if (monitorCore == null) {
            monitorCore = new MonitorCore();
        }
        Looper.getMainLooper().setMessageLogging(monitorCore);
        monitorCore.startDump();
    }

    public void stop() {
        Looper.getMainLooper().setMessageLogging(null);
        if (monitorCore != null) {
            monitorCore.stopDump();
        }

    }
}
