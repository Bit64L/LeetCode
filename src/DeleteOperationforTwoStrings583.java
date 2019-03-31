import org.junit.Test;

public class DeleteOperationforTwoStrings583 {
    public int minDistance(String word1, String word2) {
        if(word1 == null || word1.length() == 0 || word2 == null || word2.length() == 0)
            return 0;
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <=n; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else{
                    int a = word1.charAt(i-1) == word2.charAt(j-1) ? 1 : 0;
                    int first = dp[i-1][j-1] + a;
                    dp[i][j] = Math.max(Math.max(first, dp[i-1][j]), dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    @Test
    public void test(){
        System.out.println(minDistance("sea", "eat"));
    }
}
/*
OPT(i,j) represents the value of common subsequence between word1(1 ... i) and word2(1 ... j)
OPT(i,j) = max{
    OPT(i - 1, j - 1) + 1   if word1(i) == word2(i)
    OPT(i-1, j)
    OPT(i, j - 1)
}
此时 a = 1, b = 0
 */