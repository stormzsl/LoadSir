package sample.kingja.loadsir;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import sample.kingja.loadsir.target.AnimateActivity;
import sample.kingja.loadsir.target.BestPracticesActivity;
import sample.kingja.loadsir.target.ConstraintLayoutActivity;
import sample.kingja.loadsir.target.DefaultCallbackActivity;
import sample.kingja.loadsir.target.KeepTitleActivity;
import sample.kingja.loadsir.target.KeepTitleFragmentActivity;
import sample.kingja.loadsir.target.MultiFragmentActivity;
import sample.kingja.loadsir.target.FragmentSingleActivity;
import sample.kingja.loadsir.target.NormalActivity;
import sample.kingja.loadsir.target.ConvertorActivity;
import sample.kingja.loadsir.target.MultiFragmentWithViewPagerActivity;
import sample.kingja.loadsir.target.PlaceholderActivity;
import sample.kingja.loadsir.target.ViewTargetActivity;
import sample.kingja.loadsir.utils.KVUtilsJava;

/**
 * Description:TODO
 * Create Time:2017/9/2 16:02
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void inActivity(View view) {
        startActivity(new Intent(this, NormalActivity.class));
    }

    public void showPlaceholder(View view) {
        startActivity(new Intent(this, PlaceholderActivity.class));
    }

    public void inActivityWithConvertor(View view) {
        startActivity(new Intent(this, ConvertorActivity.class));
    }

    public void inFragment(View view) {
        startActivity(new Intent(this, FragmentSingleActivity.class));
    }

    public void inFragmentMutil(View view) {
        startActivity(new Intent(this, MultiFragmentActivity.class));
    }

    public void inFragmentViewSirPager(View view) {
        startActivity(new Intent(this, MultiFragmentWithViewPagerActivity.class));
    }

    public void inView(View view) {
        startActivity(new Intent(this, ViewTargetActivity.class));
    }

    public void defaultCallback(View view) {
        startActivity(new Intent(this, DefaultCallbackActivity.class));
    }

    public void animatCallback(View view) {
        startActivity(new Intent(this, AnimateActivity.class));
    }

    public void keepTitleInFragment(View view) {
        startActivity(new Intent(this, KeepTitleFragmentActivity.class));
    }

    public void bestPractices(View view) {
        startActivity(new Intent(this, BestPracticesActivity.class));
    }

    public void keepTitleInActivity(View view) {
        startActivity(new Intent(this, KeepTitleActivity.class));
    }

    public void inConstraintLayoutActivity(View view) {
        startActivity(new Intent(this, ConstraintLayoutActivity.class));
    }

    public void MMkvSave(View view){
        KVUtilsJava.put(KVUtilsJava.LOGIN_NAME_KEY,"stormzsl");
        Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
    }

    public void MMkvRead(View view){
       String value= KVUtilsJava.getString(KVUtilsJava.LOGIN_NAME_KEY,"null");
        Toast.makeText(this, "获取值:"+value, Toast.LENGTH_SHORT).show();
    }

    public void MMkvDelete(View view){
        KVUtilsJava.remove(KVUtilsJava.LOGIN_NAME_KEY);
        Toast.makeText(this, "删除成功", Toast.LENGTH_SHORT).show();
    }
}
