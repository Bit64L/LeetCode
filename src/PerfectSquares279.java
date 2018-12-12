import org.junit.Test;

import java.util.HashMap;

public class PerfectSquares279 {
    private HashMap<Integer, Integer> map = new HashMap<>();
    public int numSquares(int n) {
        if(map.containsKey(n)) return map.get(n);
        if(n == 0) return 0;
        if(n == 1) return 1;
        int sqn = (int)Math.sqrt(n);
        int res = Integer.MAX_VALUE;
        for(int i=1;i<=sqn;i++){
            res = Math.min(res, 1+numSquares(n-i*i));
        }
        map.put(n, res);
        return res;
    }

    public int numSquares1(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0; dp[1] = 1;
        for(int i=2;i<=n;i++){
            int sqrtn = (int)Math.sqrt(i);
            dp[i] = Integer.MAX_VALUE;
            for(int j=1;j<=sqrtn;j++){
                dp[i] = Math.min(dp[i], 1 + dp[i-j*j]);
            }
        }
        return dp[n];
    }

    @Test
    public void test(){
        System.out.println(numSquares(13));
    }
}
