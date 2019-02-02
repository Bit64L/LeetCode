import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MinimumHeightTrees310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1){
            List<Integer> res = (new ArrayList<>());
            res.add(n-1);
            return res;
        }
        List<List<Integer>> g = new ArrayList<>();
        for(int i = 0; i < n; i++) g.add(new LinkedList<>());
        for(int i = 0; i < edges.length; i++){
            g.get(edges[i][0]).add(edges[i][1]);
            g.get(edges[i][1]).add(edges[i][0]);
        }

        List<Integer> leaves = new LinkedList<>();
        for(int i = 0; i < n; i++)
            if(g.get(i).size() == 1) leaves.add(i);
        while(n > 2){
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(Integer leaf : leaves){
                int j = g.get(leaf).iterator().next();
                g.get(j).remove(leaf);
                if(g.get(j).size() == 1) newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        return leaves;

    }
}

/*
Solution: 以树中间的结点为root，获得的树的高度最短，可能有一个可能有两个。

思考：当图可以伸展成一条直线的时候，从两边一起往中间走，当他们相遇或者超过一步时，得到的树是最短的。
延伸：从两边的叶子结点往中间靠拢，当图中结点剩余两个或一个时，则以它们为根节点所得到的树最短
 */
