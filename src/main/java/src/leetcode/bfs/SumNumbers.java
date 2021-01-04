package src.leetcode.bfs;

import src.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SumNumbers {
    class Node {
        TreeNode node;
        int sum;
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxSum = 0;
        Queue<Node> qu = new LinkedList<>();
        Node node = getNode(root, root.val);
        qu.add(node);
        while (!qu.isEmpty()) {
            Node currNode = qu.poll();
            TreeNode currTreeNode = currNode.node;
            currNode.sum = currNode.sum *10 + currTreeNode.val;
            if (currTreeNode.left == null && currTreeNode.right == null) {
                maxSum += currNode.sum;
            }

            System.out.println(currTreeNode.val + " " + currNode.sum + " " + maxSum);
            if (currTreeNode.left!= null) {
                Node left = getNode(currTreeNode.left, currNode.sum);
                qu.add(left);
            }
            if (currTreeNode.right != null) {
                Node right = getNode(currTreeNode.right, currNode.sum);
                qu.add(right);
            }
        }
        return maxSum;
    }

    private Node getNode(TreeNode root, int sum) {
        Node node = new Node();
        node.node = root;
        node.sum = sum;
        return node;
    }
}
