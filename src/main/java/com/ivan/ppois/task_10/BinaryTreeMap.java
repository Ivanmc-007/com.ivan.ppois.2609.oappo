package com.ivan.ppois.task_10;

import java.util.Set;
import java.util.TreeSet;

public class BinaryTreeMap<K extends Comparable<K>, V> {

    private Item<K, V> root;

    private V removedValue;

    private static class Item<K, V> {
        K key;
        V value;
        Item<K, V> left;
        Item<K, V> right;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Ключ не может быть null");
        }
        if (root == null) {
            root = new Item<>(key, value);
        } else {
            Item<K, V> newItem = new Item<>(key, value);
            addItemInTree(root, newItem);
        }
    }

    private void addItemInTree(Item<K, V> root, Item<K, V> newItem) {
        if (root.key.compareTo(newItem.key) < 0) {
            if (root.right == null) {
                root.right = newItem;
            } else {
                addItemInTree(root.right, newItem);
            }
        } else if (root.key.compareTo(newItem.key) > 0) {
            if (root.left == null) {
                root.left = newItem;
            } else {
                addItemInTree(root.left, newItem);
            }
        } else {
            root.value = newItem.value;
        }
    }

    public V get(K key) {
        if (root == null) {
            return null;
        }
        return findItemInTree(root, key);
    }

    private V findItemInTree(Item<K, V> root, K key) {
        int compareTo = root.key.compareTo(key);
        if (compareTo < 0) {
            if (root.right != null) {
                return findItemInTree(root.right, key);
            }
        } else if (compareTo > 0) {
            if (root.left != null) {
                return findItemInTree(root.left, key);
            }
        } else {
            return root.value;
        }
        return null;
    }

    public V remove(K key) {
        if (root == null || key == null) {
            return null;
        }
        removedValue = null;
        root = removeItem(root, key);
        return removedValue;
    }

    private Item<K, V> removeItem(Item<K, V> current, K key) {
        if (current == null) {
            return null; // Элемент не найден
        }

        int cmp = key.compareTo(current.key);

        if (cmp < 0) {
            // Ищем в левом поддереве
            current.left = removeItem(current.left, key);
        } else if (cmp > 0) {
            // Ищем в правом поддереве
            current.right = removeItem(current.right, key);
        } else {
            // Ключ найден!
            removedValue = current.value;

            // Случай 1: у узла нет детей или только один ребенок
            if (current.left == null) {
                return current.right;
            }
            if (current.right == null) {
                return current.left;
            }

            // Случай 2: у узла два ребенка
            // Находим минимальный элемент в правом поддереве
            Item<K, V> successor = findNearestBiggerItem(current.right);
            // Копируем его данные
            current.key = successor.key;
            current.value = successor.value;
            // Удаляем преемника из правого поддерева
            current.right = removeItem(current.right, successor.key);
        }
        return current;
    }

    private Item<K, V> findNearestBiggerItem(Item<K, V> root) {
        if (root.left == null)
            return root;
        return findNearestBiggerItem(root.left);
    }

    public Set<K> keySet() {
        Set<K> result = new TreeSet<>();
        if (root != null) {
            keySet(root, result);
        }
        return result;
    }

    private void keySet(Item<K, V> root, Set<K> set) {
        if (root.left != null) {
            keySet(root.left, set);
        }
        set.add(root.key);
        if (root.right != null) {
            keySet(root.right, set);
        }
    }

    public BinaryTreeMap<Integer, Integer> countRootsOnEachLevel() {
        BinaryTreeMap<Integer, Integer> result = new BinaryTreeMap<>();
        countRootsOnEachLevel(result, root, 1);
        return result;
    }

    private void countRootsOnEachLevel(BinaryTreeMap<Integer, Integer> result, Item<K, V> root, int level) {
        if (root == null) {
            return;
        }
        Integer existingLevel = result.get(level);
        if (existingLevel == null) {
            result.put(level, 1);
        } else {
            result.put(level, existingLevel + 1);
        }
        countRootsOnEachLevel(result, root.left, level + 1);
        countRootsOnEachLevel(result, root.right, level + 1);
    }
}
