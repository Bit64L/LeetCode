import java.util.ArrayDeque;
import java.util.Deque;

public class NumberofIslands200 {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int res = 0;
        Deque<Integer> q = new ArrayDeque<>();
        int row = grid.length, col = grid[0].length;
        for(int i = 0;i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    res++;
                    q.offer(i*col + j);
                    while(!q.isEmpty()){
                        int num = q.poll();
                        int r = num / col, c = num % col;
                        grid[r][c] = '0';
                        if(r - 1 >= 0 && grid[r-1][c] == '1')
                            q.offer((r-1) * col + c);
                        if(r + 1 < row && grid[r+1][c] == '1')
                            q.offer((r+1) * col + c);
                        if(c+1 < col && grid[r][c+1] == '1')
                            q.offer(r*col + c+1);
                        if(c-1 >= 0 && grid[r][c-1] == '1')
                            q.offer(r*col + c - 1);
                    }
                }
            }
        }
        return res;
    }

    public int numIslands1(char[][] grid) { // 递归做法
        if(grid == null || grid.length == 0) return 0;
        int res = 0;
        for(int i = 0;i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1'){
                    res++;
                    zeroDfs(grid, i, j);
                }
            }
        }
        return res;
    }

    public void zeroDfs(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length
                || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        zeroDfs(grid, i, j + 1);
        zeroDfs(grid, i + 1, j);
        zeroDfs(grid, i, j - 1);
        zeroDfs(grid, i - 1, j);
    }
}
