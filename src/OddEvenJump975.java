import java.util.TreeMap;

public class OddEvenJump975 {
    public int oddEvenJumps(int[] A) {
        if(A == null || A.length == 0) return 0;
        int n = A.length;
        int[][] dp = new int[n][2];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        dp[n-1][0] = 1; dp[n-1][1] = 1; map.put(A[n-1], n-1);
        for(int i = n-2; i >=0; i--){
            int j = map.ceilingKey(A[i]);
            int k = map.floorKey(A[i]);
            dp[i][0] = dp[j][1];
            dp[i][1] = dp[k][0];
            map.put(A[i], i);
        }
        int res = 0;
        for(int i = 0; i < n; i++)
            res += dp[i][0];
        return res;
    }
}

/*
每一个位置都是只关心它后面的元素，所以我们可以从后往前推进。
dp[i][0] 表示 上升跳是否可以达到末尾
dp[i][1] 表示下降跳是否可以到达末尾
j 表示i后面第一个比A[i[大的数  TreeMap.ceilingKey()可以实现
k 表示i后面第一个比A[i]小的数  TreeMap.floorKey()
 */