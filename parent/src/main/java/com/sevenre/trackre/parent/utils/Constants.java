package com.sevenre.trackre.parent.utils;

public class Constants {

    //Bundle
    public static String ISAUTHENTIC = "com.sevenre.trackre.parent.isauthentic";
    public static String SCHOOLID = "com.sevenre.trackre.parent.schoolID";

    //Error
    public static enum ERROR {Incorect_school_id, Error};

    //Login
    public static enum LOGIN {Successful, Wrong_password, No_network, No_user, Wrong_school_code}

    //Shared Preference
    public static String PREFERENCE = "com.sevenre.trackre.parentre.pref";
    public static enum PREF {SCHOOL_ID, PARENT_MOBILE_NO}
}
