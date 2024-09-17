package src.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(result, new StringBuilder(), n, n);
        return result;
    }

    private void generateParenthesis(List<String> result, StringBuilder str, int leftBrackets, int rightBrackets) {
        if (rightBrackets == 0) {
            result.add(str.toString());
            return;
        }

        if (leftBrackets > 0) {
            str.append("(");
            generateParenthesis(result, str, leftBrackets-1, rightBrackets);
            str.deleteCharAt(str.length() - 1);
        }

        if (leftBrackets < rightBrackets) {
            str.append(")");
            generateParenthesis(result, str, leftBrackets, rightBrackets-1);
            str.deleteCharAt(str.length() - 1);
        }
    }

    /*private void generateParenthesis(List<String> result, StringBuilder str, int leftBrackets, int rightBrackets) {
        if (rightBrackets == 0) {
            result.add(str.toString());
            return;
        }
        if (leftBrackets == 0) {
            str.append(")");
            generateParenthesis(result, str, leftBrackets, rightBrackets-1);
            str.deleteCharAt(str.length() - 1);
            return;
        }

        str.append("(");
        generateParenthesis(result, str, leftBrackets-1, rightBrackets);
        str.deleteCharAt(str.length() - 1);

        if (leftBrackets < rightBrackets) {
            str.append(")");
            generateParenthesis(result, str, leftBrackets, rightBrackets-1);
            str.deleteCharAt(str.length() - 1);

        }
    }*/
}
