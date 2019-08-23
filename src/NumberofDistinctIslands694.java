import java.util.HashSet;
import java.util.Set;

public class NumberofDistinctIslands694 {
    private static final String sign = "x";

    public int numDistinctIslands(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        Set<String> set = new HashSet<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb);
                    set.add(sb.toString());
                }
            }
        }
        return set.size();

    }

    public void dfs(int[][] grid, int x, int y, StringBuilder sb){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1){
            sb.append(sign);
            return;
        }

        sb.append(grid[x][y]);
        grid[x][y] = 0;
        dfs(grid, x, y + 1, sb);
        dfs(grid, x + 1, y, sb);
        dfs(grid, x, y - 1, sb);
        dfs(grid, x - 1, y, sb);
    }
}
