package com.ivan.ppois.task_05;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Task02 {

    @SuppressWarnings("ForLoopReplaceableByForEach")
    public static Set<Integer> findColumnsWithoutNegativeNumbers(int[][] arr) {
        if (arr == null) return null;
        Set<Integer> allColumns = new HashSet<>();
        Set<Integer> exceptionColumns = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                allColumns.add(j);
                if (arr[i][j] < 0) {
                    exceptionColumns.add(j);
                }
            }
        }
        // удалить колонки, которые попали в исключения
        for (Integer exceptionColumn : exceptionColumns) {
            allColumns.remove(exceptionColumn);
        }
        return allColumns;
    }

    @SuppressWarnings("ForLoopReplaceableByForEach")
    public static Map<Integer, Integer> findSumForPositiveColumns(int[][] arr, Set<Integer> positiveColumns) {
        if (arr == null || positiveColumns == null) return null;
        // column : sum
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (positiveColumns.contains(j)) {
                    Integer prevColumnSum = result.getOrDefault(j, 0);
                    prevColumnSum += arr[i][j];
                    result.put(j, prevColumnSum);
                }
            }
        }
        return result;
    }

    public static void printConsoleSumForPositiveColumns() {
        int [][] arr = {
                {-1, 2, 3, 4},
                {5, 6, -7, 8},
                {9, 10, 11, 12}
        };
        Set<Integer> positiveColumns = findColumnsWithoutNegativeNumbers(arr);
        Map<Integer, Integer> sumForPositiveColumns = findSumForPositiveColumns(arr, positiveColumns);
        printArray(arr);
        if (sumForPositiveColumns != null) {
            sumForPositiveColumns.forEach((k, v) -> System.out.println("column: " + k + ", columnSum: " + v));
        }
    }

    @SuppressWarnings("ForLoopReplaceableByForEach")
    private static void printArray(int[][] arr) {
        if (arr == null) {
            System.out.println("Array is null");
            return;
        }
        System.out.println("Array data: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%4d ", arr[i][j]);
            }
            System.out.println();
        }
    }
}
