package com.ivan.ppois.task_05;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Task01 {

    @SuppressWarnings("ForLoopReplaceableByForEach")
    public static Integer findMinElementValue(int[][] arr) {
        if (arr == null) return null;
        Integer min = null;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (min == null) {
                    min = Integer.MAX_VALUE;
                }
                if (arr[i][j] < min) {
                    min = arr[i][j];
                }
            }
        }
        return min;
    }

    public static List<Map.Entry<Integer, Integer>> findCoordinateList(int[][] arr, Integer value) {
        List<Map.Entry<Integer, Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == value) {
                    result.add(Map.entry(i, j));
                }
            }
        }
        return result;
    }

    public static void printCoordinateListMinValue() {
        int[][] array = {
                {1, 2, -18, 21},
                {-18, 5, 6, -18},
                {7, 8, -18, 23}};
        Integer min = findMinElementValue(array);
        if (min != null) {
            List<Map.Entry<Integer, Integer>> coordinateList = findCoordinateList(array, min);
            for (Map.Entry<Integer, Integer> entry : coordinateList) {
                System.out.printf("row: %d, column: %d%n", entry.getKey(), entry.getValue());
            }
        } else {
            System.out.println("No coordinates found");
        }
    }
}
