package src.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
//        int nums[] = {-1,0,1,2,-1,-4}; //[[-1,-1,2],[-1,0,1]]
//        int nums[] = {0,0,0,0}; //[[0,0,0]]
        int nums[] = {-2,0,1,1,2}; //[[-2,0,2],[-2,1,1]]
        System.out.println(new ThreeSum().threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0; i<nums.length-2; i++) {
            if (i==0 || nums[i]!=nums[i-1]) {
                int low = i + 1;
                int high = nums.length - 1;
                while (low < high) {
                    if (nums[low] + nums[high] + nums[i] == 0) {
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        low++;
                        high--;
                        while (low < high && nums[low] == nums[low - 1]) low++;
                        while (low < high && nums[high] == nums[high + 1]) high--;
                    } else if (nums[low] + nums[high] + nums[i] > 0) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }
        return result;
    }
}
