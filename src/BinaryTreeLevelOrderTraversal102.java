import common.TreeNode;
import org.junit.Test;

import java.util.*;

public class BinaryTreeLevelOrderTraversal102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null)
            return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int count = 0;
        while(!q.isEmpty()){
            if(count == 0){
                count = q.size();
                for(TreeNode n : q){
                    list.add(n.val);
                }
                ans.add(list);
                list = new LinkedList<>();
            }
            TreeNode node = q.poll();
            count--;
            if(node.left != null){
                q.offer(node.left);
            }
            if(node.right != null){
                q.offer(node.right);
            }
        }
        return ans;

    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        if(root == null) return new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> tmp = new LinkedList<>();
            for(int i = q.size(); i>=1; i--){// 这种更简洁
                TreeNode node = q.poll();
                tmp.add(node.val);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            res.add(tmp);
        }
        return res;
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
        levelOrder(node1);
    }
}
