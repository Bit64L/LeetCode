package common;

import org.junit.Test;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;

    public TreeNode(int x) {
        val = x;
    }

    @Test
    public void test() {
        String vals = "1,2,3,4,5,6";
        String[] strs = vals.split(",");
        TreeNode root = helper(1, strs);
        System.out.println();
    }

    public TreeNode helper(int i, String[] strs) {
        if (i > strs.length || strs[i - 1].equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(strs[i - 1]));
        root.left = helper(2 * i, strs);
        root.right = helper(2 * i + 1, strs);
        return root;
    }
}