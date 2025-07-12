package algorithms;

import java.util.*;

public class Dexter {
    final static Map map = new HashMap<String, Map<String, Integer>>();
    final static Map costs = new HashMap<String, Integer>();
    final static List processed = new ArrayList();
    final static List neighbors = new ArrayList();

    public static void main(String[] args) {
        map.put("start", Map.of("A", 6, "B", 2));
        map.put("A", Map.of("end", 1));
        map.put("B", Map.of("A", 3, "end", 5));
        costs.put("start", 0);
        costs.put("A", 6);
        costs.put("B", 2);
        costs.put("end", Integer.MAX_VALUE);
        Optional<String> findNode = findSmallCostNode("start");
        while (findNode.isPresent()) {
            final var node = findNode.get();
            System.out.println(node);
            final int cost = (int) costs.get(node);
            final var neighbors = (Map) map.get(node);
            if (neighbors != null) {
                for (var key : neighbors.keySet()) {
                    int newCost = cost + (int) neighbors.get(key);
                    if ((int) costs.get(key) > newCost) {
                        costs.put(key, newCost);
                    }
                }
            }
            processed.add(node);
            findNode = findSmallCostNode(node);
            System.out.println(findNode);
        }
        System.out.println(costs);
    }

    private static Optional<String> findSmallCostNode(String key) {
        System.out.println("Start check small node: " + key);
        String minNode = null;
        int minValue = Integer.MAX_VALUE;
        if (map.containsKey(key)) {
            final var node = (Map) map.get(key);
            System.out.println(node);
            for (var nodeKey : node.keySet()) {
                System.out.println(nodeKey);
                if (!processed.contains(nodeKey)) {
                    int nodeCost = (int) node.get(nodeKey);
                    System.out.println(nodeCost);
                    if (nodeCost < minValue) {
                        minValue = nodeCost;
                        minNode = (String) nodeKey;
                    }
                    neighbors.add(nodeKey);
                }
            }
            System.out.println("minNode: " + minNode + ", minValue: " + minValue);
            return Optional.ofNullable(minNode);
        }
        if (!neighbors.isEmpty()) {
            System.out.println(neighbors);
            neighbors.removeFirst();
            return Optional.of((String) neighbors.getFirst());
        }
        System.out.println("Not found check small node: " + key);
        return Optional.empty();
    }
}
