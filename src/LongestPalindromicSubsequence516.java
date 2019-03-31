import org.junit.Test;

public class LongestPalindromicSubsequence516 {
    public int longestPalindromeSubseq(String s) {
        if(s == null || s.length() == 0) return 0;
        String t = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for(int i = 0; i <= s.length(); i++){
            for(int j = 0; j <= t.length(); j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else{
                    int a = s.charAt(i-1) == t.charAt(j-1) ? 1 : 0;
                    int first = dp[i-1][j-1] + a;
                    dp[i][j] = Math.max(Math.max(first, dp[i-1][j] ),  dp[i][j - 1] );
                }


            }
        }
        return dp[s.length()][t.length()];
    }

    @Test
    public void test(){
        System.out.println(longestPalindromeSubseq("cbbd"));
    }
}
