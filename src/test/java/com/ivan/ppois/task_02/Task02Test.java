package com.ivan.ppois.task_02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task02Test {

    @Test
    void shouldCalculateAlphaCorrectlyForControlValues() {
        // Arrange
        double check = -182.036;
        double x = -15.246;
        double y = 4.642 * Math.pow(10, -2);
        double z = 20.001 * Math.pow(10, 2);
        // Act
        double result = Task02.calculateAlpha(x, y, z);
        // Assert
        // Проверяем с точностью до 3 знаков после запятой (0.001)
        assertEquals(check, result, 0.001);
    }
}
