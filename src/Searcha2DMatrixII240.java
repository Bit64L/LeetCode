import org.junit.Test;

public class Searcha2DMatrixII240 {
    // 初始位置位于右上角，根据matrix[i][j]和target的大小逐步逼近target
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int m = matrix.length, n = matrix[0].length, i = 0, j = n - 1;
        while (i < m && j >= n) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    @Test
    public void test() {
        int[][] arr = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(searchMatrix(arr, 20));

    }

    //二分搜索 while(lo<hi)要搞明白

}
