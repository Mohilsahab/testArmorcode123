package src.leetcode.dfs;

import src.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BTPaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root != null) {
            binaryTreePaths(res, new StringBuilder(), root, root);
        }
        return res;
    }
//             1
//           /   \
//          2     3
//           \
//            5
//    [37,-34,-48,null,-100,-100,48,null,null,null,null,-54,null,-71,-22,null,null,null,8]
    private void binaryTreePaths(List<String> res, StringBuilder str, TreeNode root, TreeNode node) {
        if (root != node) {
            str.append("->");
        }
        str.append(node.val);
        if (node.left == null && node.right == null) {
            res.add(str.toString());
            int index = str.lastIndexOf("->");
            if (index != -1) {
                str.delete(index, str.length());
            }
            return;
        }
        if (node.left != null) {
            binaryTreePaths(res, str, root, node.left);
        }
        if (node.right != null) {
            binaryTreePaths(res, str, root, node.right);
        }
        int index = str.lastIndexOf("->");
        if (index != -1) {
            str.delete(index, str.length());
        }
    }
}
