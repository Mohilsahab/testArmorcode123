package src.leetcode.dfs;

import src.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BTFromInorderPostOrder {
    public static void main(String[] args) {
        int inOrder[] = {9,3,15,20,7};
        int postOrder[] = {9,15,7,20,3};
        System.out.println(new BTFromInorderPreorder().buildTree(inOrder, postOrder));
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i=0; i<inorder.length; i++) {
            mp.put(inorder[i], i);
        }
        return buildTree(postorder, inorder, 0, inorder.length - 1, mp);
    }

    public TreeNode buildTree(int[] postorder, int[] inorder, int inStartIndex, int inEndIndex, Map<Integer, Integer> mp) {
        return null;
    }
}
