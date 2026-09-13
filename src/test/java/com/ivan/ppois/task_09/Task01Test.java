package com.ivan.ppois.task_09;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class Task01Test {

    @Test
    void shouldCorrectlyRemoveElements() {
        // Arrange
        Random random = new Random();
        SimpleList<Integer> list = new SimpleList<>();
        // interval [0, 50]
        for (int i = 0, count = 51; i < count; i++) {
            list.add(random.nextInt(count));
        }
        // Act
        Task01.removeNumbersWithFiveAtEnd(list);
        // Assert
        for (Integer item : list) {
            // не оканчивается на 5
            assertFalse((item % 5 == 0) && (item % 10 != 0));
        }
    }
}
