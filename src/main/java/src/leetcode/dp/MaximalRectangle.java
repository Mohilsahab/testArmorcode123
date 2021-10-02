package src.leetcode.dp;

import src.leetcode.stack.LargestRectangleInHistogram;

public class MaximalRectangle {
    public static void main(String[] args) {
        char[][] matrix = /*{
                {'0', '1', '1', '0'},
                {'1', '1', '1', '1'},
                {'1', '1', '1', '1'},
                {'1', '1', '0', '0'}
        };*/
         {};
        System.out.println(new MaximalRectangle().maximalRectangle(matrix));
    }

    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if (row == 0 || matrix[0] == null) {
            return 0;
        }
        int col = matrix[0].length;

        int res[][] = new int[row][col];
        for (int j=0; j < col; j++) {
            res[0][j] = matrix[0][j] == '1' ? 1 : 0;
        }

        for (int i=1;i<row; i++) {
            for (int j=0; j<col; j++) {
                if (matrix[i][j]=='1') {
                    if (matrix[i-1][j]=='1') {
                        res[i][j] = res[i-1][j]+1;
                    } else {
                        res[i][j]=1;
                    }
                }
            }
        }

//        for (int i=0;i<row; i++) {
//            for (int j=0; j<col; j++) {
//                System.out.print(res[i][j] + " ");
//            }
//            System.out.println();
//        }

        int max = 0;
        for (int i=0; i<row; i++) {
            max = Math.max(max, computeHistogramArea(res[i]));
        }
        return max;
    }

    private int computeHistogramArea(int[] res) {
        return new LargestRectangleInHistogram().largestRectangleArea(res);
    }
}
