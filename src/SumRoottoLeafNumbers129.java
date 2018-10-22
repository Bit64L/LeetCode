import common.TreeNode;
import org.junit.Test;

public class SumRoottoLeafNumbers129 {
    private int ans = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        helper(root, "");
        return ans;
    }

    public void helper(TreeNode node, String path) {
        if (node == null)
            return;
        if (node.left == null && node.right == null) {
            ans += Integer.parseInt(path + node.val);
            return;
        }
        helper(node.left, path + node.val);
        helper(node.right, path + node.val);
    }

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(2);
        node1.left = node2;
        node1.right = node3;

        System.out.println(sumNumbers(node1));
    }
}
