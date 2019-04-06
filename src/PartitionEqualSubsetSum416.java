public class PartitionEqualSubsetSum416 {
    public boolean canPartition(int[] nums) {
        if( nums == null || nums.length == 0) return true;
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) sum += nums[i];
        if(sum % 2 == 1) return false;
        sum /= 2;
        int[] dp = new int[sum+1];
        for(int w = 0; w <= sum; w++) dp[w] = 0;
        for(int i = 1; i <= nums.length; i++){
            for(int w = sum; w >= 0; w--){
                if(w - nums[i - 1] >= 0)
                    dp[w] = Math.max(dp[w], dp[w - nums[i - 1]] + nums[i - 1]);
                else
                    dp[w] = dp[w];
            }
        }
        if(dp[sum] == sum) return true;
        return false;
    }
}


/*
可以转换为0-1背包问题。 背包容量为sum/2
OPT(i, w) 表示前i个物品，背包容量为w，最多可以装多少重量
OPT(i,w) = max{OPT(i-1, w), OPT(i-1, w - wi) + wi}
优化：可以将空间复杂度优化为O(n)
OPT(w)代表前i物品可获得的最大容量
OPT(w) = max{OPT(w) + OPT(w-wi) + wi}, 此时OPT数组需要倒着填

 */
