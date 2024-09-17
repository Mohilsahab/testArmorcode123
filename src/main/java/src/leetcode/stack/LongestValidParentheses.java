package src.leetcode.stack;

import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
//        System.out.println(longestValidParentheses("(()"));
//        System.out.println(longestValidParentheses(")))()())"));
        System.out.println(longestValidParentheses("()()()"));
    }

    private static int longestValidParentheses(String s) {//4
        Stack<Integer> st = new Stack<>();//"-1(("
        st.push(-1);
        char ch;
        int maxCount = 0;
        for (int i=0; i<s.length(); i++) {
            ch = s.charAt(i);
            if (ch == '(') {
                st.push(i);
            } else {
                st.pop();
                if (st.isEmpty()) {
                    st.push(i);
                } else {
                    maxCount = Math.max(maxCount, i - st.peek());
                }
            }
        }
        return maxCount;
    }


}
