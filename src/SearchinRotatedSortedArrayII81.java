import org.junit.Test;

public class SearchinRotatedSortedArrayII81 {
    public boolean search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target)
                return true;
            else if (nums[mid] > target) {
                if (nums[mid] > nums[lo] || nums[mid] > nums[hi]) { // 左边有序
                    if (nums[lo] <= target) {
                        hi = mid - 1;
                    } else {
                        lo = mid + 1;
                    }
                } else if(nums[mid] < nums[hi] || nums[mid] < nums[lo]){//右边有序
                    hi = mid - 1;
                }else{//nums[lo] == nums[mid] == nums[hi]
                    hi--;
                }
            } else {
                if (nums[mid] > nums[lo] || nums[mid] > nums[hi] ) {//左边有序
                    lo = mid + 1;
                } else if(nums[mid] < nums[hi] || nums[mid] < nums[lo]){//右边有序
                    if (nums[hi] >= target) {
                        lo = mid + 1;
                    } else {
                        hi = mid - 1;
                    }
                }else{
                    hi--;
                }
            }
        }
        return false;
    }

    @Test
    public void test(){
        String str = "123";
        int[] arr = {3,1};
        System.out.println(search(arr,3));
    }
}