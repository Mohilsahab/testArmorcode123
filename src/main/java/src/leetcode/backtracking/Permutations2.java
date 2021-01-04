package src.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2 {
    public static void main(String[] args) {
        int []nums = {1,1,2};
        List<List<Integer>> list = new Permutations2().permuteUnique(nums);
        System.out.println(list);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        permuteUnique(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void permuteUnique(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean []visited) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i=0; i<nums.length; i++) {
            if (!visited[i]) {
                tempList.add(nums[i]);
                visited[i] = true;
                permuteUnique(result, tempList, nums, visited);
                visited[i] = false;
                tempList.remove(tempList.size() - 1);
                while ((i+1) < nums.length
                        && nums[i] == nums[i+1]) {
                    i++;
                }
            }
        }
    }
}
