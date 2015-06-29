package com.sevenre.trackre.parent.utils;

import android.os.Build;

public class Commons {

    public static boolean isVersionGreaterOrEqualToLollipop () {
        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentapiVersion >= Build.VERSION_CODES.LOLLIPOP){
            return true;
        } else{
            return false;
        }
    }

}
