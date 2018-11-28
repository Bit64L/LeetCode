import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidateBinarySearchTree98 {
    private TreeNode pre = null;
    private boolean isValid = true;

    public boolean isValidBST1(TreeNode root) { // BST中序遍历递归解法
        helper(root);
        return isValid;
    }

    public void helper(TreeNode root) {
        if (root == null)
            return;

        helper(root.left);
        if (pre != null && pre.val >= root.val) {
            isValid = false;
            return;
        }
        pre = root;
        helper(root.right);
    }

    public boolean isValidBST(TreeNode root) {// 非递归中序遍历
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root, pre = null;

        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                if (pre != null && curr.val <= pre.val) {
                    return false;
                }
                pre = curr;
                curr = curr.right;
            }
        }
        return true;
    }

    public boolean isValidBST2(TreeNode root) {//递归解法
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean helper(TreeNode root, long min,long max){
        if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
