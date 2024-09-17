package src.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2 {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 3};
        int res[] = new NextGreaterElement2().nextGreaterElements(arr);
        for (int num : res) {
            System.out.println(num);
        }
    }

    public int[] nextGreaterElements(int[] nums) {
        int res[] = new int[nums.length];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        for (int i=0 ; i<nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                res[stack.pop()] = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
            stack.push(i);
        }
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] == max) {
                stack.pop();
            }
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                res[stack.pop()] = nums[i];
            }
        }
        return res;
    }
}