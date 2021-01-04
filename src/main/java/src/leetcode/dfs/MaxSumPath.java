package src.leetcode.dfs;

import src.leetcode.TreeNode;

public class MaxSumPath {
    public static void main(String[] args) {
    }

//    [5,4,8,11,null,13,4,7,2,null,null,null,1]

    class Res {
        public int value;
    }

    public int maxPathSum(TreeNode root) {
        Res res = new Res();
        res.value = Integer.MIN_VALUE;
        maxPathSum(root,res);
        return res.value;
    }

    public int maxPathSum(TreeNode root, Res res) {
        if (root == null) {
            return 0;
        }
        int leftSum = maxPathSum(root.left, res);
        int rightSum = maxPathSum(root.right, res);

        int maxSum  = Math.max(Math.max(leftSum, rightSum) + root.val, root.val);

        res.value = Math.max(res.value, Math.max(maxSum, leftSum + rightSum + root.val));
        return maxSum;
    }
}
