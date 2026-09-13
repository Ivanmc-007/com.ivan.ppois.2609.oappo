package com.ivan.ppois.task_09;

import java.util.Iterator;

public class Task02 {

    public static void removeAllElementsBeforeMax(DoublyLinkedList<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        // find max
        Integer max = null;
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (max == null || element > max) {
                max = element;
            }
        }
        // find first index of max element
        int index = list.indexOf(max);
        int count = 0;
        if (index != -1) {
            // remove all elements before max
            while (count < index) {
                list.removeFirst();
                count++;
            }
        }
    }
}
