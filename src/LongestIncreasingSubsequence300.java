import org.junit.Test;

public class LongestIncreasingSubsequence300 {


    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] tails = new int[nums.length];
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (len == 0 || nums[i] > tails[len - 1]) {
                tails[len++] = nums[i];
            } else {
                search(tails, len - 1, nums[i]);
            }
        }
        return len;
    }

    public void search(int[] nums, int hi, int target) {
        int lo = 0;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        nums[lo] = target;
    }


    public int lengthOfLIS2(int[] nums) { // dp(top down)
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ans = 0;
        int[] cache = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(lis(nums, i, cache), ans);
        }
        return ans;
    }

    public int lis(int[] nums, int tail, int[] cache) {
        if (tail == 0)
            return 1;
        if (cache[tail] != 0) {
            return cache[tail];
        }
        int ans = 1;//nums[tail]成立
        for (int i = 0; i < tail; i++) {
            if (nums[tail] > nums[i]) {
                ans = Math.max(lis(nums, i, cache) + 1, ans);
            }
        }
        cache[tail] = ans;
        return ans;
    }

    public int lengthOfLIS1(int[] nums) {// dp O(N2)
        if (nums == null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++)//dp[i] means longest sub tailed with nums[i]
            dp[i] = 1;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])// dp formula
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }


    public int lengthOfLIS3(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = -1;
        for(int i = 0; i < nums.length; i++) dp[i] = 1;
        for(int i = 0; i < nums.length; i++){
            int max = 1;
            for(int j = i - 1; j >= 0; j--){
                if(nums[i] > nums[j]){
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // sequence may not be continuous, 不同于subarray
    @Test
    public void test() {
        int[] arr = {10, 9, 2, 5, 3, 4};
        System.out.println(lengthOfLIS(arr));
    }
}

/*
dp[i] 代表以nums[i] 结尾的长增序列
dp[i] = max(dp[j]+1 (nums[j) < nums[i] && j < i)
 */