package com.ivan.ppois.task_09;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements Iterable<T> {

    private DoublyNode<T> first;
    private DoublyNode<T> last;

    private static class DoublyNode<T> {
        T value;
        DoublyNode<T> next;
        DoublyNode<T> prev;

        public DoublyNode(DoublyNode<T> next, T value, DoublyNode<T> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public void add(T value) {
        this.addLast(value);
    }

    public void addLast(T value) {
        if (last == null) {
            DoublyNode<T> newNode = new DoublyNode<>(null, value, null);
            first = newNode;
            last = newNode;
        } else {
            DoublyNode<T> newNode = new DoublyNode<>(null, value, null);
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            DoublyNode<T> localFirst = first;

            @Override
            public boolean hasNext() {
                return localFirst != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = localFirst.value;
                localFirst = localFirst.next;
                return value;
            }
        };
    }

    @Override
    public String toString() {
        if (first == null) {
            return "[]";
        }
        Iterator<T> iterator = this.iterator();
        StringBuilder sb = new StringBuilder();
        sb.append('[');
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

    public int indexOf(Object val) {
        int index = 0;
        if (val == null) {
            for (T t : this) {
                if (t == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (T t : this) {
                if (t.equals(val)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    public void removeFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        DoublyNode<T> firstNext = first.next;
        first = firstNext;
        if (firstNext != null) {
            firstNext.prev = null;
        }
        if (first == null) {
            last = null;
        }
    }
}
