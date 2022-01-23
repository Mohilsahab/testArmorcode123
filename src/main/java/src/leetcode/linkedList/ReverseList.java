package src.leetcode.linkedList;

import src.leetcode.ListNode;

public class ReverseList {
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

        new ReverseList().reverseList(head);
    }

    public ListNode reverseList(ListNode head) {
        return null;
    }
}