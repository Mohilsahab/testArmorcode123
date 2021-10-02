package src.leetcode.stack;

import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()()"));
    }

    private static int longestValidParentheses(String s) {
        Stack<Character> st = new Stack<>();
        char ch;
        int count = 0;
        int maxCount = 0;
        for (int i=0; i<s.length(); i++) {
            ch = s.charAt(i);
            if (ch == '(') {
                st.push(ch);
            } else {
                if (ch == '(') {
                    st.push(ch);
                } else if (st.isEmpty()) {
                    if (count > maxCount) {
                        maxCount = count;
                    }
                    count = 0;
                } else {
                    st.pop();
                    count++;
                }
            }
        }
        if (count > maxCount) {
            maxCount = count;
        }
        return maxCount*2;
    }


}
