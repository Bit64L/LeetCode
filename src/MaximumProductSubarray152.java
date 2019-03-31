import org.junit.Test;

public class MaximumProductSubarray152 {
    int maxProduct(int nums[]) {
        int r = nums[0];
        int min = r, max = r;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = min;
                min = max;
                max = tmp;
            }
            max = Math.max(nums[i], nums[i] * max);
            min = Math.max(nums[i], nums[i] * min);

            if (r < max) {
                r = max;
            }
        }
        return r;
    }


    public int maxProduct2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0]; dp[0][1] = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < 0){
                dp[i][0] = Math.max(nums[i], dp[i-1][1] * nums[i]);
                dp[i][1] = Math.min(nums[i], dp[i-1][0] * nums[i]);
            }else{
                dp[i][0] = Math.max(nums[i], dp[i-1][0] * nums[i]);
                dp[i][1] = Math.min(nums[i], dp[i-1][1] * nums[i]);
            }
        }

        int res = Integer.MIN_VALUE;
        for(int i = 0; i < dp.length; i++){
            res = Math.max(res, dp[i][0]);
        }
        return res;
    }
    @Test
    public void test() {
        int[] arr = {2, -3};
        System.out.println(maxProduct(arr));
    }
}
