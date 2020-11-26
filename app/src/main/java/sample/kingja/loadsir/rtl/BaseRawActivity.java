package sample.kingja.loadsir.rtl;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.fragment.app.FragmentActivity;
import sample.kingja.loadsir.R;
import sample.kingja.loadsir.rtl.titlebar.LightTitleBar;
import sample.kingja.loadsir.rtl.titlebar.TitleBar;
import sample.kingja.loadsir.rtl.utils.RtlUtils;

/**
 * FragmentActivity 基础类
 */
public abstract class BaseRawActivity extends FragmentActivity {

    private final static int DEF_TIMEOUT = 25;

    public static long homePageOnStopTime;

    /**
     * 是否有返回按钮，默认为显示
     */
    @SuppressWarnings("checkstyle:MemberName")
    protected boolean hasGoBack = true;

    /**
     * 当前Activity是否处于暂停状态
     */
    private boolean mIsPaused = false;
    /**
     * 网络错误view
     */
    private View mNetworkErrorView;

    private final static String PARAMS_GO_BACK="params_go_back";


    /**
     * 所有activity的堆栈 talkingdata crash java.util.ConcurrentModificationException
     */
    protected static final List<BaseRawActivity> ACTIVITIES = Collections.synchronizedList(new ArrayList<BaseRawActivity>());

    @SuppressWarnings("checkstyle:MemberName")
    protected final String TAG = getClass().getSimpleName();

    protected View mBaseView;
    protected boolean mShowTitleBar = true;
    protected TitleBar mTitleBar;
    protected LightTitleBar mLightTitleBar;

    protected Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ACTIVITIES.add(this);
        onInit(getIntent());
    }

    @Override
    public void setContentView(int layoutResID) {
        mBaseView = getLayoutInflater().inflate(layoutResID, null);
        this.setContentView(mBaseView);
    }

    @Override
    public void setContentView(View view) {
        View content = addTitleBarAndNetworkErrorView(view);
        super.setContentView(content);
    }

    private View addTitleBarAndNetworkErrorView(View view) {
        if (!mShowTitleBar && !isShowNetworkErrorView()) {
            return view;
        }
        // 创建一个RelativeLayout去加入附加view
        RelativeLayout layout = new RelativeLayout(view.getContext());
        // 由于需要将Title置于Content上方（需要显示阴影），创建LayoutParams去控制
        RelativeLayout.LayoutParams contentParams;
        final int w = LayoutParams.MATCH_PARENT;
        contentParams = new RelativeLayout.LayoutParams(w, w);
        view.setLayoutParams(contentParams);
        if (view.getId() == View.NO_ID) {
            view.setId(R.id.base_raw_activity_content_view);
        }
        layout.addView(view);
        // 加入title bar
        if (mShowTitleBar) {
            // 创建TitleView，根据是否使用Light主题来添加普通Title/Light Title
            View titleView;
            RelativeLayout.LayoutParams titleParams = new RelativeLayout.LayoutParams(
                    LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            if (isLightTheme()) {
                mLightTitleBar = new LightTitleBar(view.getContext());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    mLightTitleBar.addStatusBarStub();
                }
                titleParams.bottomMargin = -RtlUtils.dip2px(getApplicationContext(),6);
                mLightTitleBar.setLayoutParams(titleParams);
                titleView = mLightTitleBar;
            } else {
                mTitleBar = new TitleBar(view.getContext());
                mTitleBar.setLayoutParams(titleParams);
                titleView = mTitleBar;
            }
            titleView.setId(R.id.base_raw_activity_title_view);
            // 设置Content Layout Params的属性
            contentParams.addRule(RelativeLayout.BELOW, R.id.base_raw_activity_title_view);
            // 先放入content再放入title
            layout.addView(titleView);
        }
        // 加入网络错误view
        if (isShowNetworkErrorView()) {
            mNetworkErrorView = getLayoutInflater().inflate(
                    R.layout.driver_sdk_network_error_retry_layout, layout, false);
            RelativeLayout.LayoutParams networkErrorParams = new RelativeLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
            );
            networkErrorParams.addRule(RelativeLayout.ALIGN_TOP, view.getId());
            mNetworkErrorView.setLayoutParams(networkErrorParams);
            mNetworkErrorView.setVisibility(View.GONE);
            mNetworkErrorView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onNetworkErrorViewClicked();
                }
            });
            layout.addView(mNetworkErrorView);
        }
        return layout;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        onInit(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsPaused = false;
    }

    @Override
    @SuppressLint("MissingSuperCall")
    protected void onSaveInstanceState(Bundle outState) {
        // No call for super(). Bug on API Level > 11.
        try {
            if (outState != null) {
                // remove掉保存的Fragment
                outState.remove("android:support:fragments");
            }
        } catch (Exception ignore) {
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mIsPaused = true;
        // TCAgent.onPause(this); // 统计sdk
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void finish() {
        super.finish();
        ACTIVITIES.remove(this);
    }

    @Override
    protected void onDestroy() {
        ACTIVITIES.remove(this);
        super.onDestroy();
        nullViewDrawablesRecursive(mBaseView);
        mBaseView = null;
    }

    private void onInit(Intent intent) {
        checkGoBack(intent);
        if (isLightTheme()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                getWindow().getDecorView().setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
        }
    }

    private void checkGoBack(Intent intent) {
        try {
            if (intent != null) {
                hasGoBack = intent.getBooleanExtra(PARAMS_GO_BACK, true);
            }
        } catch (Exception ignore) {
        }
    }

    /**
     * 展示听单设置页面
     */
    public void showOrderSettings() {
    }

    @Override
    public void onBackPressed() {
        onGoBack();
    }

    /**
     * 返回键事件处理，子类无需在自行重写onBackPressed
     */
    protected boolean onGoBack() {
        if (hasGoBack) {
            try {
                super.onBackPressed();
            } catch (Exception ignore) {
            }
        }
        return true;
    }

    /**
     * 当前activity是否处于pause状态
     */
    public boolean isPaused() {
        return mIsPaused;
    }

    /**
     * Force remove View's drawable
     */
    private void nullViewDrawablesRecursive(View view) {
        if (view == null) {
            return;
        }
        try {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int index = 0; index < childCount; index++) {
                View child = viewGroup.getChildAt(index);
                if (child instanceof ViewGroup) {
                    nullViewDrawablesRecursive(child);
                } else {
                    nullViewDrawable(child);
                }
            }
        } catch (Exception ignore) {
        }
        nullViewDrawable(view);
    }

    /**
     * remove the view's drawable
     */
    private void nullViewDrawable(View view) {
        if (view == null) {
            return;
        }
        if (view instanceof ImageView) {
            try {
                ImageView imageView = (ImageView) view;
                imageView.setImageDrawable(null);
                imageView.setImageResource(0);
                imageView.setImageBitmap(null);
            } catch (Exception ignore) {
            }
        }
        nullBackground(view);
    }

    private void nullBackground(View view) {
        if (view == null) {
            return;
        }
        try {
            if (view.getBackground() != null) {
                view.getBackground().setCallback(null);
            }

            view.setBackgroundDrawable(null);
        } catch (Exception ignore) {
        }
    }

    /**
     * 是否使用亮色主题
     */
    protected boolean isLightTheme() {
        return false;
    }

    /**
     * 是否展示网络错误view
     */
    protected boolean isShowNetworkErrorView() {
        return false;
    }

    /**
     * 展示网络错误view
     *
     * @return 网络错误view, 可以做一些定制
     */
    protected View showNetworkErrorView() {
        mNetworkErrorView.setVisibility(View.VISIBLE);
        return mNetworkErrorView;
    }

    /**
     * 隐藏网络错误view
     */
    protected void hideNetworkErrorView() {
        mNetworkErrorView.setVisibility(View.GONE);
    }

    /**
     * 网络错误view点击事件
     */
    protected void onNetworkErrorViewClicked() {

    }
}
