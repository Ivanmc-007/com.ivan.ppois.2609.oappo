package com.ivan.ppois.task_05;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Task02Test {

    @Test
    void shouldFindColumnsWithoutNegativeNumbers() { // Должен найти колонки без отрицательных чисел
        // Arrange
        // Колонки 1 и 3 не содержат минусов. Колонки 0 и 2 содержат (-1 и -7)
        int[][] array = {
                {-1, 2, 3, 4},
                {5, 6, -7, 8},
                {9, 10, 11, 12}
        };
        Set<Integer> expected = Set.of(1, 3);
        // Act
        Set<Integer> result = Task02.findColumnsWithoutNegativeNumbers(array);
        // Assert
        assertEquals(expected, result);
    }

    @Test
    @SuppressWarnings("ConstantConditions")
    void shouldReturnNullWhenMatrixIsNull() { // Должен вернуть null, если на вход передан null
        // Arrange
        int[][] array = null;
        // Act
        Set<Integer> result = Task02.findColumnsWithoutNegativeNumbers(array);
        // Assert
        assertNull(result);
    }

    @Test
    void shouldCalculateSumForSpecificColumns() { // Должен посчитать сумму только для выбранных колонок
        // Arrange
        int[][] array = {
                {-1, 2, 3, 4},
                {5, 6, -7, 8},
                {9, 10, 11, 12}
        };
        // Выбираем колонки 1 и 3
        Set<Integer> positiveColumns = Set.of(1, 3);
        // Колонка 1: 2 + 6 + 10 = 18
        // Колонка 3: 4 + 8 + 12 = 24
        Map<Integer, Integer> expected = Map.of(
                1, 18,
                3, 24);
        // Act
        Map<Integer, Integer> result = Task02.findSumForPositiveColumns(array, positiveColumns);
        // Assert
        assertEquals(expected, result);
    }

    @Test
    void shouldPrintConsoleSumForPositiveColumns() {
        Task02.printConsoleSumForPositiveColumns();
    }
}
