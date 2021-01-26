package src.leetcode.dfs;

import java.util.*;

public class CloneGraph {
    public Node cloneGraph(Node root) {
        Map<Integer, Node> visited = new HashMap<>();
        return dfs(root, visited);
    }

    private Node dfs(Node root, Map<Integer, Node> visited) {
        if (root == null) {
            return null;
        }
        if (visited.containsKey(root.val)) {
            return visited.get(root.val);
        }
        Node newNode = new Node(root.val);
        visited.put(root.val, newNode);
        for (Node node : root.neighbors) {
            newNode.neighbors.add(dfs(node, visited));
        }
        return newNode;
    }

    public Node cloneGraph_bfs(Node root) {
        Map<Integer, Node> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        visited.put(root.val, new Node(root.val));
        Node currNode;
        while (!queue.isEmpty()) {
            currNode = queue.poll();
            for (Node node : currNode.neighbors) {
                if (!visited.containsKey(node.val)) {
                    visited.put(node.val, new Node(node.val));
                    queue.add(node);
                }
                visited.get(currNode.val).neighbors.add(visited.get(node));
            }
        }
        System.out.println("currNode.val = " + visited.get(root.val));
        return visited.get(root.val);
    }


    private class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
