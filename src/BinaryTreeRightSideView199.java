import common.TreeNode;

import java.util.ArrayList;
import java.util.List;


public class BinaryTreeRightSideView199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }

    public void dfs(TreeNode root, List<Integer> list, int depth){
        if(root == null) return;

        if(list.size() == depth) list.add(root.val);
        dfs(root.right, list, depth + 1);
        dfs(root.left, list, depth + 1);

    }

}
