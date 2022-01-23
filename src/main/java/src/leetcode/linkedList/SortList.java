package src.leetcode.linkedList;

import src.leetcode.ListNode;

public class SortList {
    public static void main(String[] args) {

    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    private ListNode getMid(ListNode head) {
        ListNode mid = null;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            mid = (mid == null) ? fast : mid.next;
            fast = fast.next.next;
        }
        ListNode prev = mid.next;
        mid.next = null;
        return prev;
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode temp = new ListNode();
        ListNode newNode = temp;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                newNode.next = list1;
                list1 = list1.next;
                newNode = newNode.next;
            } else {
                newNode.next = list2;
                list2 = list2.next;
                newNode = newNode.next;
            }
        }
        newNode.next = list1!= null ? list1 : list2;
        return temp.next;
    }
}
