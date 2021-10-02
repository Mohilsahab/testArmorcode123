package src.leetcode.dp;

public class ClimibingStairs {
    public static void main(String[] args) {
        System.out.println(new ClimibingStairs().climbStairs(2));
        System.out.println(new ClimibingStairs().climbStairs(3));
        System.out.println(new ClimibingStairs().climbStairs(4));
        System.out.println(new ClimibingStairs().climbStairs(5));
    }

    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
