package src;

public class LinkedListReverse {
    public static void main(String[] args) {

    }

    class Node {
        int value;
        Node next;
    }

    Node fun(Node root, int k) {
        if (root == null) {
            return null;
        }
//       2->3->4->5
//        k = 5, 5->4->3->2

        Node current = root;
        Node prev = null;
        boolean flag = false;
        while (current !=null && current.next != null) {
            current = current.next; // 3
            prev = current;   // 2
            for (int i=0;i<k-1 && current!=null &&  current.next!= null; i++) {
                Node temp = current; // 3
                current.next.next = current;
                current.next = prev;
                prev = temp.next; // 2
            }
            if (!flag) {
                root = prev;
                flag = true;
            }
            for (int i=0;i<k && current!=null; i++) {
                current = current.next;
                prev = current;
            }
        }
        return root;
    }
}
