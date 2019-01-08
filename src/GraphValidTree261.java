import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GraphValidTree261 {
    public boolean validTree(int n, int[][] edges) {
        if(n == 1) return true;
        if(edges == null || edges.length == 0) return false;
        List<List<Integer>> g = new ArrayList<>();
        for(int i = 0; i < n; i++) g.add(new ArrayList<Integer>());
        for(int i = 0; i < edges.length; i++){
            g.get(edges[i][0]).add(edges[i][1]);
            g.get(edges[i][1]).add(edges[i][0]);
        }
        HashSet<Integer> visited = new HashSet<>();

        return !dfs(0, -1, visited, g) && visited.size() == n;
    }
    public boolean dfs(int v, int parent, HashSet<Integer> visited, List<List<Integer>> g){
        if(visited.contains(v)) return true;

        visited.add(v);
        for(Integer neighbor : g.get(v)){
            if(neighbor == parent) continue;
            if(dfs(neighbor, v, visited, g))
                return true;
        }
        return false;
    }



    public int find(int[] parent, int x){
        if(parent[x] != x){
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
    public boolean union(int[] parent, int x, int y){
        int xr = find(parent,x); int yr = find(parent, y);
        if(xr == yr) return false;
        parent[yr] = xr;
        return true;
    }

    public boolean validTree1(int n, int[][] edges) {
        int[] parent = new int[n];
        for(int i = 0; i < parent.length; i++) parent[i] = i;
        for(int i = 0; i < edges.length; i++){
            if(!union(parent, edges[i][0], edges[i][1]))
                return false;
        }
        return edges.length == n - 1;
    }

    @Test
    public void test(){
        int[][] arr = {{0,1}, {1,2}, {2,3}, {1,3}, {1,4}};
        validTree1(5, arr);
    }
}
