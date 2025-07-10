package algorithms;

import java.util.*;

public class BreadthFirstSearchMango {
    static Map<String, List<String>> map = new HashMap<>();

    public static void main(String[] args) {
        map.put("you", List.of("Bob", "John", "Alice"));
        map.put("Bob", List.of("John", "Franko", "Tom", "Ferre"));
        map.put("Alice", List.of("Vzgo", "you", "Tom"));
        System.out.println("Breadth First Search: " + isThereMangoSeller("Vzgo"));
        System.out.println("Breadth First Search: " + isThereMangoSeller("Robert"));
    }

    private static boolean isThereMangoSeller(String sellerName) {
        var deque = new ArrayDeque<List<String>>();
        var checkedPersons = new ArrayList<>();
        deque.add(map.get("you"));
        while (!deque.isEmpty()) {
            var list = deque.pollFirst();
            for (var item : list) {
                if (!checkedPersons.contains(item)){
                    if (item.equals(sellerName)) {
                        return true;
                    }
                    var friendsList = map.get(item);
                    if (friendsList != null) {
                        deque.add(map.get(item));
                    }
                    checkedPersons.add(item);
                }
            }
        }
        return false;
    }
}
