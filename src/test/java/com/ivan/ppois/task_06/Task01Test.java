package com.ivan.ppois.task_06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task01Test {

    @Test
    void shouldReturnSameStringWhenLengthIsLessThanTen() { // Должен вернуть строку без изменений, если длина меньше 10
        // Arrange
        String input = "Java123"; // Длина 7
        String expected = "Java123";
        // Act
        String result = Task01.changeStringIfMoreThanTen(input);
        // Assert
        assertEquals(expected, result);
    }

    @Test
    void shouldRemoveDigitsWhenLengthIsMoreThanTen() { // Должен удалить все цифры, если длина строки больше 10
        // Arrange
        String input = "Hello123World456"; // Длина 16
        String expected = "HelloWorld";
        // Act
        String result = Task01.changeStringIfMoreThanTen(input);
        // Assert
        assertEquals(expected, result);
    }

    @Test
    void shouldPrintConsolePrintConsoleChangesString() {
        Task01.printConsoleChangesString();
    }
}
