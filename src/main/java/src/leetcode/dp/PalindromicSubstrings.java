package src.leetcode.dp;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        System.out.println(new PalindromicSubstrings().countSubstrings("aaa"));
        System.out.println(new PalindromicSubstrings().countSubstrings("a"));
    }

    public int countSubstrings(String s) {
        if (s==null) return 0;
        int count = 0;
        for (int i=0; i<s.length(); i++) {
            count += expandFromMiddle(s, i, i);
            count += expandFromMiddle(s, i, i+1);
        }
        return count;
    }

    private int expandFromMiddle(String s, int start, int end) {
        int count = 0;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            count++;
            start--;
            end++;
        }
        return count;
    }
}
