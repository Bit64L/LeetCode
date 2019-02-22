import org.junit.Test;

import java.util.Map;

public class DecodeWays91 {
    public int numDecodings(String s) {
        int[] res = new int[1];

        backTrack(0, s, res);
        return res[0];
    }

    public void backTrack(int start, String s, int[] res){
        if(start == s.length()){
            res[0]++;
            return;
        }
        StringBuilder tmp = new StringBuilder();
        for(int i = start; i < s.length(); i++){
            tmp.append(s.charAt(i));
            if(isValid(tmp.toString()))
                backTrack(i + 1, s, res);
            else break;
        }
    }

    public boolean isValid(String num){
        int n = Integer.parseInt(num);
        if(n >= 1 && n <= 26) return true;
        return false;
    }


    public int backTrack1(int start, String s, Map<String, Integer> map){ // Memorized Backtrack
        String key = s+"-"+start;
        if(map.containsKey(key))
            return map.get(key);
        if(start == s.length()){
            return 1;
        }
        StringBuilder tmp = new StringBuilder();
        int count = 0;
        for(int i = start; i < s.length(); i++){
            tmp.append(s.charAt(i));
            if(isValid(tmp.toString()))
                count += backTrack1(i + 1, s, map);
            else break;
        }
        map.put(key, count);
        return count;
    }


    public int numDecodings1(String s){
        if(s==null || s.length() == 0 ) return 0;
        int n = s.length();
        int[] dp = new int[n+1];
        dp[n] = 1;
        dp[n - 1] = (s.charAt(n-1) == '0') ? 0 : 1;
        for(int i = s.length() - 2; i>=0 ; i--){
            if(s.charAt(i) == '0') continue;
            dp[i] =  Integer.parseInt(s.substring(i,i+2)) <= 26 ? dp[i+1] + dp[i+2] : dp[i+1];
        }
        return dp[0];
    }
    @Test
    public void test(){
        System.out.println(numDecodings("226"));
    }
}
/*
1. 第一眼看题首先联想到了Backtracking的解法，但是题目只要数量，则考虑有更优化解法。
2. 使用带记忆的BackTrack
3.
 */