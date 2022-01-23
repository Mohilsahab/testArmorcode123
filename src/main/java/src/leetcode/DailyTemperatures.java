package src.leetcode;

import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        int temperatures[] = {73,74,75,71,69,72,76,73}; // [1,1,4,2,1,1,0,0]
//        int temperatures[] = {30,40,50,60}; // [1,1,1,0]
        int res[] = new DailyTemperatures().dailyTemperatures(temperatures);
        for (int temp : res) {
            System.out.print(temp + " ");
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int result[] = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        int top = 0;
        for (int i=0; i<temperatures.length; i++) {
            while (!stack.isEmpty()
                    && temperatures[stack.peek()] < temperatures[i]) {
                top = stack.pop();
                result[top] = i - top;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            result[stack.pop()] = 0;
        }
        return result;
    }
}
