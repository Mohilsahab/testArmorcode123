package src.leetcode.dp;

import src.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class HousingRobber3 {
    public static void main(String[] args) {

    }

    Map<TreeNode, Integer> mp = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (mp.get(root) != null) {
            return mp.get(root);
        }
        int count = 0;
        if (root.left != null) {
            count += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            count += rob(root.right.left) + rob(root.right.right);
        }
        mp.put(root, Math.max(root.val + count, rob(root.left) + rob(root.right)));
        return mp.get(root);
    }
}