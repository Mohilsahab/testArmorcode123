package src.codechef;

import java.util.*;

public class PeriodicStrings {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(getNoOfNonPeriodicStrings(n, m));
        System.out.println(getNoOfNonPeriodicStrings(6, 176));
    }

    private static int getNoOfNonPeriodicStrings(int n, int mod) {
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return getNoOfNonPeriodicStrings(dp, 1, n, mod);
    }

    private static int getNoOfNonPeriodicStrings(int[] dp, int i, int n, int mod) {
        if (n==1) {
            return 2;
        }
        if (dp[n-1] != -1) {
            return dp[n-1];
        }
        int res = 1;
        for (int k=1; k<=n; k++) {
            res *=2;
            res %= mod;
        }
        List<Integer> divisors = getDivisors(n);
        for (Integer divisor : divisors) {
            if (divisor != 1 && divisor != n) {
                res -= getNoOfNonPeriodicStrings(dp, divisor, n / divisor, mod);
                res %= mod;
            }
        }
        dp[n-1] = res;
        return res;
    }

    private static List<Integer> getDivisors(int n) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                divisors.add(i);
                divisors.add(n / i);
            }
        }
        return divisors;
    }
}
