package sample.kingja.loadsir.mmkv;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import sample.kingja.loadsir.R;
import sample.kingja.loadsir.utils.KVUtilsJava;

/**
 * 作者:created by storm
 */

public class MMKVActivity extends Activity {
    private String spName="test";

    private String LOGIN_KEY="login_key";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mmkv);
    }

    public void MMkvSave(View view) {
        long start=System.currentTimeMillis();
        KVUtilsJava.put(KVUtilsJava.LOGIN_NAME_KEY,"stormzsl");
        Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
        long end=System.currentTimeMillis();
        Log.e("stormzsl MMkvSave cost",(end-start)+" ms");
    }

    public void MMkvRead(View view){
        long start=System.currentTimeMillis();
        String value= KVUtilsJava.getString(KVUtilsJava.LOGIN_NAME_KEY,"null");
        Toast.makeText(this, "获取值:"+value, Toast.LENGTH_SHORT).show();
        long end=System.currentTimeMillis();
        Log.e("stormzsl MMkvRead cost",(end-start)+" ms");
    }

    public void MMkvDelete(View view){
        KVUtilsJava.remove(KVUtilsJava.LOGIN_NAME_KEY);
        Toast.makeText(this, "删除成功", Toast.LENGTH_SHORT).show();
    }

    public void SPSave(View view) throws Exception {
        long start=System.currentTimeMillis();
        getSharedPreferences(spName,MODE_PRIVATE).edit().putString(LOGIN_KEY,"storm").apply();
        long end=System.currentTimeMillis();
        Log.e("stormzsl SPSave cost",(end-start)+" ms");
        throw new Exception("error");
    }

    public void SPRead(View view){
        long start=System.currentTimeMillis();
        String value= getSharedPreferences(spName,MODE_PRIVATE).getString(LOGIN_KEY,"null");
        long end=System.currentTimeMillis();
        Log.e("stormzsl SPSRead cost",(end-start)+" ms " +value);
    }

}
