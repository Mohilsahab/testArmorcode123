package src.leetcode.backtracking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PermutationSequence {
    public static void main(String[] args) {
        System.out.println(new PermutationSequence().getPermutation(3,3));
    }

    static Map<Integer, Integer> mp  = new HashMap<>();

    public String getPermutation(int n, int k) {
        StringBuilder str = new StringBuilder();
        boolean vistited[] = new boolean[n+1];
//        Arrays.fill(vistited, false);
        int index = 1;
        int sum = 0;
        int i = 1;
        while (i<=n) {
            if (!vistited[i]) {
                sum += fact(n - index);
                if (sum > k) {
                    sum -= mp.get(n - index);
                    str.append(i);
                    vistited[i] = true;
                    index++;
                    i = 0;
                } else if (sum == k) {
                    str.append(i);
                    vistited[i] = true;
                    for (int j = n; j >= 1; j--) {
                        if (!vistited[j]) {
                            str.append(j);
                        }
                    }
                    return str.toString();
                }
            }
            i++;
        }
        return str.toString();
    }

    int fact(int n) {
        if (n==0 || n==1) {
            mp.put(0,1);
            mp.put(1,1);
            return 1;
        }
        if (!mp.containsKey(n)) {
            mp.put(n, n * fact(n-1));
        }
        return mp.get(n);
    }
}
