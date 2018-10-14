import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueinEachTreeRow515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int count = 1;
        int max = -1;
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            count--;
            if(node.val > max){
                max = node.val;
            }
            if(node.left != null)
                q.offer(node.left);
            if(node.right != null)
                q.offer(node.right);
            if(count == 0){
                ans.add(max);
                max = -1;
                count = q.size();
            }
        }
        return ans;
    }


}
