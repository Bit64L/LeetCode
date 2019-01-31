import java.util.*;

public class TopKFrequentElements347 {
    public List<Integer> topKFrequent(int[] nums, int k) {// 统计频率 + 优先级队列
        if (nums == null || nums.length == 0) return null;
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                return a.getValue() - b.getValue();
            }
        });
        for (Map.Entry e : map.entrySet()) {
            pq.offer(e);
            if (pq.size() > k) pq.poll();
        }
        for (int i = 0; i < k; i++) {
            res.add(pq.poll().getKey());
        }
        return res;
    }

    public List<Integer> topKFrequent1(int[] nums, int k) {// 桶排序，数组下标作为频率，拉链表示相同频率的元素
        if(nums == null || nums.length == 0) return null;
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) map.put(num, map.getOrDefault(num, 0)+1);
        List<Integer>[] bucket = new List[nums.length + 1]; // 泛型数组
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            if(bucket[e.getValue()] == null) bucket[e.getValue()] = new ArrayList<>();
            bucket[e.getValue()].add(e.getKey());
        }
        for(int i = nums.length; i >= 0; i--){
            if(bucket[i] == null) continue;
            for(int j = 0; j < bucket[i].size() && k > 0; j++){
                res.add(bucket[i].get(j));
                k--;
            }
        }
        return res;
    }
}
