package src.leetcode.stack;

import java.util.Stack;

public class StockSpanner {

    public StockSpanner() { }

    public static void main(String[] args) {
        int price[] = {10, 4, 5, 90, 120, 80};
        int span[] = calculateStockSpan(price);
        for (int i: span) {
            System.out.print(i + " ");
        }

    }

    private static int[] calculateStockSpan(int[] price) {
        int span[] = new int[price.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        span[0] = 1;
        for (int i=1; i<price.length; i++) {
            while (!st.isEmpty() &&
                    price[st.peek()] < price[i]) {
                st.pop();
            }
            span[i] = st.isEmpty() ? (i+1) : (i-st.peek());
            st.push(i);
        }
        return span;
    }

    public int next(int price) {
        return 0;
    }
}
