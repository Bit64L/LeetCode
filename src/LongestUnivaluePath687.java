
import org.junit.Test;

public class LongestUnivaluePath687 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null){
            return 0;
        }
        helper(root);
        return ans;
    }

    public int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        int sum=0;
        int curr = 0;
        if(root.left != null && root.left.val == root.val){
            sum+=left + 1;
            curr = sum;
        }
        if(root.right != null && root.right.val == root.val){
            sum+=right + 1;
            curr = Math.max(right+1, curr);
        }
        ans = Math.max(sum,ans);
        return curr;
    }
    @Test
    public void test(){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        System.out.println(longestUnivaluePath(node1));
    }
}
