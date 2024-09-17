package src.leetcode;

public class ListNode {
     public int val;
     public ListNode next;

     public ListNode() {}

     public ListNode(int val) { this.val = val; }

     public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

     public static ListNode push(ListNode head_ref, int new_data) {
          // allocate node /
          ListNode new_node = new ListNode();

          // put in the data /
          new_node.val = new_data;

          // link the old list off the new node /
          new_node.next = (head_ref);

          // move the head to point to the new node /
          (head_ref) = new_node;
          return head_ref;
     }
}
