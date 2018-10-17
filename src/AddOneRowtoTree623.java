import common.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AddOneRowtoTree623 {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(root == null)
            return null;
        if(d == 1){
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int count = 0;
        int layer = 0;
        List<TreeNode> list = new LinkedList<>();//获得第k层的结点(递归/层次遍历)
        while(!q.isEmpty()){
            if(count == 0){
                count = q.size();
                layer++;
                if(layer == d-1){
                    list.addAll(q);
                    break;
                }

            }
            TreeNode node = q.poll();
            count--;
            if(node.left != null)
                q.offer(node.left);
            if(node.right != null)
                q.offer(node.right);
        }
        for(TreeNode node : list){
            TreeNode left = node.left;
            TreeNode right = node.right;
            node.left = new TreeNode(v);
            node.right = new TreeNode(v);
            node.left.left = left;
            node.right.right = right;
        }
        return root;
    }


    private void dfs(TreeNode root, int depth, int v, int d) {//DFS解法
        if (root == null) return;
        if (depth < d-1) {
            dfs(root.left, depth+1, v, d);
            dfs(root.right, depth+1,v, d);
        } else {
            TreeNode tmp = root.left;
            root.left = new TreeNode(v);
            root.left.left = tmp;
            tmp = root.right;
            root.right = new TreeNode(v);
            root.right.right = tmp;
        }
    }

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(1);
        node1.left = node2;
        node2.left = node3;
        node2.right = node4;
        addOneRow(node1,1,3);
    }
}
