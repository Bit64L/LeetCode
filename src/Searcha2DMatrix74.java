import org.junit.Test;

public class Searcha2DMatrix74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        int m = matrix.length, n = matrix[0].length;
        int lo = 0, hi = m * n - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int i = mid / n, j = mid % n;
            if (matrix[i][j] == target)
                return true;
            else if (matrix[i][j] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return false;
    }

    @Test
    public void test() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(searchMatrix(matrix,6));
    }
}
