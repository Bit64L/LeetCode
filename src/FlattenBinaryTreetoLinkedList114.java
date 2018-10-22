import common.TreeNode;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class FlattenBinaryTreetoLinkedList114 {
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode curr, pre = null;
        while(!stack.isEmpty()){
            curr = stack.pop();
            if(curr.right != null)
                stack.push(curr.right);
            if(curr.left != null)
                stack.push(curr.left);
            if(pre!=null){
                pre.right = curr;
                pre.left = null;
            }
            pre = curr;
        }
    }
    private TreeNode pre = null;
    public void flatten1(TreeNode root) { //可以理解，但是比较难想
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
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
        flatten(node1);
        System.out.println();
    }
}
