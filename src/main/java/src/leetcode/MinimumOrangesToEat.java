package src.leetcode;

import java.util.*;

public class MinimumOrangesToEat {
    public static void main(String[] args) {
        MinimumOrangesToEat minimumOrangesToEat = new MinimumOrangesToEat();
        int res1 = minimumOrangesToEat.minDays(0);//0->0, 1->1, 2->2,  3->2,6->3,10->4,56->6
        int res2 = minimumOrangesToEat.minDays(1);
        int res3 = minimumOrangesToEat.minDays(2);
        int res4 = minimumOrangesToEat.minDays(3);
        int res5 = minimumOrangesToEat.minDays(6);
        int res6 = minimumOrangesToEat.minDays(10);
        int res7 = minimumOrangesToEat.minDays(56);
        int res8 = minimumOrangesToEat.minDays(9209408);
//        int res8 = minimumOrangesToEat.minDaysWithRec(9209408);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);
        System.out.println(res5);
        System.out.println(res6);
        System.out.println(res7);
        System.out.println(res8);
    }

    public int minDays(int n) {
        if (n<=0) {
            return 0;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        int c = Integer.MAX_VALUE;
        int count = 0;
        Set<Integer> set = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i=0; i<size; i++) {
                int temp = (int) queue.poll();
                a = temp - 1;
                queue.add(a);
                if (temp%2 == 0 && set.add(temp/2)) {
                    b= temp/2;
                    queue.add(b);
                }
                if (temp%3 == 0 && set.add(temp/3)) {
                    c = temp/3;
                    queue.add(c);
                }
                if(a == 0 || b == 0 || c == 0) {
                    return count;
                }
            }
        }
        return count;
    }

    public int minDaysWithRec(int n) {
        return minDaysWithRec(new HashMap<Integer, Integer>(), n);
    }

    private int minDaysWithRec(Map<Integer, Integer> mp, int n) {
        if (n <= 1) {
            return n;
        }

        if (mp.containsKey(n)) {
            return mp.get(n);
        }
        if (n%3==0 && n%2==0) {
            mp.put(n, 1 + Math.min(minDaysWithRec(mp, n-1), Math.min(minDaysWithRec(mp, n/2), minDaysWithRec(mp, n/3))));
        }  else if (n%2 == 0) {
            mp.put(n, 1 + Math.min(minDaysWithRec(mp, n-1), minDaysWithRec(mp, n/2)));
        } else if (n%3 == 0) {
            mp.put(n, 1 + Math.min(minDaysWithRec(mp, n-1), minDaysWithRec(mp, n/3)));
        } else {
            mp.put(n, 1 + minDaysWithRec(mp, n-1));
        }
        return mp.get(n);
    }
}
