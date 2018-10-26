import common.TreeNode;
import org.junit.Test;

public class CountCompleteTreeNodes222 {
    public int countNodes(TreeNode root) {//递归，根，左子树，右子树，分情况讨论
        if (root == null)
            return 0;
        int h = getHeight(root);
        int right = getHeight(root.right);
        if (right == h - 1) {
            return (1 << h) - 1 + 1 + countNodes(root.right);
        } else {
            return (1 << h - 1) - 1 + 1 + countNodes(root.left);
        }
    }

    int getHeight(TreeNode root) {
        if (root == null)
            return -1;
        return 1 + getHeight(root.left);
    }

    @Test
    public void test() {
        String vals = "1,2,3,4,5,6";
        String[] strs = vals.split(",");
        TreeNode root = helper(1, strs);
        int count = countNodes(root);
        System.out.println();
    }

    public TreeNode helper(int i, String[] strs) {
        if (i > strs.length || strs[i - 1].equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(strs[i - 1]));
        root.left = helper(2 * i, strs);
        root.right = helper(2 * i + 1, strs);
        return root;
    }
}
