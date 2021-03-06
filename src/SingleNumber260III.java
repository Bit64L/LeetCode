public class SingleNumber260III {
    public int[] singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        int xor = 0;
        for(int num : nums)
            xor ^= num;
        xor &= -xor;
        int[] res = {0, 0};
        for(int num : nums){
            if((xor & num) == 0){
                res[0] ^= num;
            }else{
                res[1] ^= num;
            }
        }
        return res;
    }

}
