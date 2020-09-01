package sample.kingja.loadsir.mmkv

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import sample.kingja.loadsir.R
import sample.kingja.loadsir.utils.KVUtilsJava

/**
 * 作者:created by storm
 */
class MMKVActivity : Activity() {
    private val spName = "test"
    private val LOGIN_KEY = "login_key"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mmkv)
    }

    fun MMkvSave(view: View?) {
        val start = System.currentTimeMillis()
        KVUtilsJava.put(KVUtilsJava.LOGIN_NAME_KEY, "stormzsl")
        Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show()
        val end = System.currentTimeMillis()
        Log.e("stormzsl MMkvSave cost", (end - start).toString() + " ms")
    }

    fun MMkvRead(view: View?) {
        val start = System.currentTimeMillis()
        val value = KVUtilsJava.getString(KVUtilsJava.LOGIN_NAME_KEY, "null")
        Toast.makeText(this, "获取值:$value", Toast.LENGTH_SHORT).show()
        val end = System.currentTimeMillis()
        Log.e("stormzsl MMkvRead cost", (end - start).toString() + " ms")
    }

    fun MMkvDelete(view: View?) {
        KVUtilsJava.remove(KVUtilsJava.LOGIN_NAME_KEY)
        Toast.makeText(this, "删除成功", Toast.LENGTH_SHORT).show()
    }

    @Throws(Exception::class)
    fun SPSave(view: View?) {
        val start = System.currentTimeMillis()
        getSharedPreferences(spName, Context.MODE_PRIVATE).edit().putString(LOGIN_KEY, "storm").apply()
        val end = System.currentTimeMillis()
        Log.e("stormzsl SPSave cost", (end - start).toString() + " ms")
        throw Exception("error")
    }

    fun SPRead(view: View?) {
        val start = System.currentTimeMillis()
        val value = getSharedPreferences(spName, Context.MODE_PRIVATE).getString(LOGIN_KEY, "null")
        val end = System.currentTimeMillis()
        Log.e("stormzsl SPSRead cost", (end - start).toString() + " ms " + value)
    }
}