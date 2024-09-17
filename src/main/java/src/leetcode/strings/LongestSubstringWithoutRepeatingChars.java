package src.leetcode.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChars {
    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingChars().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new LongestSubstringWithoutRepeatingChars().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new LongestSubstringWithoutRepeatingChars().lengthOfLongestSubstring("bbbbbb"));
        System.out.println(new LongestSubstringWithoutRepeatingChars().lengthOfLongestSubstring("cdd"));
        System.out.println(new LongestSubstringWithoutRepeatingChars().lengthOfLongestSubstring("abba"));
    }

    public int lengthOfLongestSubstring(String s) {
        int maxAns = 0;
        Map<Character, Integer> mp = new HashMap<>();
        for (int i=0, ans = 0; i<s.length(); i++) {
            if (mp.containsKey(s.charAt(i))) {
                ans = Math.max(mp.get(s.charAt(i)) + 1, ans);
            }
            maxAns = Math.max(maxAns, i - ans + 1);
            mp.put(s.charAt(i), i);
        }
        return maxAns;
    }
}
