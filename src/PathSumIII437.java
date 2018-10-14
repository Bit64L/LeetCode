/**
 * Definition for a binary tree node.
 **/


public class PathSumIII437 {
    public int pathSum(TreeNode root, int sum) {
        if(root == null)
            return 0;
        return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int helper(TreeNode root, int sum) {
        if(root == null)
            return 0;
        int tmp = root.val == sum ? 1 : 0;
        return tmp + helper(root.left, sum-root.val) + helper(root.right,sum-root.val);

    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        PathSumIII437 pathSumIII437 = new PathSumIII437();
        System.out.println(pathSumIII437.pathSum(node1, 5));

    }
}


