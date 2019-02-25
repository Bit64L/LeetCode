import java.util.*;

public class TopKFrequentWords692 {
    public List<String> topKFrequent(String[] words, int k) {
        if(words == null || words.length == 0) return new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>(){
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2){
                if(e1.getValue().equals(e2.getValue()))
                    return e2.getKey().compareTo(e1.getKey());
                return e1.getValue() - e2.getValue();
            }
        });

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            pq.add(entry);
            if(pq.size() > k){
                pq.poll();
            }
        }
        List<String> res = new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(0,pq.poll().getKey());
        }
        return res;
    }
}
/*
基本思路已经比较熟练，但是数据结构的使用上仍需多加练习
注意点：
1. pq的二次排序(value相等时key的排序)
2.
 if(pq.size() > k){
                pq.poll();
            }当k == 1时，从在多个相同频率的单词要正确选择。
 */