import common.TreeLinkNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class PopulatingNextRightPointersinEachNode116 {
    public void connect1(TreeLinkNode root) { // not O(1)的时间复杂度
        if (root == null)
            return;
        Deque<TreeLinkNode> q = new ArrayDeque<>();
        q.offer(root);
        int count = 1, val = 1;
        TreeLinkNode pre = null;
        while (!q.isEmpty()) {
            TreeLinkNode node = q.poll();
            if (pre != null) {
                if(val != count)
                    pre.next = node;
            }
            count--;
            pre = node;
            if (node.left != null)
                q.offer(node.left);
            if (node.right != null)
                q.offer(node.right);
            if (count == 0) {
                count = q.size();
                val = q.size();
            }
        }
    }

    public void connect(TreeLinkNode root) { // dfs, O(1)空间复杂度
        if(root == null)
            return;
        if(root.left!=null){
            root.left.next = root.right;
            if(root.next!=null && root.right != null)
                root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
    }
    public void connect2(TreeLinkNode root){ // 非递归， O(1)空间复杂度
        if(root == null)
            return;
        TreeLinkNode levelStart = root;
        while(levelStart!=null){
            TreeLinkNode curr = levelStart;
            while(curr!=null){
                if(curr.left != null){
                    curr.left.next = curr.right;
                    if(curr.next!=null && curr.right != null){
                        curr.right.next = curr.next.left;
                    }
                }
                curr = curr.next;
            }
            levelStart = levelStart.left;
        }
    }

    @Test
    public void test() {
        TreeLinkNode node1 = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(3);
        node1.left = node2;
        node1.right = node3;
        connect(node1);
    }
}
