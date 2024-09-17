package src.leetcode;

public class FirstMissingPositive {
    public static void main(String[] args) {
//        int[] nums = {3,4,-1,1};//2
        int[] nums = {1,2,0};//3
        System.out.println(new FirstMissingPositive().firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            if (nums[i]<0) {
                nums[i]=0;
            }
        }

        for (int i=0; i<nums.length; i++) {
            int val = Math.abs(nums[i]);
            if (1<=val && val<=nums.length) {
                if (nums[val - 1] == 0) {
                    nums[val - 1] = -1 * (nums.length + 1);
                } else if (nums[val - 1] > 0) {
                    nums[val - 1] = -1 * nums[val - 1];
                }
            }
        }

        for (int i=1; i<=nums.length; i++) {
            if (nums[i-1]>=0) {
                return i;
            }
        }

        return nums.length+1;
    }
}