import org.junit.Test;

public class LongestPalindromicSubstring5 {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";
        int n = s.length(), start = 0, end = 0;
        boolean dp[][] = new boolean[n][n];
        for(int i=n - 1; i >= 0; --i){// 从末尾向前遍历，因为dp[i][j]依赖左下方的值
            for(int j = n - 1; j >= i; --j){// 上三角矩阵
                // dp式，dp[i,j]表示s(i,j)是否为是回文
                dp[i][j] = ( i+1 > j-1 || dp[i+1][j-1]) && s.charAt(i) == s.charAt(j);
                if(dp[i][j] && j - i > end - start){
                    start = i; end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    @Test
    public void test(){
        System.out.println(longestPalindrome("babad"));

    }
}
