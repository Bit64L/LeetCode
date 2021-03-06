import common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueinEachTreeRow515 {
    public List<Integer> largestValues(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int count = 1;
        int max = 0x80000000;
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            count--;
            if(node.val > max){
                max = node.val;
            }
            if(node.left != null)
                q.offer(node.left);
            if(node.right != null)
                q.offer(node.right);
            if(count == 0){
                ans.add(max);
                max = 0x80000000;
                count = q.size();
            }
        }
        return ans;
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

        System.out.println(largestValues(node1));
    }
}
