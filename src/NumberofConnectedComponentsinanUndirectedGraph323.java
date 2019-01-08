import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NumberofConnectedComponentsinanUndirectedGraph323 {
    public int countComponents(int n, int[][] edges) {
        if(edges == null || edges.length == 0) return n;
        int[] parent = new int[n];
        int[] rank = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;
        for(int i = 0; i < edges.length; i++){
            union(parent, rank, edges[i][0], edges[i][1]);
        }
        int res = 0;
        for(int i = 0; i < n; i++)
            if(parent[i] == i) res++;
        return res;
    }

    public void union(int[] parent, int[] rank, int x , int y){
        int xr = find(parent, x); int yr = find(parent, y);
        if(rank[xr] == rank[yr]){
            parent[yr] = xr;
            rank[xr]++;
        }else if(rank[xr] > rank[yr]){
            parent[yr] = xr;
        }else{
            parent[xr] = yr;
        }
    }

    public int find(int[] parent, int x){
        if(parent[x] != x){
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }


    public int countComponents1(int n, int[][] edges) {
        if(edges == null || edges.length == 0) return n;
        List<List<Integer>> g = new ArrayList<>();
        for(int i = 0; i < n; i++) g.add(new ArrayList<>());
        for(int i = 0; i < edges.length; i++){
            g.get(edges[i][0]).add(edges[i][1]);
            g.get(edges[i][1]).add(edges[i][0]);
        }

        int res = 0; int[] visited = new int[n];
        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                res++;
                dfs(visited, i, g);
            }
        }
        return res;
    }

    public void dfs(int[] visited, int v, List<List<Integer>> g){
        if(visited[v] == 1) return;

        visited[v] = 1;
        for(Integer neighbor : g.get(v)){
            dfs(visited, neighbor, g);
        }
    }


    public int countComponents2(int n, int[][] edges) {
        if(edges == null || edges.length == 0) return n;
        List<List<Integer>> g = new ArrayList<>();
        for(int i = 0; i < n; i++) g.add(new ArrayList<>());
        for(int i = 0; i < edges.length; i++){
            g.get(edges[i][0]).add(edges[i][1]);
            g.get(edges[i][1]).add(edges[i][0]);
        }

        int res = 0; int[] visited = new int[n];
        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                res++;
                bfs(visited, i, g);
            }
        }
        return res;
    }

    public void bfs(int[] visited, int v, List<List<Integer>> g){
        Deque<Integer> q = new ArrayDeque<>();
        q.add(v);
        visited[v] = 1;
        while(!q.isEmpty()){
            int x = q.poll();
            for(int neighbor : g.get(x)){
                if(visited[neighbor] == 0){
                    visited[neighbor] = 1;
                    q.offer(neighbor);
                }
            }
        }
    }
}
