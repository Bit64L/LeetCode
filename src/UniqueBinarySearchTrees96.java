import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class UniqueBinarySearchTrees96 {
    private Map<String, Integer> map = new HashMap<>();

    public int numTrees1(int n) {
        return generate(1, n);
    }

    private int generate(int lo, int hi) {
        String key = lo + "-" + hi;
        if (map.getOrDefault(key, null) != null) {
            return map.get(key);
        }
        if (lo > hi)
            return 1;
        int ans = 0;
        for (int i = lo; i <= hi; i++) {
            int left = generate(lo, i - 1);
            int right = generate(i + 1, hi);
            ans += left * right;
        }
        map.put(key, ans);
        return ans;
    }


    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int len = 1; len <= n; len++) {
            int tmp = 0;
            for (int index = 1; index <= len; index++) {
                int left = dp[index - 1];
                int right = dp[len - index];
                tmp += left * right;
            }
            dp[len] = tmp;
        }
        return dp[n];
    }

    @Test
    public void test() {
        System.out.println(numTrees(3));
    }
}
