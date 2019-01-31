import java.util.ArrayDeque;
import java.util.Deque;

public class IsGraphBipartite785 {
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];// 0 not visited, 1 red, 2 blue

        for(int i = 0; i < graph.length; i++){ // process multi connected component
            if(visited[i] == 0){
                Deque<Integer> q = new ArrayDeque<>();
                q.offer(i);
                visited[i] = 1;
                while(!q.isEmpty()){
                    Integer node = q.poll();
                    for(int j = 0; j < graph[node].length; j++){
                        if(visited[graph[node][j]] == 0){
                            q.offer(graph[node][j]);
                            visited[graph[node][j]] = visited[node] == 1 ? 2 : 1;
                        }else{
                            if(visited[graph[node][j]] == visited[node]) return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
