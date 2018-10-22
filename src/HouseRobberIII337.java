import common.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HouseRobberIII337 {
    Map<TreeNode, Integer> cache = new HashMap<>();
    public int rob(TreeNode root) { // optimal substructure
        if(root == null)
            return 0;
        if(cache.containsKey(root))
            return cache.get(root);
        int val = 0;
        if(root.left != null){
            val += rob(root.left.left) + rob(root.left.right);
        }
        List<TreeNode> list = new LinkedList<>();
        if(root.right != null){
            val += rob(root.right.left) + rob(root.right.right);
        }
        cache.put(root, Math.max(val+root.val, rob(root.left) + rob(root.right)));
        return cache.get(root);
    }

    private int[] robSub(TreeNode root) { // 更优做法，decoupled the subproblems
        if (root == null) return new int[2];

        int[] left = robSub(root.left);
        int[] right = robSub(root.right);
        int[] res = new int[2];

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];

        return res;
    }

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(2);
        node1.left = node2;
        node1.right = node3;
        System.out.println(rob(node1));
    }
}
