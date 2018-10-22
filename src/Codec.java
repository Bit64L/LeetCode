import common.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class Codec {
    private static final String SEP= ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        while(!stack.isEmpty() || curr!=null){
            if(curr != null){
                str.append(curr.val).append(SEP);
                stack.push(curr);
                curr = curr.left;
            }else{
                curr = stack.pop();
                curr = curr.right;
            }
        }
        return str.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")){
            return null;
        }
        String[] strs = data.split(SEP);
        Deque<Integer> q = new ArrayDeque<>();
        for(String str : strs){
            q.offer(Integer.parseInt(str));
        }
        return helper(q);
    }
    public TreeNode helper(Deque<Integer> q){
        if(q.isEmpty()){
            return null;
        }
        TreeNode root = new TreeNode(q.poll());
        Deque<Integer> left = new ArrayDeque<>();
        while(!q.isEmpty() && q.peek() < root.val){
            left.offer(q.pop());
        }
        root.left = helper(left);
        root.right = helper(q);
        return root;
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
        String data = serialize(node1);
        System.out.println(data);

        TreeNode root = deserialize("");
        System.out.println(root.val);
    }
}
