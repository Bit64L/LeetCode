public class MaximumSubarray53 {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int sum = -1, res = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            sum = nums[i] + (sum <= 0 ? 0 : sum);
            res = Math.max(sum, res);
        }
        return res;
    }
}

/*
OPT(i) represents the maximum value ending with nums[i]
We can decrease the space complexity to O(1)
 */
