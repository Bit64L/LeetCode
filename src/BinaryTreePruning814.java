import org.junit.Test;

public class BinaryTreePruning814 {
    public TreeNode pruneTree(TreeNode root) {
        helper(root);
        return root;
    }
    public int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);

        if(left == 0){
            root.left = null;
        }
        if(right == 0){
            root.right = null;
        }
        return root.val + left + right;

    }
    @Test
    public void test(){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(1);
        node1.right = node2;
        node2.left  = node3;
        node2.right = node4;

        pruneTree(node1);
        System.out.println(node1);

    }
}
// 二叉树遍历变形
