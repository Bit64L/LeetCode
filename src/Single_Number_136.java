/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
class Solution136 {
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }
}

public class Single_Number_136 {
    public static void main(String[] args) {
        Solution136 solution136 = new Solution136();
        int ans = solution136.singleNumber(new int[]{2, 2, 1, 3, 3});
        System.out.println(ans);
    }
}

/*
异或的作用
*/