import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue513 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        int k = 0;
        q.add(root);
        TreeNode ans = root;
        while(!q.isEmpty()){
            if(k == 0){
                ans = q.peek();
                k = q.size();
            }
            TreeNode node = q.poll();
            k--;
            if(node.left != null)
                q.add(node.left);
            if(node.right != null)
                q.add(node.right);

        }
        return ans.val;
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
        System.out.println(findBottomLeftValue(node1));
    }
}
