import java.util.HashMap;
import java.util.HashSet;

public class EvaluateDivision399 {
    HashMap<String, HashMap<String, Double>> g = new HashMap<>();
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

        for(int i = 0; i < equations.length; i++){// generate digraph
            String x = equations[i][0];
            String y = equations[i][1];
            Double k = values[i];

            if(!g.containsKey(x)){
                HashMap<String, Double> submap = new HashMap<>();
                submap.put(y, k);
                g.put(x, submap);
            }else{
                g.get(x).put(y,k);
            }

            if(!g.containsKey(y)){
                HashMap<String, Double> submap = new HashMap<>();
                submap.put(x, 1.0/k);
                g.put(y, submap);
            }else{
                g.get(y).put(x,1.0/k);
            }
// lambda表达式效率很低
//            g.computeIfAbsent(x, l -> new HashMap<String, Double>()).put(y, k);
//            g.computeIfAbsent(y, l -> new HashMap<String, Double>()).put(x, 1.0/k);
        }
        double[] res = new double[queries.length];
        for(int i = 0; i < queries.length; i++){
            if(!g.containsKey(queries[i][0]) || !g.containsKey(queries[i][1])){
                res[i] = -1;
            }else{
                res[i] = divide(queries[i][0], queries[i][1], new HashSet<String>());
            }
        }
        return res;

    }
    public double divide(String x, String y, HashSet<String> visited){
        if(x.equals(y)) return 1;
        if(g.get(x).containsKey(y)) return g.get(x).get(y);

        visited.add(x);
        for(String neighbor : g.get(x).keySet()){
            if(!visited.contains(neighbor)){
                double d = divide(neighbor, y, visited);
                if(d == -1) continue;
                return d * g.get(x).get(neighbor);
            }
        }
        return -1;
    }



}


/*
本题掌握点：
1. 将问题转化为关于图的问题
2. 加权有向图的表示
3. 图的DFS
 */