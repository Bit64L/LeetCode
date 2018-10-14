import org.junit.Test;

/**
 * Definition for a binary tree node.
 */

public class SubtreeofAnotherTree572 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null || t == null)
            return false;
        boolean a = helper(s,t);
        boolean b = isSubtree(s.left, t);
        boolean c = isSubtree(s.right, t);

        return  a|| b || c;
    }
    public boolean helper(TreeNode s, TreeNode t) {
        if(s == null && t == null){
            return true;
        }
        if((s==null && t!=null) || (s != null && t == null)){
            return false;
        }
        if(s.val != t.val){
            return false;
        }
        return helper(s.left, t.left) && helper(s.right, t.right);
    }
    @Test
    public void test() {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(2);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        System.out.println(isSubtree(node1, node2));

    }
}
