package leetcode.les253;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
       System.out.println(minMeetingRooms(new ArrayList<>(List.of(new Interval(0, 40), new Interval(5, 10), new Interval(15,20)))));
       System.out.println(minMeetingRooms(new ArrayList<>(List.of(new Interval(4, 9)))));
    }

    public static int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return 0;
        }
        if (intervals.size() == 1) {
            return 1;
        }
        intervals.sort((a, b) -> a.start - b.start);
        int days = 0;
        int current = 0;
        int next = 1;
        while (!intervals.isEmpty()) {
            var end = intervals.get(current).end;
            var start = intervals.get(next).start;
            if (end < start) {
                intervals.remove(current);
            }else {
                next++;
            }
            if (next == intervals.size()) {
                intervals.remove(current);
                next = 1;
                days++;
            }
        }
        return days;
    }
}
