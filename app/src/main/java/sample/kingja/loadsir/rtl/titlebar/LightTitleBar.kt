package sample.kingja.loadsir.rtl.titlebar
import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.text.TextUtils
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import sample.kingja.loadsir.R

/**
 * 亮色主题的Title Bar
 *
 * @author shenjiayi@didiglobal.com
 * @since 2019/3/27
 */
class LightTitleBar @JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null, defStyleAttr: Int = 0) :
        LinearLayout(context, attributeSet, defStyleAttr) {
    private var statusBarStubAdded = false
    private val titleBar: View
    private val backButton: View
    private val titleText: TextView
    private val rightView: TextView
    private val titleShadow: View

    init {
        inflate(context, R.layout.driver_sdk_light_title_bar, this)
        orientation = VERTICAL
        titleBar = findViewById(R.id.title_bar)
        backButton = findViewById(R.id.back_button)
        backButton.setOnClickListener {
            if (context is Activity) {
                context.finish()
            }
        }
        titleText = findViewById(R.id.title_text)
        rightView = findViewById(R.id.right_button)
        rightView.visibility = View.GONE
        titleShadow = findViewById(R.id.title_shadow)
    }

    fun setTitle(title: CharSequence) {
        titleText.text = title
    }

    fun setBackButtonVisible(visible: Boolean) {
        if (visible) {
            backButton.visibility = View.VISIBLE
        } else {
            backButton.visibility = View.GONE
        }
    }

    fun setRightButton(title: CharSequence, listener: View.OnClickListener) {
        if (TextUtils.isEmpty(title)) {
            rightView.visibility = View.GONE
            return
        }
        rightView.visibility = View.VISIBLE
        rightView.text = title
        rightView.setOnClickListener(listener)
    }

    /**
     * 设置标题栏可见性但是保留占位符
     */
    fun setVisibilityWithStubShow(visible: Boolean) {
        if (visible) {
            titleBar.visibility = View.VISIBLE
            titleShadow.visibility = View.VISIBLE
        } else {
            titleBar.visibility = View.GONE
            titleShadow.visibility = View.GONE
        }
    }

    /**
     * 为Title Bar增加Status Bar的占位View
     */
    fun addStatusBarStub() {
        if (statusBarStubAdded) {
            return
        }
        var statusBarHeight = 0
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            statusBarHeight = resources.getDimensionPixelSize(resourceId)
        }
        val statusBarPadding = View(context)
        statusBarPadding.layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, statusBarHeight)
        statusBarPadding.setBackgroundColor(Color.WHITE)
        addView(statusBarPadding, 0)
        statusBarStubAdded = true
    }
}