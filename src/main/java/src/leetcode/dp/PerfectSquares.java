package src.leetcode.dp;

import java.util.Arrays;

public class PerfectSquares {
    public static void main(String[] args) {
        System.out.println(new PerfectSquares().numSquares(12));
        System.out.println(new PerfectSquares().numSquares(13));
    }

    private int dp[];
    public int numSquares(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return fun(n);
    }

    private int fun(int n) {
        if (n<=3) {
            dp[n] = n;
            return n;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int total = Integer.MAX_VALUE;
        for (int i=1; i*i<=n; i++) {
            total = Math.min(1 + fun(n - i * i), total);
        }
        dp[n] = total;
        return dp[n];
    }
}