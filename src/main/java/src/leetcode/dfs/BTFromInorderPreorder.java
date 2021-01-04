package src.leetcode.dfs;

import src.leetcode.TreeNode;

public class BTFromInorderPreorder {
    public static void main(String[] args) {
        int preOrder[] = {3,9,20,15,7};
        int inOrder[] = {9,3,15,20,7};
        System.out.println(new BTFromInorderPreorder().buildTree(preOrder, inOrder));
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int preIndex, int inStartIndex, int inEndIndex) {
        if (preIndex == preorder.length || inStartIndex > inEndIndex) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex]);
        int inIndex = inStartIndex;
        for (int i=inStartIndex; i<=inEndIndex; i++) {
            if (inorder[i] == preorder[preIndex]) {
                inIndex = i;
                break;
            }
        }
        root.left = buildTree(preorder, inorder, preIndex + 1, inStartIndex, inIndex - 1);
        root.right = buildTree(preorder, inorder, preIndex + inEndIndex + 1, inIndex + 1, inEndIndex);
        return root;
    }
}
