package com.ivan.ppois.task_04;

import java.util.Arrays;

public class Task01 {

    public static double calculateAvgArrayData(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Массив не должен быть пустым или null");
        }
        int sum = 0;
        for (int item : arr) {
            sum += item;
        }
        return (double) sum / arr.length;
    }

    public static void printConsoleAvgArrayData() {
        int[] arr1 = {1, 2, 5, 3, 65, 2, 6, 99};
        int[] arr2 = {2, -55, 7, 3, 2, 7, 8, -17, 434};
        double res1 = calculateAvgArrayData(arr1);
        double res2 = calculateAvgArrayData(arr2);
        System.out.println("array1: " + Arrays.toString(arr1));
        System.out.println("array2: " + Arrays.toString(arr2));
        System.out.printf("The average array1 data is: %12.3f%n", res1);
        System.out.printf("The average array2 data is: %12.3f%n", res2);
    }
}
