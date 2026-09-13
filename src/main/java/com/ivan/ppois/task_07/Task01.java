package com.ivan.ppois.task_07;

import java.util.Map;

public class Task01 {

    private final static Map<String, String> cipher = Map.of(
            "ле", "ю",
            "са", "щ",
            "ик", "ж"
            );

    public static String encryptString(String str) {
        if (str == null || str.length() <= 1)
            return str;
        StringBuilder sb = new StringBuilder();
        int prev = 0;
        for (int curr = 1; curr < str.length(); curr++, prev++) {
            String pair =  str.charAt(prev) + "" + str.charAt(curr);
            if (cipher.containsKey(pair)) {
                sb.append(cipher.get(pair));
                // перейти к следующей паре
                curr++;
                prev++;
            } else if (curr != str.length() - 1) {
                // если не последний
                sb.append(str.charAt(prev));
            } else {
                sb.append(str.charAt(prev));
                sb.append(str.charAt(curr));
            }
        }
        return sb.toString();
    }
}
