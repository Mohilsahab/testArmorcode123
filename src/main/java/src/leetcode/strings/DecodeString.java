package src.leetcode.strings;

import org.apache.commons.lang3.StringUtils;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
//        System.out.println(new DecodeString().decodeString("3[a]2[bc]"));
//        System.out.println(new DecodeString().decodeString("3[a2[c]]"));
//        System.out.println(new DecodeString().decodeString("2[abc]3[cd]ef"));
//        System.out.println(new DecodeString().decodeString("abc3[cd]xyz"));
        System.out.println(new DecodeString().decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }

    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i)==']') {
                String temp = "";
                while (!isNumeric(stack.peek())) {
                    if (stack.peek().equals("[")) {
                        stack.pop();
                    } else {
                        temp = stack.pop() + temp;
                    }
                }
                Integer num = Integer.parseInt(stack.pop());
                StringBuilder stringBuilder = new StringBuilder(temp);
                for (int j=1; j<num; j++) {
                    stringBuilder.append(temp);
                }
                stack.push(stringBuilder.toString());
            } else if (Character.isDigit(s.charAt(i))) {
                if (!stack.isEmpty() && isNumeric(stack.peek())) {
                    stack.push(stack.pop() + s.charAt(i));
                } else {
                    stack.push(String.valueOf(s.charAt(i)));
                }
            } else {
                stack.push(String.valueOf(s.charAt(i)));
            }
        }
        String temp = "";
        while (!stack.isEmpty()) {
            if (stack.peek().equals("[")) {
                stack.pop();
            } else {
                temp = stack.pop() + temp;
            }
        }
        return temp;
    }

    private boolean isNumeric(CharSequence cs) {
        int sz = cs.length();
        for(int i = 0; i < sz; ++i) {
            if (!Character.isDigit(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
