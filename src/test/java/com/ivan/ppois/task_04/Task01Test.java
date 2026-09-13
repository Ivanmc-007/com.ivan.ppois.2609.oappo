package com.ivan.ppois.task_04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task01Test {

    // Допустимая погрешность для сравнения чисел с плавающей точкой (double)
    private static final double DELTA = 0.0001;

    @Test
    void shouldCalculateAvgWhenResultIsDouble() { // Должен вычислить среднее, если результат — дробное число
        // Arrange
        int[] arr = {1, 2, 4}; // Сумма = 7, Длина = 3
        double expected = 7.0 / 3.0; // ~2.333
        // Act
        double result = Task01.calculateAvgArrayData(arr);
        // Assert
        assertEquals(expected, result, DELTA);
    }

    @Test
    void shouldReturnNaNWhenArrayIsEmpty() { // Должен выбросить ошибку, если массив пустой
        // Arrange
        int[] arr = {};
        // Act
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> Task01.calculateAvgArrayData(arr));
        // Assert
        assertTrue(exception.getMessage().contains("Массив не должен быть пустым или null"));
    }

    @Test
    void shouldCalculateAvgArrayDataAndPrintConsole() {
        Task01.printConsoleAvgArrayData();
    }
}
