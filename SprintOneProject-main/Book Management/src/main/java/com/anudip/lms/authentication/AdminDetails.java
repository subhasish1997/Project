package com.anudip.lms.authentication;

import java.util.HashMap;

public final class AdminDetails {
     
        private static final HashMap<String, String> admins = new HashMap<>();

        static 
        {
                admins.put("pijush","pijush@16");
                admins.put("debu","876debu#");
                admins.put("farhan","@farhan45");
                admins.put("suvo","@suvodas8");
                admins.put("humpty","humpty@123");
        }
        static String getPasswordHash(String username) {
                return admins.get(username);
        }
        
        public static boolean hasAdmin(String username) {
                return admins.containsKey(username);
        }

        public static HashMap<String, String> getAdmins() {
                return admins;
        }

}
