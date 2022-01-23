package src.dataStreams;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpanner {

    public static void main(String[] args) {
        StockSpanner spanner = new StockSpanner();
        System.out.println(spanner.next(100));//1
        System.out.println(spanner.next(80));//1
        System.out.println(spanner.next(60));//1
        System.out.println(spanner.next(70));//2
        System.out.println(spanner.next(60));//1
        System.out.println(spanner.next(75));//4
        System.out.println(spanner.next(85));//6
    }

    private Stack<Integer> st;
    private int index;
    private List<Integer> stocks;

    public StockSpanner() {
        this.stocks = new ArrayList<>();
        this.index = 0;
        this.st = new Stack<>();
    }

    public int next(int price) {
        if (index ==0) {
            stocks.add(price);
            st.push(index);
            index++;
            return index;
        } else {
            while (!st.isEmpty() && stocks.get(st.peek()) <= price) {
                st.pop();
            }
            int res;
            if (st.isEmpty()) {
                res = index+1;
            } else {
                res = index - st.peek();
            }
            stocks.add(price);
            st.push(index++);
            return res;
        }
    }
}
