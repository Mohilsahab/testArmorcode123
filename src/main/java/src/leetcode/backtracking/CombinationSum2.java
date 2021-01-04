package src.leetcode.backtracking;

import java.util.*;

public class CombinationSum2 {

    public static void main(String[] args) {
        int []candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> list = new CombinationSum2().combinationSum2(candidates, target);
        System.out.println(list);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(result, new ArrayList<>(), candidates, 0, target);
        return result;
    }

    private void combinationSum2(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int index, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        if (target<0) {
            return;
        }
        for (int i=index; i<candidates.length; i++) {
            if (i == index || candidates[i] != candidates[i-1]) {
                tempList.add(candidates[i]);
                combinationSum2(result, tempList, candidates, i+1, target - candidates[i]);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
