package src.dataStreams;

import java.util.Stack;

public class BrowserHistory {
    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");
        browserHistory.visit("fb.com");
        browserHistory.visit("youtube.com");
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.forward(1));
        browserHistory.visit("linkedIn.com");
        System.out.println(browserHistory.forward(2));
        System.out.println(browserHistory.back(2));
        System.out.println(browserHistory.back(7));
    }

    private Stack<String> stack;
    private Stack<String> forwardHistory;

    public BrowserHistory(String homepage) {
        this.stack = new Stack<>();
        this.forwardHistory = new Stack<>();
        this.stack.push(homepage);
    }

    public void visit(String url) {
        this.stack.push(url);
        this.forwardHistory.clear();
    }

    public String back(int steps) {
        while (steps-->0 && stack.size()>1) {
            forwardHistory.push(stack.pop());
        }
        return stack.peek();
    }

    public String forward(int steps) {
        while (steps-->0 && !forwardHistory.isEmpty()) {
            stack.push(forwardHistory.pop());
        }
        return stack.peek();
    }
}
