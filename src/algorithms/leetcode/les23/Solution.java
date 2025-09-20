package algorithms.leetcode.les23;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        ListNode first = new ListNode(1,  new ListNode(4, new ListNode(5)));
        ListNode sec = new ListNode(1,  new ListNode(3, new ListNode(4)));
        ListNode third = new ListNode(2,  new ListNode(6));
        mergeKLists(new ListNode[] { first, sec, third });
    }

    private static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        List<Integer> allElements = new LinkedList<>();
        for (int i = 0; i < lists.length; i++) {
            var item = lists[i];
            if (item != null) {
                while (item != null) {
                    System.out.println(item.val);
                    allElements.add(item.val);
                    item = item.next;
                }
            }
        }
        if (!allElements.isEmpty()) {
            Collections.sort(allElements);
            ListNode first = new ListNode(allElements.getFirst());
            ListNode parent = first;
            allElements.removeFirst();
            for (var item : allElements) {
                ListNode newItem = new ListNode(item);
                parent.next = newItem;
                parent = newItem;
            }
            return first;
        }
        return null;
    }
}
