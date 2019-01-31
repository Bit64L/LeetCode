import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PossibleBipartition886 {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        if(dislikes == null || dislikes.length == 0) return true;
        List<Integer>[] g = new ArrayList[N]; // 用桶的数据结构表示图(邻接表)
        for(int i = 0; i < g.length; i++) g[i] = new ArrayList<>(); // 初始化数组
        for(int i = 0; i < dislikes.length; i++){ // 根据边构建图
            g[dislikes[i][0] - 1].add(dislikes[i][1] - 1);
            g[dislikes[i][1] - 1].add(dislikes[i][0] - 1);
        }
        int[] visited = new int[N];
        for(int i = 0; i < N; i++){ // 涂色法判断二分图
            if(visited[i] == 0){
                Deque<Integer> q = new ArrayDeque<>();
                q.offer(i);
                visited[i] = 1;
                while(!q.isEmpty()){
                    Integer node = q.poll();
                    for(Integer child : g[node]){
                        if(visited[child] == 0){
                            visited[child] = visited[node] == 1 ? 2 : 1;
                            q.offer(child);
                        }else{
                            if(visited[child] == visited[node]) return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
