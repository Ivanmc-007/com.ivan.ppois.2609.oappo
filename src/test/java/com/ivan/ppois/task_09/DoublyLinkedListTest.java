package com.ivan.ppois.task_09;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DoublyLinkedListTest {
    private DoublyLinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new DoublyLinkedList<>();
    }

    @Test
    void shouldReturnEmptyBracketStringWhenListIsEmpty() {
        // Arrange
        String expected = "[]";
        // Act
        String result = list.toString();
        // Assert
        assertEquals(expected, result);
    }

    @Test
    void shouldAddElementsToTheEndCorrectly() {
        // Arrange
        String expected = "[10, 20, 30]";
        // Act
        list.add(10);
        list.add(20);
        list.add(30);
        String result = list.toString();
        // Assert
        assertEquals(expected, result);
    }

    @Test
    void shouldReturnCorrectIndexWhenElementExists() {
        // Arrange
        list.add(10);
        list.add(20);
        list.add(30);
        int expectedIndex = 1;
        // Act
        int resultIndex = list.indexOf(20);
        // Assert
        assertEquals(expectedIndex, resultIndex);
    }

    @Test
    void shouldReturnMinusOneWhenElementDoesNotExist() {
        // Arrange
        list.add(10);
        list.add(20);
        int expectedIndex = -1;
        // Act
        int resultIndex = list.indexOf(99);
        // Assert
        assertEquals(expectedIndex, resultIndex);
    }

    @Test
    void shouldFindNullElementCorrectlyWhenListContainsNull() {
        // Arrange
        list.add(10);
        list.add(null);
        list.add(30);
        int expectedIndex = 1;
        // Act
        int resultIndex = list.indexOf(null);
        // Assert
        assertEquals(expectedIndex, resultIndex);
    }

    @Test
    void shouldThrowNoSuchElementExceptionWhenRemoveFirstIsCalledOnEmptyList() {
        // Arrange & Act & Assert
        assertThrows(NoSuchElementException.class, () -> list.removeFirst());
    }

    @Test
    void shouldClearListAndResetPointersWhenSingleElementIsRemoved() {
        // Arrange
        list.add(10);
        String expectedAfterRemove = "[]";
        String expectedAfterNewAdd = "[20]";
        // Act & Assert 1: Удаляем единственный элемент
        list.removeFirst();
        assertEquals(expectedAfterRemove, list.toString());
        // Act
        list.add(20);
        assertEquals(expectedAfterNewAdd, list.toString());
    }

    @Test
    void shouldRemoveOnlyFirstElementWhenListHasMultipleElements() {
        // Arrange
        list.add(10);
        list.add(20);
        list.add(30);
        String expected = "[20, 30]";
        // Act
        list.removeFirst();
        String result = list.toString();
        // Assert
        assertEquals(expected, result);
    }

    @Test
    void shouldThrowNoSuchElementExceptionWhenIteratorNextIsCalledBeyondBounds() {
        // Arrange
        list.add(10);
        Iterator<Integer> iterator = list.iterator();
        iterator.next(); // Извлекаем единственный элемент
        // Act & Assert
        assertThrows(NoSuchElementException.class, iterator::next);
    }
}
