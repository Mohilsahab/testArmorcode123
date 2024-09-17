package src.leetcode.stack;

import java.util.Stack;

public class MinStack {
    public static void main(String[] args) {

    }

    private Stack<Integer> st;
    private Stack<Integer> min_val;
    public MinStack() {
        st = new Stack<>();
        min_val = new Stack<>();
    }

    public void push(int val) {
        if (min_val.isEmpty() || val<=min_val.peek()) {
            min_val.push(val);
        }
        st.push(val);
    }

    public void pop() {
        if (st.peek().equals(min_val.peek())) {
            min_val.pop();
        }
        st.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return min_val.peek();
    }
}
