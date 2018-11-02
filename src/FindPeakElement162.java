import org.junit.Test;

public class FindPeakElement162 {
    public int findPeakElement(int[] nums) {
        int lo=0, hi = nums.length-1;
        while(lo<hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid]>nums[mid+1]){
                hi=mid;
            }else if(nums[mid]<nums[mid+1]){
                lo = mid + 1;
            }
        }
        return lo;
    }

    @Test
    public void test(){
        int[] arr = {1,2,1,3,5,6,4};
        System.out.println(findPeakElement(arr));
    }
}
