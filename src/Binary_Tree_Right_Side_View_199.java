import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Binary_Tree_Right_Side_View_199 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            if (root == null) return (new LinkedList<>());
            List<Integer> list = new LinkedList<>();
            Queue<TreeNode> que = new LinkedList<>();
            que.offer(root);
            int size = 0;
            while (!que.isEmpty()) {
                if (size == 0) {
                    size = que.size();
                }
                TreeNode node = que.poll();
                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
                if (size == 1)
                    list.add(node.val);
                size--;

            }
            return list;
        }
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        Solution solution = new Solution();
        List<Integer> list = solution.rightSideView(root);
        for (Integer i : list)
            System.out.println(i);

    }
}
