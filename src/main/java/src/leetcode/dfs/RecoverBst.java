package src.leetcode.dfs;

import src.leetcode.TreeNode;

public class RecoverBst {
    TreeNode first, middle, last, prev;

    public void recoverTree(TreeNode root) {
        first = null;
        middle = null;
        last = null;
        prev = null;
        recoverTreeUtil(root);
        int temp = first.val;
        if (first != null && last != null) {
            first.val = last.val;
            last.val = temp;
        } else if (first != null && middle != null) {
            first.val = middle.val;
            middle.val = temp;
        }
    }

    public void recoverTreeUtil(TreeNode root) {
        if (root == null) {
            return;
        }
        recoverTreeUtil(root.left);
        if (prev != null
            && root.val < prev.val) {
            if (first == null) {
                first = prev;
                middle = root;
            } else {
                last = root;
            }
        }
        prev = root;
        recoverTreeUtil(root.right);
    }
}
