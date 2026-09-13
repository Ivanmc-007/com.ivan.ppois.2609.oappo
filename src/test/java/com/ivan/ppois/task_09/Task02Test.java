package com.ivan.ppois.task_09;

import org.junit.jupiter.api.Test;

public class Task02Test {

    @Test
    public void shouldPrintConsoleRemoveAllElementsBeforeMax() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(10);
        list.add(8);
        list.add(10);
        list.add(6);
        list.add(4);
        System.out.println("List before removing elements: " + list);
        Task02.removeAllElementsBeforeMax(list);
        System.out.println("List after removing elements: " + list);
    }
}
