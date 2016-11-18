package com.mdzz.mdzz1st.util;


import android.support.compat.BuildConfig;
import android.util.Log;

/**
 * Created by Raymond on 2016/11/17.
 */

public class DebugLog {
    public static void log(String string){
        if(BuildConfig.DEBUG)
        Log.e("MDZZString", string);
    }

}
