

public class HouseRobberII213 {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        return Math.max(rob(nums,1, nums.length -1),rob(nums,0, nums.length-2));
    }

    public int rob(int[] nums, int lo, int hi) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int rob =0, notRob = 0;
        for(int i=lo;i<=hi;i++){
            int r = rob, nr = notRob;
            rob = nums[i] + nr;
            notRob = Math.max(r,nr);
        }
        return Math.max(rob, notRob);
    }

    public int rob1(int[] nums){
        if(nums == null || nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        int rRf=1, nrRf=0,rNrf=0,nrNrf=0;
        for(int i=1;i<nums.length;i++){
            int rrf = rRf, nrrf = nrRf, rnrf=rNrf, nrnrf=nrNrf;
            rRf = nums[i] + nrrf;
            nrRf = Math.max(nrrf, rrf);
            rNrf = nums[i] + nrnrf;
            nrNrf = Math.max(rnrf,nrnrf);
        }
        return Math.max(Math.max(nrRf,rNrf),nrNrf);
    }
}
