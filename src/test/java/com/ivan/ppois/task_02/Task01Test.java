package com.ivan.ppois.task_02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task01Test {

    // Допустимая погрешность для сравнения чисел с плавающей точкой (double)
    private static final double DELTA = 0.0001;

    @Test
    void shouldCalculateZ1CorrectlyWhenAlphaIsZero() {
        // Arrange
        // Угол 0 градусов:
        // sin(0) = 0, cos(0) = 1
        // z1 = 1 - 0.25 * 0^2 + 1 = 2.0
        double alpha = 0.0;
        double expected = 2.0;
        // Act
        double result = Task01.calculateZ1(alpha);
        // Assert
        assertEquals(expected, result, DELTA);
    }

    @Test
    void shouldCalculateZ1CorrectlyWhenAlphaIs45Degrees() {
        // Arrange
        // Угол 45 градусов: 2 * alpha = 90 градусов
        // sin(90) = 1, cos(90) = 0
        // z1 = 1 - 0.25 * 1^2 + 0 = 0.75
        double alpha = 45.0;
        double expected = 0.75;
        // Act
        double result = Task01.calculateZ1(alpha);
        // Assert
        assertEquals(expected, result, DELTA);
    }

    @Test
    void shouldCalculateZ2CorrectlyWhenAlphaIsZero() {
        // Arrange
        // Угол 0 градусов:
        // cos(0) = 1
        // z2 = 1^2 + 1^4 = 2.0
        double alpha = 0.0;
        double expected = 2.0;
        // Act
        double result = Task01.calculateZ2(alpha);
        // Assert
        assertEquals(expected, result, DELTA);
    }

    @Test
    void shouldCalculateZ2CorrectlyWhenAlphaIs90Degrees() {
        // Arrange
        // Угол 90 градусов:
        // cos(90) = 0
        // z2 = 0^2 + 0^4 = 0.0
        double alpha = 90.0;
        double expected = 0.0;
        // Act
        double result = Task01.calculateZ2(alpha);
        // Assert
        // Из-за специфики Math.toRadians(90) косинус вернет не ровно 0,
        // а супер-маленькое число (например, 6.12e-17). DELTA это сгладит.
        assertEquals(expected, result, DELTA);
    }

    @Test
    void z1AndZ2ShouldBeEqualForArbitraryAngle() {
        // Arrange
        // Математически эти формулы тождественны при любых углах (кроме точек неопределенности).
        // Проверим, совпадают ли результаты для угла 30 градусов.
        double alpha = 30.0;
        // Act
        double resultZ1 = Task01.calculateZ1(alpha);
        double resultZ2 = Task01.calculateZ2(alpha);
        // Assert
        assertEquals(resultZ1, resultZ2, DELTA);
    }
}
