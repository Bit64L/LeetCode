import org.junit.Test;

public class CoinChange322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i = 1; i <= amount; i++) dp[i] = -1;
        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                if(i - coins[j] >= 0 && dp[i-coins[j]] != -1)
                    dp[i] = dp[i] < 0 ? dp[i - coins[j]] + 1: Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount];
    }
/*
OPT(i) 找零i最少要用多少个硬币
状态转移方程 OPT(i) = Min(OPT(i-coins[j]) + 1)
 */

    public int coinChange1(int[] coins, int amount) {
        if(coins == null || coins.length == 0) return -1;
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        for(int i = 1; i <= n; i++) {
            dp[0][i] = -1;
        }
        for(int i = 1; i <= m; i++){
            for(int j = 0; j <= n; j++){
                dp[i][j] = dp[i-1][j];
                if(j-coins[i-1] >= 0 && dp[i][j-coins[i-1]] != -1)
                    dp[i][j] = dp[i][j] < 0 ? dp[i][j-coins[i-1]] + 1 : Math.min(dp[i][j], dp[i][j-coins[i-1]] + 1);
            }
        }
        return dp[m][n];
    }
/*
OPT(i, j) 用前i个硬币找零j最少要多少个硬币
Recursive Relation:
OPT(i,j) = min{OPT(i - 1 ,j), OPT(i, j - coins[i])}
注意下标和OPT == -1的时候
 */
    @Test
    public void test(){
        int[] coins = {1, 2, 5};
        System.out.println(coinChange1(coins, 11));
    }
}




