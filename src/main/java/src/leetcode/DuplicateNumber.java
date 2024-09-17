package src.leetcode;

public class DuplicateNumber {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};//2
//        int[] nums = {3,1,3,2,4};//3
//        int[] nums = {1,1,2};//1
        System.out.println(new DuplicateNumber().findDuplicate(nums));
    }

    public int findDuplicate(int[] nums) {
        int duplicate = -1;
        for (int i=0;i<nums.length; i++) {
            int cur = Math.abs(nums[i]);
            if (nums[cur] < 0) {
                duplicate = cur;
                break;
            }
            nums[cur] *=-1;
        }
        return duplicate;
    }
}
