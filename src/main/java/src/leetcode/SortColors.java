package src.leetcode;

public class SortColors {
    public static void main(String[] args) {
//        int nums[] = {2,0,2,1,1,0};//[0,0,1,1,2,2]
//        int nums[] = {1,2,2,2,2,0,0,0,1,1};//[0,0,0,1,1,1,2,2,2,2]
//        int nums[] = {2,0,1};//[0,1,2]
        int nums[] = {1,2,0};//[0,1,2]
//        int nums[] = {0};//[0]
        new SortColors().sortColors(nums);
        for (int num : nums) {
            System.out.print(num);
        }
    }

    public void sortColors(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int mid = 0;

        while (mid <= high) {
            switch (nums[mid]) {
                case 0: swap(nums, low++, mid++);
                    break;
                case 1: mid++;
                    break;
                case 2: swap(nums, mid, high--);
                    break;
            }
        }
    }

    private void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
