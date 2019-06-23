public class Sqrtx69 {
    public int mySqrt(int x) {
        if(x == 0 || x == 1) return x;
        int lo = 1, hi = x;
        while(lo < hi){
            int mid = (lo + hi) / 2;
            if(mid == x/mid){
                return mid;
            }else if(mid < x/mid){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }

        return hi - 1;
    }
}

/*
*
* 注意点
* 1. lo < hi, 如果要使得lo == hi所得结果不是答案，一定要使得初始val[hi] > res
* 2. lo = mid + 1, hi = mid
*/

