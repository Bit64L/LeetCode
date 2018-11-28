import java.util.HashMap;

public class RotateArray189 {
    public void rotate(int[] nums, int k) {// O(N) O(k)
        if(nums == null || nums.length==0) return;
        int n = nums.length;
        k = k%n;
        int[] copy = new int[k];
        for(int i=0;i<k;i++)
            copy[i] = nums[n-k+i];
        for(int i = nums.length-1;i>=k;i--){
            nums[i] = nums[i-k];
        }
        for(int i=0;i<k;i++){
            nums[i] = copy[i];
        }
    }
    public void rotate1(int[] nums, int k) {// O(kN) O(1)
        if (nums == null || nums.length == 0) return;
        int n = nums.length;
        k = k % n;
        while (k > 0) {
            int tmp = nums[n - 1];
            for (int i = n - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = tmp;
            k--;
        }
    }

    public void rotate2(int[] nums, int k) {// O(N) O(1)
        if(nums == null || nums.length == 0) return;
        int n = nums.length;
        k = k%n;
        reverse(nums, 0, n-k-1);
        reverse(nums, n-k, n-1);
        reverse(nums, 0, n-1);
    }
    public void reverse(int[] nums, int lo, int hi){
        while(lo<hi){
            int tmp = nums[hi];
            nums[hi] = nums[lo];
            nums[lo] = tmp;
            lo++;
            hi--;
        }

    }

}
