package src.leetcode.dfs;

import src.leetcode.TreeNode;

public class MinimumDepthBT {
    public static void main(String[] args) {

    }


    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left =  Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null) {
            right = minDepth(root.right);
        } else if (root.right == null) {
            left = minDepth(root.left);
        } else {
            right = minDepth(root.right);
            left = minDepth(root.left);
        }
        return 1 + Math.min(left, right);
    }
}
