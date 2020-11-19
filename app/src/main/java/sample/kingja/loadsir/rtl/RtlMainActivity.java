package sample.kingja.loadsir.rtl;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import sample.kingja.loadsir.R;
import sample.kingja.loadsir.rtl.utils.RtlUtils;

/**
 * 作者:created by storm
 */

public class RtlMainActivity extends Activity {

    private ListView listView;
    private ImageView arrowView;
    private LinearLayout rootView;
    private Button btLeft;
    private Button btRight;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rtl_main);
        initView();
        bindData();
        Log.e("stormzsl", "shouldUseLayoutRtl:"+RtlUtils.getInstance().shouldUseLayoutRtl(this));
        if(RtlUtils.getInstance().isRtl(getApplicationContext())){
            Log.e("stormzsl","is rtl");
        }

        if(RtlUtils.getInstance().shouldUseLayoutRtl(getApplicationContext())){
            Log.e("stormzsl","shouldUseLayoutRtl");
        }
    }



    private void initView(){
        btLeft=findViewById(R.id.bt_left);
        btRight=findViewById(R.id.bt_right);
        rootView=findViewById(R.id.root_view);
        listView=findViewById(R.id.listview);
        arrowView=findViewById(R.id.arrow_iv);
        arrowView.setImageDrawable(RtlUtils.setAutoMirrored(getApplicationContext(),R.drawable.arrow));
//        rootView.setBackground(RtlUtils.setAutoMirrored(getApplicationContext(),R.drawable.bg_wallet_entry));
        btLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int left=btLeft.getLeft();
               Log.e("stormzsl","btnLeft start left="+left);
//                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(btLeft, "translationX", 0.0f, 350.0f, 0.0f);//沿着x轴平移
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(btLeft, "translationX", 0.0f, 100.0f);//沿着x轴平移
                AnimatorSet bouncer = new AnimatorSet();//创建一个动画集合类
                bouncer.play(objectAnimator);//play:先播放animator with:同时播放animator2 after:在某动画后播放 before:再某动画前播放
                bouncer.setDuration(2000);//持续时间
                bouncer.start();//开始动画
                objectAnimator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        Log.e("stormzsl","btnLeft end left="+btLeft.getLeft());
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
            }
        });

        btRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(btLeft, "translationX", 100.0f,0.0f);//沿着x轴平移
                AnimatorSet bouncer = new AnimatorSet();//创建一个动画集合类
                bouncer.play(objectAnimator);//play:先播放animator with:同时播放animator2 after:在某动画后播放 before:再某动画前播放
                bouncer.setDuration(2000);//持续时间
                bouncer.start();//开始动画
            }
        });


    }

    private void bindData() {
        List<String> List = new ArrayList<String>();//声明集合
        List.add("列表1");
        List.add("列表2");
        List.add("列表3");

       ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, List);
        listView.setAdapter(adapter);
    }


}
