import common.TreeNode;
import org.junit.Test;

public class DeleteNodeinaBST450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        return helper(root, key);
    }

    public TreeNode helper(TreeNode root, int key) {
        if(root == null)
            return null;
        if (key == root.val) {
            if (root.right == null) {
                return root.left;
            } else {
                TreeNode left = root.left;
                TreeNode curr = root.right;
                while (curr.left != null) {
                    curr = curr.left;
                }
                curr.left = left;
                return root.right;
            }
        } else if (key < root.val) {
            root.left = helper(root.left, key);
        } else {
            root.right = helper(root.right, key);
        }
        return root;
    }

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        deleteNode(node1, 3);
    }
}
