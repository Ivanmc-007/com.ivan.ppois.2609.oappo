package com.ivan.ppois.task_09;

public class Task01 {

    public static void removeNumbersWithFiveAtEnd(SimpleList<Integer> list) {
        list.removeIf(integer -> (integer % 5 == 0) && (integer % 10 != 0));
    }
}
