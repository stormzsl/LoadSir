package sample.kingja.loadsir.mmkv

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.tencent.mmkv.MMKV
import sample.kingja.loadsir.R
import sample.kingja.loadsir.utils.KVUtils
import sample.kingja.loadsir.utils.KVUtils.MMKV_LOGIN_NAME_KEY
import sample.kingja.loadsir.utils.USER_INFO

/**
 * 作者:created by storm
 */
class MMKVActivity : Activity() {
    private val spName = "test"
    private val SP_LOGIN_KEY = "login_key"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mmkv)
    }

    fun MMkvSave(view: View?) {
//        val start = System.currentTimeMillis()
//        KVUtils.put(MMKV_LOGIN_NAME_KEY, "stormzsl")
//        Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show()
//        val end = System.currentTimeMillis()
//        Log.e("stormzsl MMkvSave cost", (end - start).toString() + " ms")
        MMKV.mmkvWithID("test").edit().putString("stormkey","hhhhhhh").commit()
    }

    fun MMkvRead(view: View?) {
//        val start = System.currentTimeMillis()
//        val value = KVUtils.getString(MMKV_LOGIN_NAME_KEY, "null")
//        Toast.makeText(this, "获取值:$value", Toast.LENGTH_SHORT).show()
//        val end = System.currentTimeMillis()
//        Log.e("stormzsl MMkvRead cost", (end - start).toString() + " ms")
       Log.e("stormzsl",MMKV.mmkvWithID("test").getString("stormkey",null))
    }

    fun MMkvDelete(view: View?) {
        KVUtils.remove(MMKV_LOGIN_NAME_KEY)
        Toast.makeText(this, "删除成功", Toast.LENGTH_SHORT).show()
    }

    fun SPSave(view: View?) {
        val start = System.currentTimeMillis()
        getSharedPreferences(spName, Context.MODE_PRIVATE).edit().putString(SP_LOGIN_KEY, "stormSp").apply()
        val end = System.currentTimeMillis()
        Log.e("stormzsl SPSave cost", (end - start).toString() + " ms")
    }

    fun SPRead(view: View?) {
        val start = System.currentTimeMillis()
        val value = getSharedPreferences(spName, Context.MODE_PRIVATE).getString(SP_LOGIN_KEY, "null")
        val end = System.currentTimeMillis()
        Log.e("stormzsl SPSRead cost", (end - start).toString() + " ms " + value)
    }

    fun  importSharedPreferences(view: View?) {

        val mmkv = MMKV.mmkvWithID(USER_INFO)
        val spData= getSharedPreferences(spName, MODE_PRIVATE)
        // 迁移旧数据
        mmkv.importFromSharedPreferences(spData)
        // 清空旧数据
        spData.edit().clear().apply()

        KVUtils.getString(SP_LOGIN_KEY)?.let {
            Log.e("stormzsl importFromSP:",it)
        }


    }
}