package src.leetcode.dp;

public class EditDistance {
    public static void main(String[] args) {
        System.out.println(new EditDistance().minDistance("horse", "ros"));//3
    }

    int dp[][];
    public int minDistance(String word1, String word2) {
        this.dp = new int[word1.length()+1][word2.length()+1];
        return editDistance(word1, word1.length(), word2, word2.length());
    }

    private int editDistance(String word1, int i, String word2, int j) {
        if (i<=0) {
            return j;
        }
        if (j<=0) {
            return i;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        if (word1.charAt(i-1) == word2.charAt(j-1)) {
            dp[i][j] = editDistance(word1, i-1, word2, j-1);
            return dp[i][j];
        }
        dp[i][j] = 1+ Math.min(editDistance(word1, i-1, word2, j-1),
                            Math.min(editDistance(word1, i-1, word2, j), editDistance(word1, i, word2, j-1)));
        return dp[i][j];
    }
}
