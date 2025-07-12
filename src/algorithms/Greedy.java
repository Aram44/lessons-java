package algorithms;

import java.util.*;

public class Greedy {
    public static Set<String> states = new HashSet<String>();
    public static Map<String, List<String>> stations = new HashMap<String, List<String>>();
    public static Set<String> finalStations = new HashSet<>();

    public static void main(String[] args) {
        states.add("mt");
        states.add("wa");
        states.add("or");
        states.add("ut");
        states.add("id");
        states.add("nv");
        states.add("ca");
        states.add("am");

        stations.put("kone", List.of("id", "nv", "ut"));
        stations.put("ktwo", List.of("wa", "id", "mt"));
        stations.put("kthree", List.of("or", "nv", "ca"));
        stations.put("kfour", List.of("nv", "ut"));
        stations.put("kfive", List.of("ca", "am"));

        Map.Entry<String, List<String>> bestStation = null;
        int bestStatenCovering = 0;
        Set<String> statesCovered = new HashSet<>();
        var statesNeeded = new HashSet<String>(states);

        while (!statesNeeded.isEmpty()) {
            for (var entry : stations.entrySet()) {
                Set<String> covered = new HashSet<>(entry.getValue());
                covered.removeAll(statesCovered);
                if (covered.size() > bestStatenCovering) {
                    bestStatenCovering = covered.size();
                    bestStation = entry;
                }
            }
            if (bestStation != null) {
                statesCovered.addAll(bestStation.getValue());
                finalStations.add(bestStation.getKey());
                bestStation = null;
                bestStatenCovering = 0;
            }
            statesNeeded.removeAll(statesCovered);
        }
        System.out.println(finalStations);
    }
}
