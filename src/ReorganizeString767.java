import org.junit.Test;

import java.util.*;

public class ReorganizeString767 {
    public String reorganizeString(String S) {
        Map<Character, Integer> map = new HashMap<>();
        for(Character c : S.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<int[]> q =
                new PriorityQueue<>(new Comparator<int[]>(){
                    public int compare(int[] i1, int[] i2){
                        return i2[1] - i1[1];
                    }
                });

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            q.offer(new int[]{entry.getKey(), entry.getValue()});
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            List<int[]> list = new ArrayList<>();
            for(int i = 0; i < 2; i++){
                if(list.isEmpty() && q.size() == 1 && q.peek()[1] > 1) return "";
                if(q.isEmpty() && list.isEmpty()) break; // last round, index may exceed bound
                int[] pair = q.poll();
                if(pair[1] > 1){
                    pair[1]--;
                    list.add(pair);
                }
                sb.append((char)pair[0]);
            }
            for(int[] i : list)
                q.offer(i);
        }
        return sb.toString();
    }

    @Test
    public void test(){
        System.out.println(reorganizeString("baaba"));
    }
}

/*
思路类似621 Task Scheduler  在k = 1的情况
 */