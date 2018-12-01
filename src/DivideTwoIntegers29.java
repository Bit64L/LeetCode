public class DivideTwoIntegers29 {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)){
            sign = -1;
        }
        long a = Math.abs((long)dividend), b = Math.abs((long)divisor);

        long res = helper(a,b);

        if(sign * res - 1  == Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return sign * (int)res;
    }
    public long helper(long dividend, long divisor){
        if(dividend < divisor) return 0;
        if(dividend == divisor) return 1;
        long count = 1;
        long sum = divisor;
        while(sum << 1 <= dividend){
            dividend -= sum << 1;
            count <<= 1;
            sum <<= 1;
        }
        if(count == 1) return count + helper(dividend-divisor, divisor);
        return count + helper(dividend, divisor);
    }
}
