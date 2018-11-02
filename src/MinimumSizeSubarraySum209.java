import org.junit.Test;

public class MinimumSizeSubarraySum209 {
    public int minSubArrayLen1(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int start = 0, end = 0, sum = 0, min = Integer.MAX_VALUE;
        while (end < nums.length) {
            while (end < nums.length && sum < s) sum += nums[end++];
            if (sum < s) {
                if (min == Integer.MAX_VALUE)
                    return 0;
                break;
            }

            while (start < end && sum >= s) sum -= nums[start++];
            min = Math.min(min, end - start + 1);
        }
        return min;

    }


    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        int[] sums = new int[nums.length + 1];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            int end = binarySearch(sums, i, sums.length - 1, sums[i] + s);
            if(end == sums.length)
                break;
            min=Math.min(min,end - i);
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int binarySearch(int[] nums, int lo, int hi, int key) {
        while (lo <= hi) {//如果没有找到key，则nums[hi]<key<nums[lo]
            int mid = (lo + hi) / 2;
            if (nums[mid] == key) {
                return mid;
            } else if (nums[mid] > key) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    @Test
    public void test() {
        int[] arr = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, arr));
    }

    @Test
    public void testBinarySearch() {
        int[] arr = {0, 2, 5, 6, 8, 12, 15};
        System.out.println(binarySearch(arr, 0, arr.length, 6));
    }
}
