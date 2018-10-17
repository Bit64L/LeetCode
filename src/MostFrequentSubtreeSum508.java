import common.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentSubtreeSum508 {
    private Map<Integer,Integer> map = new HashMap<>();
    private int max_fre=0;
    private int size = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        helper(root);
        int[] ans = new int[size];
        int i =0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() == max_fre){
                ans[i++] = entry.getKey();
            }
        }
        return ans;
    }
    public int helper(TreeNode root){
        if(root == null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        root.val += left + right;
        map.put(root.val, map.getOrDefault(root.val,0) + 1);
        if(map.get(root.val) > max_fre){
            max_fre = map.get(root.val);
            size = 1;
        }else if(map.get(root.val) == max_fre){
            size++;
        }
        return root.val;
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
        System.out.println(findFrequentTreeSum(node1));
    }
}
