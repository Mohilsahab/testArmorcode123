package src.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        List<List<Integer>> list = new Combinations().combine(4, 2);
        System.out.println(list);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combine(result, new ArrayList<>(), n, k, 1);
        return result;
    }

    private void combine(List<List<Integer>> result, List<Integer> temp, int n, int k, int index) {
        if (k == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i=index;i<=n; i++) {
            temp.add(i);
            combine(result, temp, n, k-1, i+1);
            temp.remove(temp.size() - 1);
        }
    }
}
