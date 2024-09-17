package src.leetcode;

public class RotateImage {
    public static void main(String[] args) {
        int matrix[][] = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        }; // [[7,4,1],[8,5,2],[9,6,3]]
//        int matrix[][] = {
//                {5,1,9,11},
//                {2,4,8,10},
//                {13,3,6,7},
//                {15,14,12,16}
//        }; // [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
        new RotateImage().rotate(matrix);
        for (int i=0;i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        for (int i=0; i<(rows+1)/2; i++) {
            for (int j=0; j<columns/2; j++) {
                int temp = matrix[j][columns-1-i];

                matrix[j][columns-1-i] = matrix[i][j];
                matrix[i][j] = matrix[rows-1-j][i];
                matrix[rows-1-j][i] = matrix[rows-1-i][columns-1-j];
                matrix[rows-1-i][columns-1-j] = temp;
            }
        }
    }
}
