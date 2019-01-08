package common;

public class UnionFindSet{
    int[] parent;
    int[] rank;

    public UnionFindSet(int n){
        parent = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;
        rank = new int[n];
    }

    public int find(int x){ // Path Compression
        if (x != parent[x]){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int x, int y){// Weighted
        int xr = find(x); int yr = find(y);
        if(xr == yr) return false;
        if(rank[xr] == rank[yr]){
            parent[yr] = xr;
            rank[xr]++;
        }else if(rank[xr] > rank[yr])
            parent[yr] = xr;
        else
            parent[xr] = yr;
        return true;
    }
}