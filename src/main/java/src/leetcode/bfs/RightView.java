package src.leetcode.bfs;

import src.leetcode.TreeNode;

import java.util.*;

public class RightView {
    public static void main(String[] args) {
    }

    int maxLevel;
    List<Integer> list;
    public List<Integer> rightSideView(TreeNode root) {
        list = new ArrayList<>();
        maxLevel = -1;
        rightSideView(root, 0);
        return list;
    }

    private void rightSideView(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level > maxLevel) {
            list.add(root.val);
            maxLevel++;
            // System.out.println(maxLevel + " " + level);
        }
        rightSideView(root.right, level + 1);
        rightSideView(root.left, level + 1);
    }


    class Node {
        public TreeNode node;
        public int level = 0;
    }

    public List<Integer> rightSideViewWithoutRecursion(TreeNode root) {
        Queue<Node> qu = new LinkedList<>();
        Node currNode = getNode(root, 0);
        qu.add(currNode);
        Map<Integer, Integer> mp = new HashMap<>();
        while (!qu.isEmpty()) {
            currNode = qu.poll();
            mp.put(currNode.level, currNode.node.val);
            if (currNode.node.left != null) {
                Node left = getNode(currNode.node.left, currNode.level + 1);
                qu.add(left);
            }
            if (currNode.node.right != null) {
                Node right = getNode(currNode.node.right, currNode.level + 1);
                qu.add(right);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (Integer value : mp.values()) {
            list.add(value);
        }
        return list;
    }

    private Node getNode(TreeNode root, int level) {
        Node node = new Node();
        node.node = root;
        node.level = level;
        return node;
    }
}
