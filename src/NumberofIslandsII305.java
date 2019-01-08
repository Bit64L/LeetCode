import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class NumberofIslandsII305 {
    int count = 0;
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        if(positions == null || positions.length == 0) return new ArrayList<>();
        int[][] matrix = new int[m][n];
        List<Integer> res = new ArrayList<>();
        int[][] direc = {{0,1}, {0, -1}, {-1, 0}, {1, 0}};
        int[] parent = new int[m*n]; int[] rank = new int[m*n];
        for(int i = 0; i < parent.length; i++) parent[i] = i;
        for(int i = 0; i < positions.length; i++){
            int x = positions[i][0]; int y = positions[i][1];
            matrix[x][y] = 1;
            count++;
            for(int j = 0; j < direc.length; j++){
                int neighbor_x = x + direc[j][0];
                int neighbor_y = y + direc[j][1];
                if(neighbor_x < 0 || neighbor_x >= m
                        || neighbor_y < 0 || neighbor_y >=n)
                    continue;
                if(matrix[neighbor_x][neighbor_y] == 1){
                    union(parent, rank, x*n + y, neighbor_x*n + neighbor_y);
                }
            }
            res.add(count);
        }
        return res;
    }

    public void union(int[] parent, int[] rank, int x, int y){
        int xr = find(parent, x); int yr = find(parent, y);
        if(xr != yr){
            if(rank[xr] == rank[yr]){
                parent[yr] = xr;
                rank[xr]++;
            }else if(rank[xr] > rank[yr]){
                parent[yr] = xr;
            }else{
                parent[xr] = yr;
            }
            --count;
        }

    }

    public int find(int[] parent, int x){
        if(parent[x] != x){
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    @Test
    public void test(){
        int[][] arr  = {{0,0},{0,1},{1,2},{2,1}};
        numIslands2(3,3 , arr);
    }
}
