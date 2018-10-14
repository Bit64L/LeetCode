import org.junit.Test;

public class SearchinRotatedSortedArray33 {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;

        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > target){
                if(nums[mid] >= nums[lo]){
                    if(nums[lo] <= target){
                        hi = mid - 1;
                    }else{
                        lo = mid + 1;
                    }
                }else{
                    hi = mid - 1;
                }
            }else{
                if(nums[mid] >= nums[lo]){
                    lo = mid + 1;
                }else{
                    if(nums[hi] >= target){
                        lo = mid + 1;
                    }else{
                        hi = mid - 1;
                    }
                }
            }

        }
        return -1;
    }
    @Test
    public void test(){
        int[] a = {5,6,7,1,2,3,4};
        System.out.println(search(a, 9));

    }
}
