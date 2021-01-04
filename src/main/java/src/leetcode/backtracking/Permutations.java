package src.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int []nums = {1,2,3};
        List<List<Integer>> list = new Permutations().permute(nums);
        System.out.println(list);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void permute(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean []visited) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i=0; i<nums.length; i++) {
            if (!visited[i]) {
                tempList.add(nums[i]);
                visited[i] = true;
                permute(result, tempList, nums, visited);
                visited[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
