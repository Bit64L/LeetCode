import common.UndirectedGraphNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class CloneGraph133 {
    HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return helper(node);
    }
    public UndirectedGraphNode helper(UndirectedGraphNode node){
        if(node == null) return null;
        if(map.containsKey(node)) return map.get(node);

        UndirectedGraphNode dup = new UndirectedGraphNode(node.label);
        map.put(node, dup);
        for(UndirectedGraphNode neighbor : node.neighbors){
            UndirectedGraphNode clone = helper(neighbor);
            dup.neighbors.add(clone);
        }
        return dup;
    }

    public UndirectedGraphNode cloneGraph1(UndirectedGraphNode node) {
        if(node == null) return null;
        Deque<UndirectedGraphNode> q = new ArrayDeque<>();
        q.offer(node);
        map.put(node, new UndirectedGraphNode(node.label));
        while(!q.isEmpty()){
            UndirectedGraphNode tmp = q.poll();
            for(UndirectedGraphNode neighbor : tmp.neighbors){
                if(!map.containsKey(neighbor)){
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    q.offer(neighbor);
                }
                map.get(tmp).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}
