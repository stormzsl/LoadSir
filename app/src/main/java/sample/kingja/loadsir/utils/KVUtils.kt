package sample.kingja.loadsir.utils

import android.content.Context
import com.tencent.mmkv.MMKV


/**
 * 作者:created by storm
 */
object KVUtils {
    const val MMKV_LOGIN_NAME_KEY = "login_name_key"

    fun init(context: Context?): String? {
        return MMKV.initialize(context)
    }

    fun getInt(key: String?, defaultValue: Int=0): Int {
        return MMKV.mmkvWithID(USER_INFO).decodeInt(key, defaultValue)
    }

    fun getLong(key: String?, defaultValue: Long=0L): Long {
        return MMKV.mmkvWithID(USER_INFO).decodeLong(key, defaultValue)
    }

    fun getFloat(key: String?, defaultValue: Float=0f): Float {
        return MMKV.mmkvWithID(USER_INFO).decodeFloat(key, defaultValue)
    }

    fun getDouble(key: String?, defaultValue: Double=0.0): Double {
        return MMKV.mmkvWithID(USER_INFO).decodeDouble(key, defaultValue)
    }

    fun getString(key: String?, defaultValue: String?=null): String? {
        return MMKV.mmkvWithID(USER_INFO).decodeString(key, defaultValue)
    }


    fun put(key: String?, value: Int) {
        MMKV.mmkvWithID(USER_INFO).encode(key, value)
    }

    fun put(key: String?, value: Long) {
        MMKV.mmkvWithID(USER_INFO).encode(key, value)
    }

    fun put(key: String?, value: Float) {
        MMKV.mmkvWithID(USER_INFO).encode(key, value)
    }

    fun put(key: String?, value: Double) {
        MMKV.mmkvWithID(USER_INFO).encode(key, value)
    }

    fun put(key: String?, value: String?) {
        MMKV.mmkvWithID(USER_INFO).encode(key, value)
//        MMKV.mmkvWithID(USER_INFO).edit().putString("stormKey", "stormzl").apply();
    }

    fun remove(key: String?) {
        MMKV.mmkvWithID(USER_INFO).removeValueForKey(key)
    }

    fun removeValuesForKeys(keys: Array<out String>?) {
        MMKV.mmkvWithID(USER_INFO).removeValuesForKeys(keys)
    }

    fun isEmpty(str: CharSequence?): Boolean {
        return str == null || str.length == 0
    }


}
