import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CourseScheduleII210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        if(prerequisites == null || prerequisites.length == 0){
            for(int i = 0; i < numCourses; i++)
                res[i] = i;
            return res;
        }
        Stack<Integer> stack = new Stack<>();
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length; i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(visited[i] == 0){
                if(dfs(i, graph, visited, stack))
                    return new int[0];
            }
        }

        for(int i = 0; i < numCourses; i++){
            res[i] = stack.pop();
        }
        return res;
    }
    public boolean dfs(int i, List<List<Integer>> graph, int[] visited, Stack<Integer> stack){
        if(visited[i] == 1) return true;
        if(visited[i] == 2) return false;

        visited[i] = 1;
        for(Integer j : graph.get(i)){
            if(dfs(j, graph, visited, stack)){
                return true;
            }
        }
        visited[i] = 2;
        stack.push(i);
        return false;
    }
}
