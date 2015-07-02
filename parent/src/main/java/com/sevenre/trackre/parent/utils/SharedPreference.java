package com.sevenre.trackre.parent.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreference {

    public static void setParentMobileNo (Context context, String mobile) {
        SharedPreferences pref = context.getSharedPreferences(Constants.PREFERENCE, 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(Constants.PREF.PARENT_MOBILE_NO.name(), mobile);
        editor.commit();
    }

    public static String getParentMobileNo(Context context) {
        SharedPreferences pref = context.getSharedPreferences(Constants.PREFERENCE, 0);
        return pref.getString(Constants.PREF.PARENT_MOBILE_NO.name(),  Constants.ERROR.Error.name());
    }


}
