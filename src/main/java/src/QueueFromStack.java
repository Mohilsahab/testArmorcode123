package src;

import java.util.Stack;

public class QueueFromStack {
    static Stack<Integer> s1 = new Stack<Integer>();
    static Stack<Integer> s2 = new Stack<Integer>();

    public static void main(String[] args) {
        QueueFromStack queue = new QueueFromStack();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);

        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
    }

    private void enQueue(int x) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(x);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    private int deQueue() {
        if (s1.empty()) {
            System.exit(0);
        }
        int x = s1.peek();
        s1.pop();
        return x;
    }
}
