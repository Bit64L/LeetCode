package amazon;

import org.junit.Test;

public class RotateImage_48 {
    class Solution {
        public void rotate(int[][] matrix) {
            if (matrix == null || matrix.length == 0) return;
            int layers = matrix.length / 2;
            for (int i = 0; i < layers; i++)
                layerRotate(matrix, i, matrix.length - 1 - i, i);

        }

        public void layerRotate(int[][] matrix, int p, int q, int layer) {
            int n = matrix.length;
            for (int i = p; i < q; i++) {
                int row = layer;
                int col = i;
                int next = matrix[col][n - 1 - row];
                int last = matrix[row][col];
                int temp;
                for (int j = 0; j < 4; j++) {
                    matrix[col][n - 1 - row] = last;
                    last = next;
                    temp = row;
                    row = col;
                    col = n - 1 - temp;
                    next = matrix[col][n - 1 - row];
                }
            }
        }
    }


    @Test
    public void test() {
        Solution solution = new Solution();
        int[][] matrix =
                {{5, 1, 9, 11},
                        {2, 4, 8, 10},
                        {13, 3, 6, 7},
                        {15, 14, 12, 16}};
//        int[][] matrix = {
//                {1,2,3},{4,5,6},{7,8,9}
//        };
        solution.rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println();
        }

    }
}
