package com.ivan.ppois.task_06;

public class Task01 {

    public static String changeStringIfMoreThanTen(String input) {
        if (input == null || input.length() <= 10) {
            return input;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (!('0' <= ch && ch <= '9')) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void printConsoleChangesString() {
        String input = "1I 2am 3the 4king 5of 6the 7world";
        System.out.println("String before: " + input);
        String output = changeStringIfMoreThanTen(input);
        System.out.println("String after: " + output);
    }
}
