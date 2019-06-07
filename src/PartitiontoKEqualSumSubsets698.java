import java.util.Arrays;

public class PartitiontoKEqualSumSubsets698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) sum+= nums[i];
        if(sum % k == 1) return false;
        int target = sum / k;

        Arrays.sort(nums);
        if(nums[nums.length - 1] > target) return false;

        return search(new int[k], nums.length - 1, nums, target, k);
    }
    public boolean search(int[] groups, int idx, int[] nums, int target, int k){
        if(idx < 0) return true;
        int v = nums[idx];
        for(int i = 0; i < groups.length; i++){
            if(groups[i] + v <= target){
                groups[i] += v;
                if(search(groups, idx - 1, nums, target, k)) return true;
                groups[i] -= v;
            }
        }
        return false;
    }
}
/*
思路：
1. 思路，将nums[i] 枚举放到 groups的一个合理位置。
2. 选择暴力解法的原因: K值比较小
3. 优化点：
    排序，如果最大数大于target，则false

 */