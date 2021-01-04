package src.leetcode.bfs;

import src.leetcode.Node;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextPointers {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        Node prev, node;
        int size;
        while (!qu.isEmpty()) {
            size = qu.size();
            prev = null;
            for (int i=0; i<size; i++) {
                node = qu.poll();
                if (prev != null) {
                    prev.next = node;
                }
                prev = node;
                if (node.left!=null) {
                    qu.add(node.left);
                }
                if (node.right!=null) {
                    qu.add(node.right);
                }
            }
            prev.next = null;
        }
        return root;
    }
}
