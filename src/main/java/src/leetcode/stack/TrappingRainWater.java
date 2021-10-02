package src.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

public class TrappingRainWater {
    public static void main(String[] args) {
        int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
        System.out.println(trapUsingTrap(height));
    }

    public static int trap(int[] height) {
        int leftMax[] = new int[height.length];
        int rightMax[] = new int[height.length];
        int max = -1;
        for (int i=0; i < height.length; i++)  {
            if (height[i] >= max) {
                max = height[i];
            }
            leftMax[i] = max;
        }
        max = -1;
        for (int i= height.length-1; i>=0; i--) {
            if (height[i] >= max) {
                max = height[i];
            }
            rightMax[i] = max;
        }
        int count=0;
        for (int i= 0; i< height.length; i++) {
            count += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return count;
    }

    public static int trapUsingTrap(int[] height) {
        Stack<Integer> st = new Stack<>();
        return 0;
    }
}
