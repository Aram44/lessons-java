package leetcode.les2;

import java.util.Optional;

public class Solution {

    public static void main(String[] args) {
        var l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        var l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))));
        var res = addTwoNumbers(l1, l2);
        System.out.println(res);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode sum = res;
        int total;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            total = carry;
            if(l1 != null){
                total += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                total += l2.val;
                l2 = l2.next;
            }
            int num = total % 10;
            carry = total / 10;
            res.next = new ListNode(num);
            res = res.next;
        }
        return sum.next;
    }
}
