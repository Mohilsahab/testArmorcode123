package src.leetcode.dfs;

import src.leetcode.ListNode;
import src.leetcode.TreeNode;

public class SortedListToBST {
    public static void main(String[] args) {
        ListNode list = new ListNode();
        traverse(new SortedListToBST().sortedListToBST(list));
    }

    private static void traverse(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            traverse(root.left);
            traverse(root.right);
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while(temp != null) {
            temp = temp.next;
            size++;
        }
        temp = head;
        int nums[] = new int[size];
        int  index = 0;
        while(temp != null) {
            nums[index++] = temp.val;
            temp = temp.next;
        }
        return sortedListToBST(nums, 0, index - 1);
    }

    private TreeNode sortedListToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedListToBST(nums, start, mid - 1);
        root.right = sortedListToBST(nums, mid + 1, end);
        return root;
    }
}
