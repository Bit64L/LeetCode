import org.junit.Test;

public class Convert_Sorted_Array_to_Binary_Search_Tree_108 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums != null && nums.length != 0)
                return recursion(nums, 0, nums.length - 1);
            return null;
        }

        public TreeNode recursion(int[] num, int lo, int hi) {
            if (lo > hi) return null;
            int med = (lo + hi) / 2;
            TreeNode root = new TreeNode(num[med]);
            root.left = recursion(num, lo, med - 1);
            root.right = recursion(num, med + 1, hi);
            return root;
        }

        public void tranverse(TreeNode root){
            if(root!= null) System.out.println(root.val);
            if(root.left != null) tranverse(root.left);
            if(root.right!= null) tranverse(root.right);
        }
    }


    @Test
    public void  test(){
        Solution solution = new Solution();
        int[] arr={1,2,3,4,5,6};
        TreeNode root = solution.sortedArrayToBST(arr);
        solution.tranverse(root);
    }


}
