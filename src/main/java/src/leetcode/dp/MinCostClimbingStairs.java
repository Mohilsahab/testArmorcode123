package src.leetcode.dp;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int cost[] = {1,100,1,1,1,100,1,1,100,1};
//        int cost[] = {10, 15, 20};
        System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(cost));
    }

    public int minCostClimbingStairs(int[] cost) {
        int n= cost.length;
        int dp[] = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i=2; i<n; i++) {
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }
        return Math.min(dp[n-2], dp[n-1]);
    }
}
