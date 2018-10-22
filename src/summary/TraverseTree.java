package summary;

import common.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


public class TraverseTree {
    private List<Integer> ans = new LinkedList<>();

    public void inorder(TreeNode root) {// 递归中序遍历
        if (root == null)
            return;
        inorder(root.left);
        ans.add(root.val);
        inorder(root.right);
    }

    public void inorder1(TreeNode root) {// 非递归中序遍历
        if (root == null)
            return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                ans.add(curr.val);
                curr = curr.right;
            }
        }
    }

    public void preorder(TreeNode root) {// 递归先序遍历
        if (root == null)
            return;
        ans.add(root.val);
        inorder(root.left);
        inorder(root.right);
    }

    public void preorder1(TreeNode root) {// 非递归先序遍历
        if (root == null)
            return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                ans.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();

                curr = curr.right;
            }
        }
    }

    public void preorder2(TreeNode root) { //第二种非递归先序遍历
        if (root == null)
            return;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode curr = null;
        while (!stack.isEmpty()) {
            curr = stack.pop();
            ans.add(curr.val);
            if (curr.right != null)
                stack.push(curr.right);
            if (curr.left != null)
                stack.push(curr.left);
        }
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

        ans.clear();
        inorder(node1);
        System.out.println(ans);

        ans.clear();
        inorder1(node1);
        System.out.println(ans);

        ans.clear();
        preorder(node1);
        System.out.println(ans);

        ans.clear();
        preorder1(node1);
        System.out.println(ans);


    }
}
