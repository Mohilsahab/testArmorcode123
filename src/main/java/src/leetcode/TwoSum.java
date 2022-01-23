package src.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {0,4,3,0};
        int target = 0;
        for (int num :new TwoSum().twoSum(nums, target)) {
            System.out.println(num);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        int ans [] = new int[2];
        for (int i=0 ; i<nums.length; i++) {
            if (mp.containsKey(target - nums[i])) {
                ans[0] = mp.get(target-nums[i]);
                ans[1] = i;
                return ans;
            }
            mp.put(nums[i], i);
        }
        return ans;
    }
}
