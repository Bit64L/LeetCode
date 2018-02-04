import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */


class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        if (nums != null) {
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    result[1] = i;
                    result[0] = map.get(target - nums[i]);
                    return result;
                }
                map.put(nums[i], i);
            }
        }
        return null;
    }
}

public class Two_sum_1 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int i : result) {
            System.out.println(i);
        }
    }
}

