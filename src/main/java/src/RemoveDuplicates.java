package src;

import java.util.Stack;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String str ="acbbbacddaa";
        System.out.println(new RemoveDuplicates().removeDuplicates(str));
    }

    public String removeDuplicates(String str) {
        Stack<Character> stack = new Stack<>();
        stack.push(str.charAt(0));
        for (int i=1; i<str.length(); i++) {
            if (stack.empty()) {
                stack.push(str.charAt(i));
                continue;
            }
            char ch = stack.pop();
            if (ch == str.charAt(i)) {
                while(i<str.length() - 1 && str.charAt(i) == str.charAt(i+1)) {
                    i++;
                }
            } else  {
                stack.push(ch);
                stack.push(str.charAt(i));
            }
        }
        return makeStringFromStack(stack);
    }

    private String makeStringFromStack(Stack<Character> stack) {

        return null;
    }
}
