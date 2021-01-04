package src.leetcode.dfs;

import src.leetcode.TreeNode;

public class SortedArrayToBST {
    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        traverse(new SortedArrayToBST().sortedArrayToBST(nums));
    }

    private static void traverse(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            traverse(root.left);
            traverse(root.right);
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, start, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, end);
        return root;
    }
}
