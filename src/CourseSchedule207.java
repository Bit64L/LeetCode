import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CourseSchedule207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] mark = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) graph.add(new LinkedList<>());
        for(int i = 0; i < prerequisites.length; i++){
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }// initialize the graph

        for(int i = 0; i < numCourses; i++){
            if(mark[i] == 0){
                if(dfs(i, graph, mark)) // true means there exists a cycle
                    return false;
            }
        }
        return true;
    }

    public boolean dfs(int i, List<List<Integer>> graph, int[] mark){
        if(mark[i] == 2) return false; // 2 means finish visit
        if(mark[i] == 1) return true; // 1 means has visited but not finish

        mark[i] = 1;
        for(int j : graph.get(i)){
            if(dfs(j, graph, mark)) return true;
        }
        mark[i] = 2;
        return false;
    }
}

/*
Toplogical Sort
Find if there is a cycle in directed graph
 */
