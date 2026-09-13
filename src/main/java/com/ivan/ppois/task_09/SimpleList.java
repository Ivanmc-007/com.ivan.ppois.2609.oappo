package com.ivan.ppois.task_09;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class SimpleList<T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> last;

    public SimpleList() {
    }

    private static class Node<T> {
        T val;
        Node<T> next;
        Node(T val) {
            this.val = val;
        }
    }

    private boolean isInitiated() {
        return this.head != null;
    }

    private void initiate(T value) {
        this.head = new Node<>(value);
        this.head.next = null;
        this.last = this.head;
    }

    public void add(T value) {
        if (isInitiated()) {
            this.last.next = new Node<>(value);
            this.last = this.last.next;
        } else {
            initiate(value);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> localHead = head;
            private Node<T> lastReturned = null;
            private Node<T> prev = null; // Узел перед lastReturned
            @Override
            public boolean hasNext() {
                return localHead != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("В списке больше нет элементов");
                }
                // если lastReturned уже был
                if (lastReturned != null) {
                    prev = lastReturned;
                }

                T val = localHead.val;
                lastReturned = localHead;
                localHead = localHead.next;
                return val;
            }

            @Override
            public void remove() {
                if (lastReturned == null) {
                    throw new IllegalStateException("Нельзя вызвать метод без вызова next()");
                }
                Node<T> lastNext = lastReturned.next;
                if (prev == null) {
                    // Удаление из начала списка
                    head = lastNext;
                } else {
                    // Удаление из середины списка
                    prev.next = lastNext;
                }
                // Удаление из конца
                if (lastNext == null)
                    last = prev;

                lastReturned = null;
                if (this.localHead == null && prev == null) {
                    head = null;
                }
            }
        };
    }

    @Override
    public String toString() {
        if (!isInitiated()) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Iterator<T> iterator = this.iterator();
        if (iterator.hasNext()) {
            while (iterator.hasNext()) {
                T val = iterator.next();
                sb.append(val);
                sb.append(',').append(' ');
            }
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(']');
        return sb.toString();
    }

    public void removeIf(Predicate<T> filter) {
        final Iterator<T> iterator = this.iterator();
        while (iterator.hasNext()) {
            T val = iterator.next();
            if (filter.test(val)) {
                iterator.remove();
            }
        }
    }
}
