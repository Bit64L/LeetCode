import java.util.*;

public class ReconstructItinerary332 {
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    public List<String> findItinerary(String[][] tickets) {
        if(tickets == null  || tickets.length == 0) return new ArrayList<>();
        for(int i = 0; i < tickets.length; i++){
            if(!map.containsKey(tickets[i][0])){
                PriorityQueue<String> pq = new PriorityQueue<>();
                pq.add(tickets[i][1]);
                map.put(tickets[i][0], pq);
            }else{
                PriorityQueue<String> pq = map.get(tickets[i][0]);
                pq.add(tickets[i][1]);
            }
        }
        List<String> res = new LinkedList<>();
        dfs("JFK",res);
        Collections.reverse(res);
        return res;
    }

    public void dfs(String start, List<String> res){
        PriorityQueue<String> pq = map.get(start);
        while(pq != null && !pq.isEmpty()){
            if(pq.isEmpty()) map.remove(start);
            dfs(pq.poll(), res);
        }
        res.add(start);
    }
}
/*
后序遍历逆转一下
 */