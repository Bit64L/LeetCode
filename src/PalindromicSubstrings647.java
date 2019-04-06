public class PalindromicSubstrings647 {
    public int countSubstrings(String s) {
        if( s== null || s.length() == 0) return 0;
        int res = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
            dp[i][i] = true;
            res++;
        }
        for(int j = 1; j < s.length(); j++){
            for(int i = j-1; i>=0; i--){
                dp[i][j] = s.charAt(i) == s.charAt(j) && (i+1>=j-1 || dp[i+1][j-1]);
                if(dp[i][j]) res++;
            }
        }
        return res;
    }
}
/*
OPT(i,j) represents whether sij is a palindrome.
OPT(i,j) = si == sj && (i+1 >= j-1 || OPT(i+1, j-1))
 */