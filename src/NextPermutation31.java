import java.util.Arrays;

public class NextPermutation31 {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int i = nums.length - 1;
        while(i>=1 && nums[i] <= nums[i-1]) i--;
        if(i < 1)
            Arrays.sort(nums);
        else{
            int minIndex = i;
            for(int j = nums.length-1;j>=i;j--){
                if(nums[j] > nums[i-1] && nums[minIndex] > nums[j])
                    minIndex = j;
            }
            int tmp = nums[minIndex];
            nums[minIndex] = nums[i-1];
            nums[i-1] = tmp;
            Arrays.sort(nums, i, nums.length);
        }
    }
}
