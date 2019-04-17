import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSequence1027 {
    public int longestArithSeqLength(int[] A) {
        int res = 0;
        Map<Integer, Integer>[] dp = new HashMap[A.length];
        for(int i = 0; i < A.length; i++) dp[i] = new HashMap<>();
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < i; j++){
                int diff = A[i] - A[j];
                if(!dp[j].containsKey(diff)){
                    dp[i].put(diff, 2);
                }else{
                    dp[i].put(diff, dp[j].get(diff) + 1);
                }
                res = Math.max(res, dp[i].get(diff));
            }
        }
        return res;
    }
}


/*
OPT(i, diff) represents end with i, difference is diff, the length

OPT(i, diff) = OPT(j, diff) + 1
 */