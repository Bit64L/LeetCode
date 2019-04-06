import org.junit.Test;

public class RegularExpressionMatching10 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            if (s == null && p == null) return true;
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] =  dp[0][j - 2];
            }else{
                dp[0][j] = false;
            }
        }

        for (int i = 1; i <= s.length(); i++)
            dp[i][0] = false;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    if (p.charAt(j - 1) == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (p.charAt(j - 1) == '*') {
                        if (s.charAt(i - 1) == p.charAt(j - 1 - 1) || p.charAt(j - 1 - 1) == '.') {
                            dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2];
                        } else {
                            dp[i][j] = dp[i][j - 2];
                        }
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    @Test
    public void test() {
        System.out.println(isMatch("aab",
                "c*a*b"));
    }
}
/*
OPT(i,j) represents whether pj is matched to si.
OPT(i, j) = {
    OPT(i-1, j-1) if(si == pj || pj == '.')
    OPT(i-1, j) || OPT(i, j-1) || OPT(i, j-2) if(pj == '*' && (pj-1 == si || pj-1 == '.'))
    OPT(i, j -2) if(pj == '*' && pj-1 != si)
}

难点：
情况太多，如何初始化
 */