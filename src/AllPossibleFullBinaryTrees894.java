import common.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AllPossibleFullBinaryTrees894 {
    Map<Integer, List<TreeNode>> map = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int N) {
        if(map.containsKey(N)){ // 带cache的优化
            return map.get(N);
        }
        List<TreeNode> ans = new LinkedList<>();
        if (N == 1) {
            ans.add(new TreeNode(0));
            return ans;
        }
        N--;
        for (int i = 1; i < N; i += 2) {
            List<TreeNode> left = allPossibleFBT(i); // 递归式
            List<TreeNode> right = allPossibleFBT(N - i);
            for (TreeNode nl : left) {
                for (TreeNode nr : right) {
                    TreeNode root = new TreeNode(0);
                    root.left = nl;
                    root.right = nr;
                    ans.add(root);
                }
            }
        }
        map.put(N+1,ans);
        return ans;
    }

    @Test
    public void test() {
        List<TreeNode> ans = allPossibleFBT(5);
        System.out.println("");

    }
}
// 找到递归子问题，列递归式