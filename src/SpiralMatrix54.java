import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix54 {
    public List<Integer> spiralOrder1(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new LinkedList<>();
        }
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0;
        List<Integer> list = new LinkedList<>();
        int index = 0, attempt=0;
        while (true) {
            list.add(matrix[x][y]);
            matrix[x][y] = 1 << 31;
            attempt = 0;
            while (attempt!=4) {
                int xx = x + dir[index % 4][0];
                int yy = y + dir[index % 4][1];
                if (xx >= 0 && xx < matrix.length && yy < matrix[0].length && yy >= 0 && matrix[xx][yy] != 1 << 31) {
                    x = xx;
                    y = yy;
                    break;
                } else {
                    index++;
                    attempt++;
                }
            }
            if(attempt == 4)
                break;

        }
        return list;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return new ArrayList<>();
        int row = matrix.length, col = matrix[0].length;
        int m = 0, n = -1;
        List<Integer> res = new ArrayList<>();
        while(true){
            for(int i = 0; i < col; i++){
                res.add(matrix[m][++n]);
            }
            row--;
            if(row == 0) break;
            for(int i = 0; i < row; i++){
                res.add(matrix[++m][n]);
            }
            col--;
            if(col == 0) break;
            for(int i = 0; i < col; i++){
                res.add(matrix[m][--n]);
            }
            row--;
            if(row == 0) break;
            for(int i = 0; i < row; i++){
                res.add(matrix[--m][n]);
            }
            col--;
            if(col == 0) break;
        }
        return res;
    }
}
