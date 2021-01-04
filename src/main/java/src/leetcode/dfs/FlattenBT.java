package src.leetcode.dfs;

import src.leetcode.TreeNode;

public class FlattenBT {
    public static void main(String[] args) {
    }

    public TreeNode flatten(TreeNode root) {
        if (root == null) {
            return null;
        }
        flattenTree(root);
        return root;
    }

    public TreeNode flattenTree(TreeNode root) {
        TreeNode left, right;
        if (root.left == null && root.right == null) {
            return root;
        } else if (root.left == null) {
            return flattenTree(root.right);
        } else if (root.right == null) {
            left = flattenTree(root.left);
            root.right = root.left;
            root.left = null;
            return left;
        } else {
            left = flattenTree(root.left);
            right = flattenTree(root.right);
            left.right = root.right;
            root.right = root.left;
            root.left = null;
            return right;
        }
    }
}