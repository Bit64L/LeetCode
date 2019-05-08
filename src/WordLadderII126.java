import org.junit.Test;

import java.util.*;

public class WordLadderII126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String s : wordList) set.add(s);

        Deque<String> q = new ArrayDeque<>();
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, Integer> steps = new HashMap<>();

        graph.put(beginWord, new HashSet<>());
        steps.put(beginWord, 0);
        boolean found = false;
        q.offer(beginWord);
        int step = 0;
        while(!q.isEmpty() && !found){
            ++step;
            for(int k = q.size(); k > 0; k--){
                String parent = q.poll();
                for(int i = 0; i < parent.length(); i++){
                    StringBuilder sb = new StringBuilder(parent);
                    for(int j = 'a'; j <='z'; j++){
                        sb.setCharAt(i, (char)j);
                        String s = sb.toString();
                        if(s.equals(parent)) continue;
                        if(set.contains(s)){
                            if(steps.containsKey(s) && steps.get(s) != step) continue;
                            if(s.equals(endWord)){
                                found = true;
                            }
                            if(!graph.containsKey(s)) graph.put(s, new HashSet<>());
                            graph.get(parent).add(s);
                            steps.put(s, step);
                            q.offer(s);
                        }
                    }
                }
            }
        }
        List<List<String>> res = new LinkedList<>();
        List<String> path = new LinkedList<>();
        path.add(beginWord);
        dfs(graph, res, path, beginWord, endWord);
        return res;
    }

    public void dfs(Map<String, Set<String>> graph, List<List<String>> res, List<String> path, String word, String endWord){
        if(word.equals(endWord)){
            res.add(new LinkedList<>(path));
            return;
        }
        if(graph.get(word) == null) return;
        for(String child : graph.get(word)){
            path.add(child);
            dfs(graph, res, path, child, endWord);
            path.remove(path.size() - 1);
        }

    }

    @Test
    public void test(){
        List<String> list = new LinkedList<String>(){
            {
                add("ted");
                add("tex");
                add("tax");
                add("tad");
                add("den");
                add("rex");
                add("pee");

            }

        };

        findLadders("red",
                "tax",
                list);
    }

}
