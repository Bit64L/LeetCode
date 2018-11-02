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
        if(n==0)
            return new LinkedList<>();
        List<TreeNode>[] result = new List[n + 1];
        result[0] = new LinkedList<>();
        result[0].add(null);
        for (int len = 1; len <= n; len++) {
            result[len] = new LinkedList<>();
            for(int index = 1;index<=len;index++){
                List<TreeNode> left= result[index-1];
                List<TreeNode> right = result[len-index];
                for(TreeNode node1:left){
                    for(TreeNode node2:right){
                        TreeNode root = new TreeNode(index);
                        root.left = node1;
                        root.right = clone(node2,index);
                        result[len].add(root);
                    }
                }
            }
        }
        return result[n];
    }

    public TreeNode clone(TreeNode node, int offset){
        if(node == null)
            return null;
        TreeNode root = new TreeNode(node.val+offset);
        root.left = clone(node.left, offset);
        root.right = clone(node.right, offset);
        return root;
    }

    @Test
    public void test() {
        generateTrees(3);
    }
}
