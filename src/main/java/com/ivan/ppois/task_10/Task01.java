package com.ivan.ppois.task_10;

import java.util.Set;

public class Task01 {

    public static void demonstration() {
        // 1. Creating tree
        // clientId : clientInfo
        BinaryTreeMap<Integer, String> clientMap = new BinaryTreeMap<>();
        // 2. Adding new record
        clientMap.put(10, "John Jonathan, +447700900077, G3910582");
        clientMap.put(6, "Maria Smith, +4915123456789, 59281048");
        clientMap.put(5, "Olivia Bennett, +33612345678, E2910583A");
        clientMap.put(1, "Emma Fitzgerald, +79991234567, MP4829105");
        clientMap.put(27, "Sophia Caldwell, +375295555555, TR9834102");
        clientMap.put(12, "Oliver Vance, +15550194561, 12AA34567");
        clientMap.put(29, "Lucas Hawthorne, +8613912345678, 948201948");
        clientMap.put(30, "Isabella Montgomery, +819012345678, 7521893451");
        // 3. Searching info by key
        String searchedClient = clientMap.get(12);
        String[] rowSearch = searchedClient.split(", ");
        // 4. Removing clientInfo
        String removedClient = clientMap.remove(27);
        String[] rowRemove = removedClient.split(", ");
        // 5. Print in console
        System.out.println("Search result: ");
        System.out.printf("%s | %s | %s%n", rowSearch[0], rowSearch[1], rowSearch[2]);
        System.out.println();
        System.out.println("Removed client's information: ");
        System.out.printf("%s | %s | %s%n", rowRemove[0], rowRemove[1], rowRemove[2]);
        // 6. Calculate node's number on each level
        BinaryTreeMap<Integer, Integer> countRootMap = clientMap.countRootsOnEachLevel();
        Set<Integer> result = countRootMap.keySet();
        System.out.println();
        System.out.println("Node's number on each level: ");
        System.out.printf("%-12s | %-10s\n", "Node level", "Node count");
        System.out.println("-----------------------------");
        for (Integer key : result) {
            System.out.printf("%-12d | %-10d\n", key, countRootMap.get(key));
        }
    }
}
