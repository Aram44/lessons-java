package algorithms.leetcode.les621;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Solution {
    public static Character addSplit = '_';

    public static void main(String[] args) {
//        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
//        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 3));
//        System.out.println(leastInterval(new char[]{'A', 'C', 'A', 'B', 'D', 'B'}, 3));
//        System.out.println(leastInterval(new char[]{'A', 'A'}, 2));
        System.out.println(leastInterval(new char[]{'B','C','D','A','A','A','A','G'}, 2));
    }

    public static int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) return 0;
        Map<Character, Integer> map = new ConcurrentHashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Character> list = new ArrayList<>();
        while (!map.isEmpty()) {
            System.out.println("Size: " + map.size());
            for (char c : map.keySet()) {
                System.out.println(c + " : " + map.get(c));
                var value = map.get(c);
                if (value == 0) {
                    System.out.println("Remove " + c);
                    map.remove(c);
                } else {
                    if (list.isEmpty()) {
                        System.out.println("List is empty add " + c);
                        list.add(c);
                        map.put(c, map.get(c) - 1);
                    }else {
                        System.out.println("List " + list);
                        if (n > list.size()) {
                            System.out.println("n > list " + c);
                            if (list.contains(c)) {
                                System.out.println("n > list containes " + c);
                                int len = n - list.lastIndexOf(c) - (list.size() == 1 ? 0 : list.size() );
                                System.out.println("len " + len);
                                for (int i = 0; i < len; i++) {
                                    list.add(addSplit);
                                }
                                list.add(c);
                                map.put(c, map.get(c) - 1);
                            }else {
                                System.out.println("n > list not containes " + c);
                                list.add(c);
                                map.put(c, map.get(c) - 1);
                            }
                        }else {
                            System.out.println("n < list " + c);
                            List<Character> slicedList = new ArrayList<>(list.subList(list.size() - n, list.size()));
                            while (slicedList.contains(c)) {
                                list.add(addSplit);
                                slicedList = new ArrayList<>(list.subList(list.size() - n, list.size()));
                            }
                            list.add(c);
                            map.put(c, map.get(c) - 1);
                        }
                    }
                }
            }
        }
        System.out.println("List: " + list);
        return list.size();
    }

    public static int leastIntervalV2(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char task : tasks){
            freq[task - 'A']++;
        }
        Arrays.sort(freq);
        int maxFreq = freq[25];
        int maxCount = 1;

        for(int i=24; i>=0; i--){
            if(freq[i] == maxFreq){
                maxCount++;
            } else {
                break;
            }
        }
        int partCount = (maxFreq-1)*(n+1)+maxCount;
        return Math.max(partCount, tasks.length);
    }
}
