package src.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {
    public static void main(String[] args) {
        List<String> list = new LetterCombination().letterCombinations("");//"23", "", "2"
        System.out.println(list);
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits== null || digits.length()==0) {
            return result;
        }
        dfs(result, new StringBuilder(),0, digits);
        return result;
    }

    private void dfs(List<String> result, StringBuilder str, int index, String digits) {
        if (index == digits.length()) {
            result.add(str.toString());
            return;
        }
        String letters = getLettersOfNo(digits.charAt(index));
        for (int i=0; i<letters.length(); i++) {
            str.append(letters.charAt(i));
            dfs(result, str, index + 1, digits);
            str.deleteCharAt(str.length() - 1);
        }
    }


    private String getLettersOfNo(char ch) {
        switch (ch) {
            case '2' : return "abc";
            case '3' : return "def";
            case '4' : return "ghi";
            case '5' : return "jkl";
            case '6' : return "mno";
            case '7' : return "pqrs";
            case '8' : return "tuv";
            default  : return "wxyz";
        }
    }
}
