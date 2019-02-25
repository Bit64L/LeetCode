public class CoinChange322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            int min = -1;
            for(int j = 0; j < coins.length; j++){
                if(i - coins[j] >= 0 && dp[i-coins[j]] != -1)
                    min = min < 0 ? dp[i - coins[j]] + 1: Math.min(min, dp[i - coins[j]] + 1);
            }
            dp[i] = min;
        }
        return dp[amount];
    }
}
/*
状态转移方程 OPT(i) = Min(OPT(i-coins[j]) + 1)
 */