public class UglyNumberII264 {
    public int nthUglyNumber(int n) {
        if(n<=0)
            return 0;
        int i2 = 0, i3=0, i5 = 0;
        int[] nums = new int[n];
        nums[0] = 1;
        for(int i=1;i<n;i++){
            int min = Math.min(Math.min((nums[i2] * 2), nums[i3] * 3), nums[i5] * 5);
            nums[i] = min;
            if (nums[i2] * 2 == min)
                i2++;
            if (nums[i3] * 3 == min)
                i3++;
            if (nums[i5] * 5 == min)
                i5++;
        }
        return nums[n-1];
    }
}
