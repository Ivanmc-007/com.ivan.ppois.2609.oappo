package com.ivan.ppois.task_02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task03Test {

    // Погрешность для сравнения чисел с плавающей точкой
    private static final double DELTA = 0.0001;

    @Test
    void shouldCalculateCorrectlyWhenZIsLessThanMinusOne() {
        // Arrange
        // Ветка if: z = -3.0 (меньше -1)
        // x = -(-3.0) / 3 = 1.0
        // y = ln(1.5) + (e^1 - e^-1) ≈ 0.40546 + 2.35040 = 2.75586
        double z = -3.0;
        double expected = 2.75586;
        // Act
        double result = Task03.calculateY(z);
        // Assert
        assertEquals(expected, result, DELTA);
    }

    @Test
    void shouldCalculateCorrectlyWhenZIsGreaterThanMinusOne() {
        // Arrange
        // Ветка else: z = 0.0 (больше -1)
        // x = |0.0| = 0.0
        // y = ln(0.5) + (e^0 - e^0) = ln(0.5) + 0 ≈ -0.69314
        double z = 0.0;
        double expected = -0.69314;
        // Act
        double result = Task03.calculateY(z);
        // Assert
        assertEquals(expected, result, DELTA);
    }

    @Test
    void shouldCalculateCorrectlyAtBoundaryValue() {
        // Arrange
        // Граница: z = -1.0 (попадает в ветку else, так как -1 не меньше -1)
        // x = |-1.0| = 1.0
        // Результат должен быть таким же, как в первом тесте, где x тоже равен 1.0
        double z = -1.0;
        double expected = 2.75586;
        // Act
        double result = Task03.calculateY(z);
        // Assert
        assertEquals(expected, result, DELTA);
    }
}
