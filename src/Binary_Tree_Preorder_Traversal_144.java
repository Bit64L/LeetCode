import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class Binary_Tree_Preorder_Traversal_144 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        List<Integer> list = new LinkedList<>();

        public List<Integer> preorderTraversal(TreeNode root) {
            if (root == null) return list;
            list.add(root.val);
            if (root.left != null) preorderTraversal(root.left);
            if (root.right != null) preorderTraversal(root.right);
            return list;
        }
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        Solution solution = new Solution();
        List<Integer> list = solution.preorderTraversal(null);
        for(Integer i : list){
            System.out.println(i);
        }
    }
}
