import org.junit.Test;

public class MinimumDepthofBinaryTree111 {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null)
            return minDepth(root.right) + 1;
        if(root.right == null)
            return minDepth(root.left) + 1;

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    @Test
    public void test(){
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(2);
        node1.left = node2;
        node1.right = node3;


        System.out.println(minDepth(node1));
    }
}
