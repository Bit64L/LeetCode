import common.UnionFindSet;

public class RedundantConnection684 {
    public int[] findRedundantConnection(int[][] edges) {
        if(edges == null) return new int[0];
        UnionFindSet uf = new UnionFindSet(1000+1);
        for(int i = 0; i < edges.length; i++){
            if(!uf.union(edges[i][0], edges[i][1])){
                return edges[i];
            }
        }
        return new int[0];
    }
}
