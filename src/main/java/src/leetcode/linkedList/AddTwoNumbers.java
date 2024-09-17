package src.leetcode.linkedList;

import src.leetcode.ListNode;

public class AddTwoNumbers {
    public static void main(String[] args) {}

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        
        ListNode l3 = new ListNode();
        ListNode p3 = l3;
        int carry = 0, val;

        while (l1!= null && l2 != null) {
            val = l1.val + l2.val + carry;
            carry = val/10;
            p3.next = new ListNode(val%10);
            p3 = p3.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            val = l1.val + carry;
            carry = val/10;
            p3.next = new ListNode(val%10);
            p3 = p3.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            val = l2.val + carry;
            carry = val/10;
            p3.next = new ListNode(val%10);
            p3 = p3.next;
            l2 = l2.next;
        }
        if (carry > 0) {
            p3.next = new ListNode(carry);
        }
        return l3.next;
    }
}
