package com.ivan.ppois.task_02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task05Test {
    // Погрешность для сравнения чисел с плавающей точкой
    private static final double DELTA = 0.0001;

    @Test
    void shouldCalculateAtanWhenSumGreaterThanHalf() { // Вычислить арктангенс, если m^2 + t^2 > 0.5
        // Arrange
        double m = 1.0;
        double t = 1.0;
        double expected = Math.atan(5 * m * m * t + 7 * m * t * t);
        // Act
        double result = Task05.calculateT2(m, t);
        // Assert
        assertEquals(expected, result, DELTA);
    }

    @Test
    void shouldCalculateAsinWhenSumIsWithinRange() { // Должен вычислить арксинус, если 0.1 < m^2 + t^2 <= 0.5
        // Arrange
        double m = 0.4;
        double t = 0.2;
        double expected = Math.asin(5 * m * m * t + 7 * m * t * t);
        // Act
        double result = Task05.calculateT2(m, t);
        // Assert
        assertEquals(expected, result, DELTA);
    }

    @Test
    void shouldThrowExceptionWhenSumIsTooSmall() { // Должен выбросить IllegalArgumentException, если m^2 + t^2 <= 0.1
        // Arrange
        double m = 0.1;
        double t = 0.1;
        // Act
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> Task05.calculateT2(m, t));
        // Assert
        assertTrue(exception.getMessage().contains("must be greater than 0.1"));
    }
}
