import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK560 {
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        int res = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum - k)){
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}

/*
类似Sum2
sum[0,j] - sum[0, i] = k
使用HashMap
 */