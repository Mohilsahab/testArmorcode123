package src.test;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class TestAcko2 {
//    Given the string, if you are allowed to replace no more than k letters with any letter.
//    Find the length of the longest substring having the same letters after replacement.
//    string = “aabcccbbbb”
//    aabcbbbbb
//    k = 2
//    output= 5

    public static void main(String[] args) {
        String input = "a";
        int k = 2;
        int res = getLongestSubstring(input, k);
        System.out.println(res);
    }

    private static int getLongestSubstring(String input, int k) {
        //    input = “aabcccbbbb”
        if (StringUtils.isNotBlank(input)) {
            return 0;
        }
        int count = 1;
        int maxCount = 1;
        boolean visited[] = new boolean[input.length()];
        Arrays.fill(visited, false); // n*k //n+k~n
        for (int i=0; i<input.length()-1; i++) {
            if (visited[i] == true) {
                continue;
            }
            visited[i] = true;
            if (input.charAt(i) == input.charAt(i+1)) {
                count ++;
                if (count > maxCount) {
                    maxCount = count;
                }
            } else {
                count+=k;
                if (i+k+1 < input.length() && input.charAt(i) == input.charAt(i+k+1)) {
                    int tempIndex = i+k+1;
                    while (tempIndex<input.length() && input.charAt(i) == input.charAt(tempIndex)) {
                        visited[i] = true;
                        count++;
                        tempIndex++;
                    }
                }
                if (count > maxCount) {
                    maxCount = count;
                }
                count = 1;
            }
        }
        return maxCount;
    }
}
