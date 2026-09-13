package com.ivan.ppois.task_05;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Task01Test {

    @Test
    void shouldReturnNullWhenArrayHasOnlyEmptyRows() { // Должен вернуть null, если в массиве только пустые строки
        // Arrange
        int[][] array = {
                {},
                {},
                {}
        };
        // Act
        Integer result = Task01.findMinElementValue(array);
        // Assert
        assertNull(result);
    }

    @Test
    @SuppressWarnings("ConstantConditions")
    void shouldReturnNullWhenArrayIsNull() { // Должен вернуть null, если на вход передан null
        // Arrange
        int[][] array = null;
        // Act
        Integer result = Task01.findMinElementValue(array);
        // Assert
        assertNull(result);
    }

    @Test
    void shouldFindMinWithNegativeNumbers() { // Должен корректно находить минимум, если есть отрицательные числа
        // Arrange
        int[][] array = {
                {10, -5, 4},
                {-12, 0, 8},
                {3, -1, -7}
        };
        Integer expected = -12;
        // Act
        Integer result = Task01.findMinElementValue(array);
        // Assert
        assertEquals(expected, result);
    }

    @Test
    void shouldFindMultipleCoordinates() { // Должен найти все координаты, если элемент повторяется несколько раз
        // Arrange
        int[][] array = {
                {7, 8, 7},
                {9, 7, 14},
                {7, 11, 6}
        };
        int valueToFind = 7; // Находится на позициях (0,0), (0,2), (1,1), (2,0)
        // Act
        List<Map.Entry<Integer, Integer>> result = Task01.findCoordinateList(array, valueToFind);
        // Assert
        assertEquals(4, result.size());
        assertEquals(Map.entry(0, 0), result.get(0));
        assertEquals(Map.entry(0, 2), result.get(1));
        assertEquals(Map.entry(1, 1), result.get(2));
        assertEquals(Map.entry(2, 0), result.get(3));
    }

    @Test
    void shouldPrintCoordinateListMinValue() {
        Task01.printCoordinateListMinValue();
    }
}
