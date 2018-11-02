import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class Triangle120 {
    public int minimumTotal1(List<List<Integer>> triangle) {//top down
        if (triangle == null || triangle.size() == 0 || triangle.get(0).get(0) == null)
            return 0;
        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = i; j >= 0; j--) {
                if (j == 0) {
                    dp[j] += triangle.get(i).get(j);
                } else if (j == i) {
                    dp[j] = dp[j - 1] + triangle.get(i).get(j);
                } else {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + triangle.get(i).get(j);
                }

            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i : dp) {
            if (ans > i)
                ans = i;
        }
        return ans;
    }


    public int minimumTotal(List<List<Integer>> triangle) {// bottom up
        if (triangle == null || triangle.size() == 0 || triangle.get(0).get(0) == null)
            return 0;
        int[] dp = new int[triangle.size()+1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for(int j=0;j<=i;j++){
                dp[j] = triangle.get(i).get(j)+Math.min(dp[j],dp[j+1]);
            }
        }
        return dp[0];
    }

    @Test
    public void test() {
        List<List<Integer>> list = new LinkedList<>();
        List<Integer> list1 = new LinkedList<>();
        list1.add(2);
        list.add(list1);
        List<Integer> list2 = new LinkedList<>();
        list2.add(3);
        list2.add(4);
        list.add(list2);
        List<Integer> list3 = new LinkedList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        list.add(list3);
        List<Integer> list4 = new LinkedList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        list.add(list4);
        System.out.println(minimumTotal(list));
    }
}
