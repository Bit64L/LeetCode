public class MaximumBinaryTree654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null || nums.length ==0)
            return null;
        return helper(nums, 0, nums.length - 1);

    }

    public TreeNode helper(int[] nums, int start, int end) {
        if(start > end)
            return null;
        int num = findMax(nums, start, end);
        TreeNode root = new TreeNode(nums[num]);
        root.left = helper(nums, start, num - 1);
        root.right = helper(nums, num + 1, end);
        return root;
    }

    public int findMax(int[] nums, int start, int end) {
        int index = start;
        for (int i = start; i <= end; i++) {
            if (nums[index] < nums[i]) {
                index = i;
            }
        }
        return index;
    }

}


// 重复子问题, 训练思维能力
