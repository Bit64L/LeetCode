public class ProductofArrayExceptSelf238 {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = nums[0]; right[n-1] = nums[n-1];
        for(int i = 1; i < n; i++){
            left[i] = nums[i] * left[i-1];
        }
        for(int j = n - 2; j >=0 ; j--)
            right[j] = nums[j] * right[j + 1];
        int[] res = new int[n];
        for(int i =0; i < n; i++) res[i] = 1;
        for(int i = 0; i < n; i++){
            if(i > 0) res[i] *= left[i-1];
            if(i < n-1) res[i] *= right[i+1];
        }
        return res;
    }// Space O(N)


    public int[] productExceptSelf1(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int n = nums.length;
        int[] res = new int[n];
        int left = 1;
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            left *= nums[i - 1];
            res[i] = left;
        }
        int right = 1;
        for (int i = n - 2; i >= 0; i--) {
            right *= nums[i + 1];
            res[i] *= right;
        }
        return res;
    }// Space O(1)
}


/*
basic idea：divide the process into two -- left and right
optimize: First res records left then multiply right
 */
