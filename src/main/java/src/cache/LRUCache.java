package src.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */

    public static class Node {
        public int key;
        public int value;
        public Node prev;
        public Node next;
    }

    static Map<Integer, Node> map = new HashMap<Integer, Node>();// key, node
    int capacity;
    int size;
    static Node start;
    static Node end;

    public static void main(String[] args) {
    }

    static Node newNode(int key, int value) {
        Node node = new Node();
        node.key = key;
        node.value = value;
        return node;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key) {
        Node node  = map.get(key);
        if (node == null) {
            return -1;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        if (node == end) {
            end = node.prev;
        }
        node.next = start.next;
        start.next.prev = node;
        node.prev = null;
        start = node;
        return node.value;
    }

    public void put(int key, int value) {
        Node node  = map.get(key);
        if (node != null) {
            if (this.size == capacity) {
                removeLRUElement(node);
            }
        } else {
            if (this.size == capacity) {
                removeLRUElement(end);
            }
        }
        map.remove(key);
        addElement(key, value);
    }

    private void removeLRUElement(Node node) {
        if (node == end) {
            node.prev.next = null;
            end = node.prev;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        this.size--;
    }

    private void addElement(int key, int value) {
        Node node = newNode(key, value);
        this.size++;
        map.put(key, node);
        node.next = start.next;
        start = node;
        if (this.size == 0) {
            end = node;
        }
    }
}
