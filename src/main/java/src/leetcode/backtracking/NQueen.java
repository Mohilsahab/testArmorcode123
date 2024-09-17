package src.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    public static void main(String[] args) {
        List<List<String>> list = new NQueen().solveNQueens(4);
        System.out.println(list);
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean [][] queenPlaced = new boolean[n][n];
        solveNQueens(result, queenPlaced, n, 0);
        return result;
    }

    private void solveNQueens(List<List<String>> result, boolean [][] queenPlaced, int n, int currRow) {
        if (currRow == n) {
            List<String> tempList = getTempList(queenPlaced, n);
            result.add(tempList);
            return;
        }
        for (int i=0; i<n; i++) {
            if (isValidPlacement(queenPlaced, currRow, i, n)) {
                queenPlaced[currRow][i] = true;
                solveNQueens(result, queenPlaced, n, currRow+1);
                queenPlaced[currRow][i] = false;
            }
        }
    }

    private List<String> getTempList(boolean[][] queenPlaced, int n) {
        List<String> tempList = new ArrayList<>();
        for (int i = 0; i< n; i++) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j< n; j++) {
                if (queenPlaced[i][j]) {
                    str.append("Q");
                } else {
                    str.append(".");
                }
            }
            tempList.add(str.toString());
        }
        return tempList;
    }

    private boolean isValidPlacement(boolean[][] queenPlaced, int currRow, int currCol, int n) {
        int colNo[] = new int[2];
        colNo[0] = currCol-1;
        colNo[1] = currCol+1;
        for (int i = currRow-1; i>=0; i--) {
            if ((colNo[0]>=0 && queenPlaced[i][colNo[0]])
                || (colNo[1]<n && queenPlaced[i][colNo[1]])
                || queenPlaced[i][currCol]) {
                return false;
            }
            colNo[0]--;
            colNo[1]++;
        }
        return true;
    }
}