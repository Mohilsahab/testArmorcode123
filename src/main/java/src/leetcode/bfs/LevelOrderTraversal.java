package src.leetcode.bfs;

import src.leetcode.TreeNode;

import java.util.*;

public class LevelOrderTraversal {
    public static void main(String[] args) {
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return null;
        }
        Queue<Node> qu = new LinkedList<>();
        Node currNode = getNode(root, 0);
        qu.add(currNode);
        List<Integer> currLevelList = new ArrayList<>();
        currLevelList.add(root.val);
        int level = 0;
        while (!qu.isEmpty()) {
            currNode = qu.poll();
            if (currNode.level == level) {
                list.add(currLevelList);
                currLevelList = new ArrayList<>();
                level++;
            }
            currLevelList.add(currNode.node.val);
            if (currNode.node.left != null) {
                Node left = getNode(currNode.node.left, currNode.level + 1);
                qu.add(left);
            }
            if (currNode.node.right != null) {
                Node right = getNode(currNode.node.right, currNode.level + 1);
                qu.add(right);
            }
        }
        list.add(currLevelList);
        return list;
    }

    class Node {
        public TreeNode node;
        public int level = 0;
    }

    private Node getNode(TreeNode root, int level) {
        Node node = new Node();
        node.node = root;
        node.level = level;
        return node;
    }
}
