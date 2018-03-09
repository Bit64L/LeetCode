package amazon;

import org.junit.Test;

public class NumberOfIslands_200 {

    class Solution {

        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) return 0;
            int count = 0;
            int nr = grid.length;
            int nc = grid[0].length;
            int[][] visited = new int[grid.length][grid[0].length];
            for (int i = 0; i < nr; i++) {
                for (int j = 0; j < nc; j++) {
                    if (grid[i][j] == '1' && visited[i][j] == 0) {
                        count++;
                        dfs(grid, visited, i, j);
                    }

                }
            }
            return count;
        }

        public void dfs(char[][] grid, int[][] visited, int i, int j) {

            if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] == '0' || visited[i][j] == 1)
                return;
            visited[i][j] = 1;
            dfs(grid, visited, i - 1, j);
            dfs(grid, visited, i + 1, j);
            dfs(grid, visited, i, j - 1);
            dfs(grid, visited, i, j + 1);
        }
    }

    @Test
    public void test() {
        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        Solution solution = new Solution();
        System.out.println(solution.numIslands(grid));
    }
}
