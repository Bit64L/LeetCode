import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class BSTIterator {
    private Deque<TreeNode> stack = new ArrayDeque<>();
    public BSTIterator(TreeNode root) {
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();

    }

    /** @return the next smallest number */
    public int next() {
        TreeNode curr = stack.pop();
        TreeNode node = curr.right;
        while(node != null){
            stack.push(node);
            node = node.left;
        }
        return curr.val;

    }
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(2);
        node1.left = node2;
        node1.right = node3;
        BSTIterator bst = new BSTIterator(null);
        System.out.println(bst.hasNext());
        System.out.println(bst.next());
        System.out.println(bst.next());
    }
}
