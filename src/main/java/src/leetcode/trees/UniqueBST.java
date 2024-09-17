package src.leetcode.trees;

import java.util.Arrays;

public class UniqueBST {
    public static void main(String[] args) {
        System.out.println(new UniqueBST().numTrees(3));//5
//        System.out.println(new UniqueBST().numTrees(1));//1
    }

    int dp[];
    public int numTrees(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, 0);
        dp[0] = dp[1] = 1;
        return numTreesRecursion(n);
    }

    private int numTreesRecursion(int n) {
        if (dp[n] != 0) {
            return dp[n];
        }
        for (int i=1; i<=n; i++) {
            dp[n] += numTreesRecursion(n-i) * numTreesRecursion(i-1);
        }
        return dp[n];
    }
}
