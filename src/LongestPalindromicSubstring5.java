import org.junit.Test;

public class LongestPalindromicSubstring5 {
    public String longestPalindrome(String s) {
        if(s==null || s.length() == 0) return "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        int resI=s.length() - 1,resJ = s.length() - 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = s.length() - 1; j > i; j--) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j] && (resJ - resI) < (j - i)) {
                    resI = i;
                    resJ = j;
                }
            }
        }
        return s.substring(resI,resJ+1);
    }

    @Test
    public void test(){
        System.out.println(longestPalindrome("babad"));

    }
}
