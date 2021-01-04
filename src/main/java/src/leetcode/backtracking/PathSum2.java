package src.leetcode.backtracking;

import src.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSum(result, new ArrayList<Integer>(),root, sum);
        return result;
    }

    private void pathSum(List<List<Integer>> result, List<Integer> tempList, TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (sum==root.val
                && root.left == null
                && root.right == null) {
            tempList.add(root.val);
            result.add(new ArrayList<>(tempList));
            tempList.remove(tempList.size() - 1);
            return;
        }
        tempList.add(root.val);
        pathSum(result, tempList, root.left, sum - root.val);
        pathSum(result, tempList, root.right, sum - root.val);
        tempList.remove(tempList.size() - 1);
    }
}
