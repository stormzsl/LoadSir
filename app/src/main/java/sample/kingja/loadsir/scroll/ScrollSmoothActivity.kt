package sample.kingja.loadsir.scroll

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ScrollView
import android.widget.TextView
import sample.kingja.loadsir.R

/**
 * 作者:created by storm
 */

class ScrollSmoothActivity : Activity() {

    lateinit var rootScrollView: ScrollView

    lateinit var jumpPositionTv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll_smooth)
        rootScrollView = findViewById(R.id.root_view)
        jumpPositionTv = findViewById(R.id.jump_position_tv)


    }

    fun jumpTo(view: View) {
        rootScrollView.post {
            val location = IntArray(2)
            jumpPositionTv.getLocationOnScreen(location)
            var offset: Int = location[1]-getStatusBarHeight()
            if (offset < 0) {
                offset = 0
            }
            getStatusBarHeight()
            getDaoHangHeight()
            Log.e("stormzsl", "jumpPositionTv x=${jumpPositionTv.x},y=${jumpPositionTv.y}")
            Log.e("stormzsl", "jumpPositionTv location[0]=${location[1]},location[1]=${location[1]}, root height=${rootScrollView.height},root measuredHeight=${rootScrollView.measuredHeight} ")
            rootScrollView.smoothScrollTo(0, offset)
        }
    }

    private fun getStatusBarHeight():Int {
        var statusBarHeight = -1
        //获取status_bar_height资源的ID
        var resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            //根据资源ID获取响应的尺寸值
            statusBarHeight = resources.getDimensionPixelSize(resourceId);
        }
        Log.e("stormzsl", "getStatusBarHeight=$statusBarHeight")
        return statusBarHeight
    }

    /**
     * 获取导航栏高度
     * @param context
     * @return
     */
    private fun getDaoHangHeight(): Int {
        var result = 0
        var resourceId = 0
        var rid = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (rid != 0) {
            resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
            Log.e("stormzsl", "getDaoHangHeight=${resources.getDimensionPixelSize(resourceId)}");
            return resources.getDimensionPixelSize(resourceId);
        } else
            return 0;
    }

}