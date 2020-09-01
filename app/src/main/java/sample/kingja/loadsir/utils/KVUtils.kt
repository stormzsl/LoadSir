package sample.kingja.loadsir.utils

import android.content.Context
import com.tencent.mmkv.MMKV


/**
 * 作者:created by storm
 */
object KVUtils {
    const val LOGIN_NAME_KEY = "login_name_key"

    fun init(context: Context?): String? {
        return MMKV.initialize(context)
    }

    fun getInt(key: String?, defaultValue: Int): Int {
        return MMKV.defaultMMKV().decodeInt(key, defaultValue)
    }

    fun getLong(key: String?, defaultValue: Long): Long {
        return MMKV.defaultMMKV().decodeLong(key, defaultValue)
    }

    fun getFloat(key: String?, defaultValue: Float): Float {
        return MMKV.defaultMMKV().decodeFloat(key, defaultValue)
    }

    fun getDouble(key: String?, defaultValue: Double): Double {
        return MMKV.defaultMMKV().decodeDouble(key, defaultValue)
    }

    fun getString(key: String?, defaultValue: String?): String? {
        return MMKV.defaultMMKV().decodeString(key, defaultValue)
    }


    fun put(key: String?, value: Int) {
        MMKV.defaultMMKV().encode(key, value)
    }

    fun put(key: String?, value: Long) {
        MMKV.defaultMMKV().encode(key, value)
    }

    fun put(key: String?, value: Float) {
        MMKV.defaultMMKV().encode(key, value)
    }

    fun put(key: String?, value: Double) {
        MMKV.defaultMMKV().encode(key, value)
    }

    fun put(key: String?, value: String?) {
        MMKV.defaultMMKV().encode(key, value)
    }

    fun remove(key: String?) {
        MMKV.defaultMMKV().removeValueForKey(key)
    }

    fun removeValuesForKeys(keys: Array<out String>?) {
        MMKV.defaultMMKV().removeValuesForKeys(keys)
    }

    fun isEmpty(str: CharSequence?): Boolean {
        return str == null || str.length == 0
    }

}
