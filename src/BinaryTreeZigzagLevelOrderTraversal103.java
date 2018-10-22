import common.TreeNode;
import org.junit.Test;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal103 {
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {//BFS
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> tmp = new LinkedList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        int layer = 1, count = 1;
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            count--;
            if (layer % 2 == 1)
                tmp.add(node.val);
            else
                tmp.add(0, node.val);
            if (node.left != null)
                q.offer(node.left);
            if (node.right != null)
                q.offer(node.right);
            if (count == 0) {// 处理最后一排，因此放后面
                ans.add(tmp);
                count = q.size();
                layer++;
                tmp = new LinkedList<>();
            }

        }
        return ans;
    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {// DFS
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }


    public void dfs(TreeNode root, int depth, List<List<Integer>> ans) {
        if (root == null)
            return;
        if (ans.size() <= depth) {
            List<Integer> tmp = new LinkedList<>();
            tmp.add(root.val);
            ans.add(tmp);
        }else{
            List<Integer> tmp = ans.get(depth);
            if (depth % 2 == 1)
                tmp.add(0, root.val);
            else
                tmp.add(root.val);
        }

        dfs(root.left, depth + 1, ans);
        dfs(root.right, depth + 1, ans);

    }

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        System.out.println(zigzagLevelOrder(node1));
    }
}
