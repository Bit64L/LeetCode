import org.junit.Test;

public class TrimaBinarySearchTree669 {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        return helper(root, L, R);
    }
    public TreeNode helper(TreeNode root, int L, int R){
        if(root == null){
            return null;
        }
        if(root.val < L){
            return helper(root.right, L, R);
        }
        if(root.val > R){
            return helper(root.left, L, R);
        }
        root.left = helper(root.left, L, R);
        root.right = helper(root.right, L, R);
        return root;
    }

    @Test
    public void test(){
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(2);
        node1.left = node2;
        node1.right = node3;

        System.out.println(trimBST(node1,3,4));
    }
}
