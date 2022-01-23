package src.leetcode.linkedList;

import src.leetcode.ListNode;

import java.util.List;

public class GroupReversal {
    public static void main(String[] args) {
        ListNode head = null;

        // Created Linked list is
        // 1.2.3.4.5.6.7.8.9
        head = ListNode.push(head, 9);
        head = ListNode.push(head, 8);
        head = ListNode.push(head, 7);
        head = ListNode.push(head, 6);
        head = ListNode.push(head, 5);
        head = ListNode.push(head, 4);
        head = ListNode.push(head, 3);
        head = ListNode.push(head, 2);
        head = ListNode.push(head, 1);

        new GroupReversal().reverseKGroup(head, 3);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int i=0;
        while (curr != null && i<k) {
            curr =curr.next;
            i++;
        }
        if (i<k) {
            return head;
        }
        ListNode prev = null;
        ListNode next = head;
        curr = head;
        while (curr != null && curr.next != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        if (next != null) {
            head.next = reverseKGroup(next, k);
        }
        return prev;
    }
}
