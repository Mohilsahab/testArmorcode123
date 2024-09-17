package src.leetcode;

public class MaxSubArray {
    public static void main(String[] args) {
//        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};//6
//        int[] nums = {5,4,-1,7,8};//23
        int[] nums = {-1};//-1
        System.out.println(new MaxSubArray().maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > maxSum) {
                maxSum = nums[i];
            }
        }
        if (maxSum < 0) {
            return maxSum;
        }
        int sum = 0;
        int prev = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            if (sum < 0) {
                while (sum < 0 && prev <=i) {
                    sum -= nums[prev++];
                }
            }
            if (maxSum < sum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }
}
