import org.junit.Test;

import java.util.*;

public class TaskScheduler621 {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2){
                return i2 - i1;
            }
        });

        Map<Character, Integer> taskToCount = new HashMap<>();
        for(Character c : tasks){
            taskToCount.put(c, taskToCount.getOrDefault(c, 0) + 1);
        }
        for(Map.Entry<Character, Integer> entry : taskToCount.entrySet()){
            q.offer(taskToCount.get(entry.getKey()));
        }

        int currTime = 0;
        while(!q.isEmpty()){
            List<Integer> tmp = new LinkedList<>();
            for(int i = 0; i < n + 1; i++){
                if(!q.isEmpty()){
                    Integer count = q.poll();
                    if(count > 1){
                        tmp.add(count - 1);
                    }
                }
                currTime++;
                if(q.isEmpty() && tmp.isEmpty()){
                    break;
                }
            }
            for(Integer i : tmp)
                q.offer(i);
        }
        return currTime;
    }

    @Test
    public void test(){
        char[] arr = {'A','A','A','A','A','A','B','C','D','E','F','G'};
//        char[] arr = {'A','A','A','B','B','B'};
        System.out.println(leastInterval(arr,2));
    }
}

//
//贪心策略：Highest Frequency First
//Solution:
//1. 优先级队列q保存各字符频数
//2. 在n+1的时间内轮流出队，时间不足者用idle不全
//3. 直至所有频数都减为0