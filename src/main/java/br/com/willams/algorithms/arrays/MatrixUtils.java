package br.com.willams.algorithms.arrays;

public class MatrixUtils {
    static public void rotate(int[][] matrix) {
        int n = matrix.length;

        if(n <= 1) return;

        for(int i = 0; i < n / 2; i++) {
            for(int j = i; j < n - i - 1; j++) {

                // temp top-left
                int tempTopLeft = matrix[i][j];

                // top-left <- bottom-left
                matrix[i][j] = matrix[n - 1 - j][i];

                // bottom-left <- bottom-right
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                
                // bottom-right <- top-right
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];

                // top-right <- top-left
                matrix[j][n - 1 - i] = tempTopLeft;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
            {0, 10, 11, 12},
            {16, 17, 18, 19},
            {23, 24, 25, 26},
            {30, 31, 32, 33}};

        MatrixUtils.rotate(matrix);
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
