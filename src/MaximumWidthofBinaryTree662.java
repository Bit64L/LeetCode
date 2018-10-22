import common.TreeNode;
import org.junit.Test;

import java.util.*;

public class MaximumWidthofBinaryTree662 {
    public int widthOfBinaryTree(TreeNode root) {
        int[] ans = new int[1];
        List<Integer> left = new LinkedList<>();
        left.add(1);
        dfs(root, 1, 1, left, ans);
        return ans[0];
    }

    public void dfs(TreeNode node, int depth, int id, List<Integer> left, int[] ans) {
        if (node == null)
            return;
        if (left.size() < depth)
            left.add(id);
        int i = ans[0];
        ans[0] = Math.max(ans[0], id - left.get(depth-1) + 1);
        dfs(node.left, depth + 1, id * 2, left, ans);
        dfs(node.right, depth + 1, id * 2 + 1, left, ans);
    }

    public int widthOfBinaryTree1(TreeNode root) {
        if (root == null)
            return 0;
        Deque<Map.Entry<Integer, TreeNode>> q = new ArrayDeque<>();
        q.offer(new AbstractMap.SimpleEntry<>(1, root));
        int count = 0, ans = 0;
        while (!q.isEmpty()) {
            if (count == 0) {
                count = q.size();
                int min = q.getFirst().getKey();
                int max = q.getLast().getKey();
                if (ans < max - min + 1)
                    ans = max - min + 1;
            }
            Map.Entry<Integer, TreeNode> entry = q.poll();
            TreeNode node = entry.getValue();
            count--;
            if (node.left != null)
                q.offer(new AbstractMap.SimpleEntry<>(entry.getKey() * 2, node.left));
            if (node.right != null)
                q.offer(new AbstractMap.SimpleEntry<>(entry.getKey() * 2 + 1, node.right));
        }
        return ans;
    }


    public int trash(TreeNode root) { // MLE
        if (root == null)
            return 0;
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int count = 0;
        int min = 0, max = 0, ans = 0;
        int i = 0;
        while (true) {
            if (count == 0) {
                if (max - min < 0)
                    break;
                if (ans < max - min + 1)
                    ans = max - min + 1;
                count = q.size();
                i = 0;
                min = count;
                max = 0;
            }
            TreeNode node = q.poll();
            i++;
            count--;
            if (node == null) {
                q.offer(null);
                q.offer(null);
            } else {
                if (min > i)
                    min = i;
                if (max < i)
                    max = i;
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return ans;
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
        node2.left = node4;
        node3.right = node5;
        System.out.println(widthOfBinaryTree(node1));
    }
}
