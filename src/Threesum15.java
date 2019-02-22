import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Threesum15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(i == 0 || nums[i] != nums[i-1]){
                int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
                while(lo < hi){
                    if(nums[hi] + nums[lo] == sum){
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]); tmp.add(nums[lo]); tmp.add(nums[hi]);
                        res.add(tmp);
                        while (lo < hi && nums[lo] == nums[lo+1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi-1]) hi--;
                        hi--;
                    }else if(nums[hi] + nums[lo] < sum){
                        lo++;
                    }else{
                        hi--;
                    }
                }
            }
        }
        return res;
    }
    @Test
    public void test(){
        char[] chars = {'1','2'};
        System.out.println(chars);
    }
}