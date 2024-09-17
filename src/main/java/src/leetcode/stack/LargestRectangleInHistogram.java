package src.leetcode.stack;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
//        int heights[] = {2,1,5,6,2,3};
//        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(heights));
        int heights1[] = {0,9};
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(heights1));
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int i=0;
        int maxArea = 0;
        while (i < heights.length) {
            if (st.isEmpty() || heights[st.peek()] <= heights[i]) {
                st.push(i++);
            } else {
                int top = st.pop();
                int tempMax = heights[top] * (st.isEmpty() ? i : (i-st.peek()-1));
                if (tempMax > maxArea) {
                    maxArea = tempMax;
                }
            }
        }
        while (!st.isEmpty()) {
            int top = st.pop();
            int tempMax = heights[top] * (st.isEmpty() ? i : (i-st.peek()-1));
            if (tempMax > maxArea) {
                maxArea = tempMax;
            }
        }

        return maxArea;
    }
}
