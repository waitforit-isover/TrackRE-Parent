package com.sevenre.trackre.parent.utils;

import com.sevenre.trackre.parent.datatypes.ServerResult;

public class Server {


    public static ServerResult isAuthenticUser(String id, String password) {
        ServerResult result = new ServerResult();
        result.setIsAuthentic(true);
        return result;
    }

    public static String isAuthenticSchool (String schoolCode) {
        return "d";
    }

}
