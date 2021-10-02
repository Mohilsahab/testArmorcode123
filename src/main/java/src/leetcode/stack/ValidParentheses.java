package src.leetcode.stack;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        char ch;
        for (int i=0; i<s.length(); i++) {
            ch = s.charAt(i);
            if (ch == '[' || ch == '{' || ch == '(') {
                st.push(ch);
            } else {
                if (st.isEmpty()
                        || ch == ')' && st.peek() != '('
                        || ch == ']' && st.peek() != '['
                        || ch == '}' && st.peek() != '{') {
                    return false;
                } else {
                    st.pop();
                }
            }
        }
        return st.isEmpty();
    }

}
