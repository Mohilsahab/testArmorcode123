package src.leetcode.trees;

import src.leetcode.TreeNode;

public class DiameterBT {
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        int ans = diameter(root);
        if (ans > max) {
            return ans - 1;
        } else {
            return max - 1;
        }
    }

    private int diameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = diameter(root.left);
        int right = diameter(root.right);
        if (left > 0 && right > 0) {
            if (left + right > max) {
                max = left + right;
            }
            return Math.max(left, right) + 1;
        } else if (left > 0) {
            return left + 1;
        } else if (right > 0) {
            return right + 1;
        } else {
            return 1;
        }
    }
}
