package src.leetcode.strings;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public static void main(String[] args) {
        System.out.println(new PartitionLabels().partitionLabels("ababcbacadefegdehijhklij"));//9,7,8
        System.out.println(new PartitionLabels().partitionLabels("eccbbbbdec"));//10
    }


    public List<Integer> partitionLabels(String s) {
        int lastIndex[] = new int[26];
        for (int i=0; i<s.length(); i++) {
            lastIndex[s.charAt(i)-'a'] = i;
        }

        List<Integer> ans = new ArrayList<>();
        int j=0, partitionIndex = 0;
        for (int i=0; i<s.length(); i++) {
            j = Math.max(j, lastIndex[s.charAt(i)-'a']);
            if (i==j) {
                ans.add(i-partitionIndex+1);
                partitionIndex = i+1;
            }
        }
        return ans;
    }
}
