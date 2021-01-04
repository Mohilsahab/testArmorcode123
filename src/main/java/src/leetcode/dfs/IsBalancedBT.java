package src.leetcode.dfs;

import src.leetcode.TreeNode;

public class IsBalancedBT {
    public static void main(String[] args) {

    }

    boolean result;

    public boolean isBalanced(TreeNode root) {
        result = true;
        height(root);
        return result;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1) {
            result = false;
            return -1;
        }
        return 1 + Math.max(left, right);
    }
}
