package com.anudip.lms.security;

public final class Session {
    private static boolean isLoggedIn = false;
    private static String UserAgent; 
    private static String sessionId; 

    public static boolean isLoggedIn() {
        return isLoggedIn;
    }

    public static void setLoggedIn(boolean isLoggedIn) {
        Session.isLoggedIn = isLoggedIn;
    }

    public static String getUserAgent() {
        return UserAgent;
    }

    public static void setUserAgent(String userAgent) {
        UserAgent = userAgent;
    }

    public static String getSessionId() {
        return sessionId;
    }

    public static void setSessionId(String sessionId) {
        Session.sessionId = sessionId;
    }
}
