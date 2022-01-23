package src.leetcode;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
//        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] nums = {9,10,9,-7,-4,-8,2,-6};//k=5, [10,10,9,2]
        for (int val : new SlidingWindowMaximum().maxSlidingWindow(nums, 5)) {//[3,3,5,5,6,7]
            System.out.print(val + " ");
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int res[] = new int[nums.length - k + 1];
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i=0; i<k-1; i++) {
            if (nums[i] >= max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        for (int i=k-1; i<nums.length; i++) {
            if (nums[i] >= max) {
                max = nums[i];
                maxIndex = i;
            }
            res[i-k+1] = max;
            if (maxIndex == i-k+1) {
                max = Integer.MIN_VALUE;
                for (int j=i-k+2; j<=i; j++) {
                    if (nums[j] >= max) {
                        max = nums[j];
                        maxIndex = j;
                    }
                }
            }
        }
        return res;
    }
}
