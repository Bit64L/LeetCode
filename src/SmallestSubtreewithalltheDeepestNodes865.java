import common.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SmallestSubtreewithalltheDeepestNodes865 {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Set<TreeNode> set = getMaxDeepNodes(root);
        return helper(root, set);
    }
    public TreeNode helper(TreeNode root, Set<TreeNode> set){
        if(root == null)
            return null;
        if(set.contains(root))
            return root;
        TreeNode left = helper(root.left, set),
                right = helper(root.right, set);
        if(left != null && right != null)
            return root;
        if(left != null)
            return left;
        if(right != null)
            return right;
        else
            return null;

    }
    public Set<TreeNode> getMaxDeepNodes(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        Set<TreeNode> set = new HashSet<>();
        set.add(root);
        int count = 1;
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            count--;
            if(node.left != null)
                q.add(node.left);
            if(node.right != null)
                q.add(node.right);
            if(count == 0 && !q.isEmpty()){
                set.clear();
                set.addAll(q);
                count = q.size();
            }
        }
        return set;
    }
}
