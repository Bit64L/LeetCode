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
        String vals = "-1,-7,9,#,#,-1,-7,#,8,-9";
        String[] strs = vals.split(",");
    }
}