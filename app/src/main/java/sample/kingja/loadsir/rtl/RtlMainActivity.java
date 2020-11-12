package sample.kingja.loadsir.rtl;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
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
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rtl_main);
        initView();
        bindData();
        Log.e("stormzsl", "shouldUseLayoutRtl:"+RtlUtils.getInstance().shouldUseLayoutRtl(this));
    }



    private void initView(){
        listView=findViewById(R.id.listview);

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
