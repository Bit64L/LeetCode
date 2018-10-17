import common.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromPreorderandPostorderTraversal889 {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre.length == 0 || pre.length != post.length) {
            return null;
        }
        int i = 0;
        Map<Integer, TreeNode> map = new HashMap<>();
        map.put(pre[i], new TreeNode(pre[i]));
        while (i < pre.length) {
            TreeNode root = map.get(pre[i]);
            if (i < pre.length - 1) {
                if (!map.containsKey(pre[i + 1])) {
                    root.left = new TreeNode(pre[i + 1]);
                    map.put(pre[i + 1], root.left);
                }
            }
            int j = changeToPost(pre,post,i);
            if (j > 0) {
                if (!map.containsKey(post[j - 1])) {
                    root.right = new TreeNode(post[j - 1]);
                    map.put(post[j - 1], root.right);
                }
            }
            i++;
        }
        return map.get(pre[0]);
    }
    public int changeToPost(int[] pre, int[] post, int i){
        for(int j = 0; j < post.length; j++){
            if(pre[i] == post[j])
                return j;
        }
        return -1;
    }

    @Test
    public void test() {
        int[] list1 = {1, 2, 4, 5, 3, 6, 7};
        int[] list2 = {4, 5, 2, 6, 7, 3, 1};
        TreeNode root = constructFromPrePost(list1, list2);
        System.out.println(root);
    }
}