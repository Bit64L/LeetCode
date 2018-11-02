import org.junit.Test;

public class FindMinimuminRotatedSortedArrayII154 {
    public int findMin1(int[] nums) { //O(N)
        if (nums == null || nums.length == 0)
            return 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                return nums[i];
        }
        return nums[0];
    }

    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else if (nums[mid] < nums[lo]) {
                hi = mid;
            } else {// nums[lo] == nums[mid] == nums[hi] or nums[lo]<nums[mid]<nums[hi]
                hi--;
            }
        }
        return nums[lo];
    }

    public int findMin2(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        if (nums[hi] > nums[lo]) {// 整体有序
            return nums[0];
        }
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            } else if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else if (nums[mid] < nums[lo]) {
                hi = mid - 1;
            } else {// nums[lo] == nums[mid] == nums[hi]
                hi--;
            }
        }
        return nums[0];
    }

    @Test
    public void test() {
        int[] nums = {5, 5, 5, 5, 5, 5};
        System.out.println(findMin(nums));
    }
}
