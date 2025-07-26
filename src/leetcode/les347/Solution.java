package leetcode.les347;

import java.security.Key;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(topKFrequent(new int[]{2, 2, 3, 4, 5, 6, 4}, 2));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        if (nums == null || k < 1) {
            return new int[]{};
        }
        final var map = new HashMap<Integer, Integer>();
        for (var num : nums) {
            Integer value = map.get(num);
            if (value == null){
                map.put(num, 1);
            } else {
                map.put(num, value + 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        var res = new int[k];
        for (int i = 0; i < k; i++) {
            var item = list.get(list.size() - 1 - i);
            res[i] = (int) item.getKey();
        }
        return res;
    }
}
