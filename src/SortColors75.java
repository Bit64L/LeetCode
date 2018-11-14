public class SortColors75 {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int N = nums.length;
        int left, right, i;
        for(i=0,left=0,right = N-1;i<= right;){
            if(nums[i] == 0){
                nums[i++] = nums[left];
                nums[left++] = 0;
            }else if(nums[i] == 2){
                nums[i] = nums[right];
                nums[right--] = 2;
            }else
                i++;
        }
    }
}
