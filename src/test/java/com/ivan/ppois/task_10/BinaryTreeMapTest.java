package com.ivan.ppois.task_10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BinaryTreeMapTest {

    private BinaryTreeMap<Integer, String> map;

    @BeforeEach
    void setUp() {
        map = new BinaryTreeMap<>();
    }

    @Test
    void shouldAddElementsCorrectly() {
        // Arrange
        Set<Integer> expectedKeys = Set.of(5, 10, 15);
        // Act
        map.put(10, "Десять");
        map.put(5, "Пять");
        map.put(15, "Пятнадцать");
        Set<Integer> resultKeys = map.keySet();
        // Assert
        assertEquals(expectedKeys, resultKeys);
        assertEquals("Десять", map.get(10));
    }

    @Test
    void shouldUpdateValueWhenKeyAlreadyExists() {
        // Arrange
        map.put(10, "Старое значение");
        String expectedValue = "Новое значение";
        // Act
        map.put(10, "Новое значение");
        String resultValue = map.get(10);
        // Assert
        assertEquals(expectedValue, resultValue);
    }

    @Test
    void shouldThrowExceptionWhenPutNullKey() {
        // Arrange & Act & Assert
        assertThrows(IllegalArgumentException.class, () -> map.put(null, "Value"));
    }

    @Test
    void shouldGetElementsCorrectly() {
        // Arrange
        map.put(10, "Java");
        String expected = "Java";
        // Act
        String result = map.get(10);
        // Assert
        assertEquals(expected, result);
    }

    @Test
    void shouldRemoveLeafElementCorrectly() {
        // Arrange - элемент 5 является листом (нет детей)
        map.put(10, "Корень");
        map.put(5, "Лист");
        String expectedDeletedValue = "Лист";
        // Act
        String deletedValue = map.remove(5);
        String getValueAfterRemove = map.get(5);
        // Assert
        assertEquals(expectedDeletedValue, deletedValue);
        assertNull(getValueAfterRemove);
    }

    @Test
    void shouldRemoveElementWithOneChildCorrectly() {
        // Arrange - у элемента 5 будет один ребенок (3)
        map.put(10, "Корень");
        map.put(5, "Узел");
        map.put(3, "Ребенок");
        String expectedDeletedValue = "Узел";
        // Act
        String deletedValue = map.remove(5);
        // Assert
        assertEquals(expectedDeletedValue, deletedValue);
        assertNull(map.get(5));
        assertEquals("Ребенок", map.get(3)); // Проверяем, что связь не оборвалась
    }

    @Test
    void shouldCountNodesOnEachLevelCorrectlyInBalancedTree() {
        /*
         * Пример дерева:
         *             10 (Level 1)
         *            /  \
         * (Level 2) 5   15 (Level 2)
         *                /  \
         *     (Level 3) 12  17 (Level 3)
         */
        BinaryTreeMap<Integer, String> tree = new BinaryTreeMap<>();
        tree.put(10, "Root");
        tree.put(5, "Left child");
        tree.put(15, "Right child");
        tree.put(12, "Right-Left child");
        tree.put(17, "Right-Right child");
        // Ожидаемый результат: на 1 уровне - 1 узел, на 2 уровне - 2 узла, на 3 уровне - 2 узла.
        int expectedLevel1Count = 1;
        int expectedLevel2Count = 2;
        int expectedLevel3Count = 2;
        // Act
        BinaryTreeMap<Integer, Integer> result = tree.countRootsOnEachLevel();
        // Assert
        assertEquals(expectedLevel1Count, result.get(1));
        assertEquals(expectedLevel2Count, result.get(2));
        assertEquals(expectedLevel3Count, result.get(3));
        assertNull(result.get(4)); // 4-го уровня в дереве нет
    }
}
