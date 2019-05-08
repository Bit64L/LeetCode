public class FindFirstandLastPositionofElementinSortedArray34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if(nums == null || nums.length == 0) return res;
        int first = -1, last = -1;
        int lo = 0, hi = nums.length - 1;
        int m = 0;

        while(lo < hi){
            m = (lo + hi) / 2;
            if(nums[m] == target) break;
            else if(nums[m] < target) lo = m + 1;
            else hi = m;
        }
        m = (lo + hi) / 2;
        if(nums[m] == target){
            first = last = m;
            while(first >= 0 && nums[first] == target) first--;
            while(last < nums.length && nums[last] == target) last++;
            res[0] = first + 1;
            res[1] = last - 1;
        }
        return res;
    }
}

