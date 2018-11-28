import common.TreeNode;
import org.junit.Test;

import java.util.*;

public class UniqueBinarySearchTreesII95 {
    private Map<String, List<TreeNode>> map = new HashMap<>();

    public List<TreeNode> generateTrees1(int n) {
        if (n == 0)
            return new LinkedList<>();
        return generate(1, n);
    }

    public List<TreeNode> generate(int lo, int hi) {
        String key = lo + "-" + hi;
        if (map.getOrDefault(key, null) != null)
            return map.get(key);
        List<TreeNode> list = new LinkedList<>();
        for (int i = lo; i <= hi; i++) {
            List<TreeNode> left = generate(lo, i - 1);
            List<TreeNode> right = generate(i + 1, hi);
            for (TreeNode node1 : left) {
                for (TreeNode node2 : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = node1;
                    root.right = node2;
                    list.add(root);
                }
            }
        }
        if (lo > hi) {
            list.add(null);
        }
        map.put(key, list);
        return list;
    }


    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<>();
        List<TreeNode>[] dp = new List[n+1];
        dp[0] = new ArrayList<>();
        dp[0].add(null);
        for(int len=1;len<=n;len++){
            List<TreeNode> tmp = new ArrayList<>();
            for(int i=1;i<=len;i++){
                List<TreeNode> left = dp[i-1];
                List<TreeNode> right = dp[len-i];
                for(TreeNode leftNode : left)
                    for(TreeNode rightNode : right){
                        TreeNode root = new TreeNode(i);
                        root.left = leftNode;
                        root.right = dfs(i, rightNode);
                        tmp.add(root);
                    }
            }
            dp[len] = tmp;
        }
        return dp[n];
    }
    public TreeNode dfs(int i, TreeNode root){
        if(root == null) return null;
        TreeNode newRoot = new TreeNode(root.val + i);
        newRoot.left = dfs(i, root.left);
        newRoot.right = dfs(i, root.right);
        return newRoot;
    }

    @Test
    public void test() {
        generateTrees(3);
    }
}
