import org.junit.Test;

public class MaximumProductSubarray152 {
    int maxProduct(int nums[]) {
        int r = nums[0];
        int min = r, max = r;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = min;
                min = max;
                max = tmp;
            }
            max = Math.max(nums[i], nums[i] * max);
            min = Math.max(nums[i], nums[i] * min);

            if (r < max) {
                r = max;
            }
        }
        return r;
    }

    @Test
    public void test() {
        int[] arr = {2, -3};
        System.out.println(maxProduct(arr));
    }
}
