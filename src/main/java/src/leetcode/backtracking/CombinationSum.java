package src.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int []candidates = {1};
        int target = 2;
        List<List<Integer>> list = new CombinationSum().combinationSum(candidates, target);
        System.out.println(list);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(result, new ArrayList<>(), candidates, 0, target);
        return result;
    }

    private void combinationSum(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int index, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        if (target<0) {
            return;
        }
        for (int i=index; i<candidates.length; i++) {
            tempList.add(candidates[i]);
            combinationSum(result, tempList, candidates, i, target - candidates[i]);
            tempList.remove(tempList.size()-1);
        }
    }
}
