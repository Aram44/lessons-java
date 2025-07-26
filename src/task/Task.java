package task;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Task {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("ABCBC"));
        System.out.println(lengthOfLongestSubstring("AAA"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
     //   engthOfLongestSubstring( 'ABCBC' ) returns 3 (ABC);
// lengthOfLongestSubstring( 'AAA' ) returns 1 (A);
// lengthOfLongestSubstring( 'pwwkew' ) returns 3 (wke);
    }

    private static int lengthOfLongestSubstring(String s){
        if (s.isEmpty()) return 0;
        int res = 0;
        int i = 0;
        for (int j = 1; j <= s.length(); j++) {
            var sub = s.substring(i, j);
            var chars = sub.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
            if (chars.size() == sub.length() && chars.size() > res) {
                res = chars.size();
            }else {
                i++;
            }
        }
        return res;
    }
}
