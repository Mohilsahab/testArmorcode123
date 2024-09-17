package src.leetcode;

public class MoveZeros {
    public static void main(String[] args) {
        int nums[] = {0,1,0,3,12};//1,3,12,0,0
        new MoveZeros().moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public void moveZeroes(int[] nums) {
        int nonZeroElementIndex = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroElementIndex++] = nums[i];
            }
        }
        for (int i=nonZeroElementIndex; i<nums.length; i++) {
            nums[i]=0;
        }
    }
}
