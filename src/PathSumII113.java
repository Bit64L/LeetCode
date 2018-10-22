import common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class PathSumII113 {
    List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> path = new LinkedList<>();
        helper(root, sum, path);
        return ans;
    }

    public void helper(TreeNode root, int sum, List<Integer> path) {
        if (root == null)
            return;
        path.add(root.val);
        if (root.left == null && root.right == null && sum - root.val == 0) {
            List<Integer> tmp = new LinkedList<>();
            tmp.addAll(path);
            ans.add(tmp);
        }
        helper(root.left, sum - root.val, path);
        helper(root.right, sum - root.val, path);
        ((LinkedList) path).removeLast();
    }
}
