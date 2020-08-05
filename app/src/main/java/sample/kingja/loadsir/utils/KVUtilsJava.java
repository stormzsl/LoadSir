package sample.kingja.loadsir.utils;

import android.content.Context;

import com.tencent.mmkv.MMKV;

/**
 * 作者:created by storm
 */

public final class KVUtilsJava {

    public static final String LOGIN_NAME_KEY = "login_name_key";

    public static final  String init(Context context) {
        return MMKV.initialize(context);
    }

    public static final String getString(String key, String defaultValue) {
        return MMKV.defaultMMKV().decodeString(key, defaultValue);
    }

    public static final void put(String key, String defaultValue) {
         MMKV.defaultMMKV().encode(key, defaultValue);
    }

    public static final void remove(String key){
        MMKV.defaultMMKV().remove(key);
    }

}
