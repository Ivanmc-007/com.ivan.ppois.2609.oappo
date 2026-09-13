package com.ivan.ppois.task_02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task04Test {
    // Погрешность для сравнения чисел с плавающей точкой
    private static final double DELTA = 0.0001;

    @Test
    public void shouldCalculateCorrectlyR() {
        // Act
        double result1 = Task04.calculateR(10, 20, 15);
        double result2 = Task04.calculateR(5, 8, 2);
        double result3 = Task04.calculateR(-6, -3, -9);
        // Assert
        assertEquals(result1, 5.0, DELTA);
        assertEquals(result2, 1.6666, DELTA);
        assertEquals(result3, -2.0, DELTA);
    }
}
