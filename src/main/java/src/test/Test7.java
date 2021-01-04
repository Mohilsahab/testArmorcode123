package src.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test7 {
//    Given a DNA sequence consisting of 0 and 1 , give the max number of consecutive 1s in sequence
//    i/p : [1,1,0,1,1,1]
//    o/p : 3

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,1,0,1,1,1);
        int count = 0;
        int maxCount = 0;
        for (Integer n : list) {
            if (n==1) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;
            }
        }
        System.out.println(maxCount);
    }
}
