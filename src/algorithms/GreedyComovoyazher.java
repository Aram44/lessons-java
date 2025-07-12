package algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GreedyComovoyazher {
    public static Map<String, Map<String, Integer>> cities = new HashMap();
    public static Set<String> directions = new HashSet();
    public static int distance = 0;

    public static void main(String[] args) {
        cities.put("City1", Map.of("City2", 101, "City3", 50, "City4", 68, "City5", 100));
        cities.put("City2", Map.of("City1", 100, "City3", 87, "City4", 90, "City5", 150));
        cities.put("City3", Map.of("City1", 50, "City2", 87, "City4", 25, "City5", 94));
        cities.put("City4", Map.of("City1", 68, "City2", 90, "City3", 25, "City5", 71));
        cities.put("City5", Map.of("City1", 100, "City2", 150, "City3", 94, "City4", 71));

        String currentCity = "City3";
        directions.add(currentCity);
        int minDistance = Integer.MAX_VALUE;

        while (directions.size() != cities.size()) {
            System.out.println(currentCity);
            var nextCities = cities.get(currentCity);
            for (var city : nextCities.entrySet()) {
                if (!directions.contains(city.getKey())) {
                    if (city.getValue() < minDistance){
                        minDistance = city.getValue();
                        currentCity = city.getKey();
                    }
                }
            }
            directions.add(currentCity);
            distance += minDistance;
            minDistance = Integer.MAX_VALUE;
        }
        System.out.println(currentCity);
        System.out.println(distance);
    }
}
