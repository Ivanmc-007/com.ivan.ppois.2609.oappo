package com.ivan.ppois.task_09;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SimpleListTest {

    private SimpleList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new SimpleList<>();
    }

    @Test
    void shouldAddElementsCorrectly() {
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
    void shouldRemoveMiddleElementsConsecutivelyWithoutLosingData() {
        // Arrange
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        String expectedBeforeAdd = "[10, 40]";
        String expectedAfterAdd = "[10, 40, 50]";
        // Act & Assert 1: Удаляем 20 и 30 подряд из середины
        list.removeIf(x -> x == 20 || x == 30);
        assertEquals(expectedBeforeAdd, list.toString());
        // Act & Assert 2: Проверяем, что элемент добавлен в конец
        list.add(50);
        assertEquals(expectedAfterAdd, list.toString());
    }

    @Test
    void shouldUpdateLastPointerWhenLastElementsAreRemoved() {
        // Arrange
        list.add(10);
        list.add(20);
        list.add(30);
        String expectedBeforeAdd = "[10]";
        String expectedAfterAdd = "[10, 40]";
        // Act & Assert 1: Удаляем хвостовые элементы
        list.removeIf(x -> x == 20 || x == 30);
        assertEquals(expectedBeforeAdd, list.toString());
        // Act & Assert 2: Проверяем, что новые элементы добавляются в конец
        list.add(40);
        assertEquals(expectedAfterAdd, list.toString());
    }

    @Test
    void shouldAllowAddingNewElementsAfterFullClear() {
        // Arrange
        list.add(10);
        list.add(20);
        list.add(30);
        String expectedAfterClear = "[]";
        String expectedAfterReadd = "[40]";
        // Act & Assert 1: Полностью очищаем список
        list.removeIf(x -> true);
        assertEquals(expectedAfterClear, list.toString());
        // Act & Assert 2: Проверяем, что список успешно восстанавливается из пустого состояния
        assertDoesNotThrow(() -> list.add(40));
        assertEquals(expectedAfterReadd, list.toString());
    }

    @Test
    void shouldThrowIllegalStateExceptionWhenRemoveIsCalledBeforeNext() {
        // Arrange
        list.add(10);
        Iterator<Integer> iterator = list.iterator();
        // Act & Assert
        assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    void shouldThrowNoSuchElementExceptionWhenNextIsCalledOnEmptyIterator() {
        // Arrange
        list.add(10);
        Iterator<Integer> iterator = list.iterator();
        iterator.next(); // Извлекаем единственный элемент
        // Act & Assert
        assertThrows(NoSuchElementException.class, iterator::next);
    }
}
