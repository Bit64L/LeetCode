import common.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class KthSmallestElementinaBST230 {
    private Map<Integer, Integer> map = new HashMap<>();
    private int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        helper(root);
        return map.get(k);
    }

    public void helper(TreeNode root) {
        if (root == null)
            return;
        helper(root.left);
        count++;
        map.put(count, root.val);
        helper(root.right);
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
        System.out.println(kthSmallest(node1,1));
    }
}
