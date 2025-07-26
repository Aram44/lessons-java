package leetcode.les49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        final Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            var sChars = str.toCharArray();
            Arrays.sort(sChars);
            var newStr = String.valueOf(sChars);
            map.putIfAbsent(newStr, new ArrayList<>());
            map.get(newStr).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
