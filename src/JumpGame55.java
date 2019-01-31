public class JumpGame55 {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1) return true;
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i] + i);
            if(max >= nums.length - 1) return true;
            if(max < i + 1) return false;
        }
        return false;
    }
}


/*
Greedy Strategy: Keep track of the farthest index with variable max
 */