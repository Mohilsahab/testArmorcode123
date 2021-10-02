package src.leetcode.dp;

import java.util.Arrays;

public class MinJumpToReachHome {
    public static void main(String[] args) {
        int forbidden[] = {14,4,18,1,15};
        System.out.println(new MinJumpToReachHome().minimumJumps(forbidden, 3, 15, 9));
    }

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        int dp[] = new int[x+a+1];
        minimumJumps(forbidden, a, b, x, false, dp, 0);
        return dp[x] == 0 ? -1 : dp[x];
    }

    public int minimumJumps(int[] forbidden, int a, int b, int x, boolean isBackJumpAllowed, int dp[], int index) {
        if (index==x) {
            return 1;
        }
        if (isBackJumpAllowed) {
            if (index - b > x) {
                return 1;
            }
        } else {
            if (index + a - b > x) {
                return 1;
            }
        }
        if (dp[index + a] == 0 &&  index < x) {
            dp[index + a] =  minimumJumps(forbidden, a, b, x, true, dp, index + a) + dp[index];
        }
        if (dp[index + a - b] == 0 && index + a - b  > 0) {
            dp[index + a - b] =  minimumJumps(forbidden, a, b, x, false, dp, index + a - b) + dp[index];
        }
        if (dp[index - b] == 0 && isBackJumpAllowed && index - b > 0) {
            dp[index - b] =  minimumJumps(forbidden, a, b, x, false, dp, index - b) + dp[index];
        }
        return 1;
    }
}
