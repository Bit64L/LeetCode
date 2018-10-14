import org.junit.Test;

public class InsertintoaBinarySearchTree701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)
            return new TreeNode(val);
        helper(root,val, null);
        return root;

    }
    public void helper(TreeNode root, int val, TreeNode pre){
        if(root == null){
            if(pre.val > val)
                pre.left = new TreeNode(val);
            else
                pre.right = new TreeNode(val);
            return;
        }
        pre = root;
        if(root.val > val){
            helper(root.left, val, pre);
        }else{
            helper(root.right, val, pre);
        }
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
        insertIntoBST(node1, 5);
        System.out.println("");
    }
}
