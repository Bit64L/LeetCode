import org.junit.Test;

import java.util.HashMap;

public class UniqueBinarySearchTrees96 {
    HashMap<Integer, Integer> map = new HashMap<>();
    public int numTrees(int n) {
        if(n<=1) return 1;
        if(map.containsKey(n)) return map.get(n);
        int res = 0;
        for(int i=1;i<=n;i++){
            res += numTrees(i-1) * numTrees(n-i);
        }
        map.put(n,res);
        return res;
    }


    public int numTrees1(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int len = 1;len<=n;len++){
            int tmp = 0;
            for(int i = 0;i<len;i++)
                tmp += dp[i]*dp[len-i-1];
            dp[len] = tmp;
        }
        return dp[n];
    }

    @Test
    public void test() {
        System.out.println(numTrees(3));
    }
}
