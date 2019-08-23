import org.junit.Test;

public class DivideTwoIntegers29 {
//    public int divide(int dividend, int divisor) {
//        int sign = (dividend >>> 31) ^ (divisor >>> 31);
//        long a = Math.abs((long)dividend), b = Math.abs((long)divisor);
//        long res = sign > 0 ? -helper(a, b) : helper(a, b);
//        if(res - 1 == Integer.MAX_VALUE) return Integer.MAX_VALUE;
//        return (int) res;
//    }
//
//    public long helper(long a, long b){
//        if(a < b)
//            return 0;
//        long sum = 0, count = 1;
//        long oriB = b;
//        while(a >= b){
//            a -= b;
//            sum += count;
//            b <<= 1;
//            count <<= 1;
//
//        }
//        return sum + helper(a, oriB);
//    }

    public int divide(int dividend, int divisor) {
        int sign = (dividend >> 31) ^ (divisor >> 31);
        sign = sign == 0 ? 1 : -1;
        long a = Math.abs(dividend);
        long b = Math.abs(divisor);

        long res = helper(a, b);
        res = sign * res;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
            return Integer.MAX_VALUE;

        return (int) res;
    }

    public long helper(long a, long b) {
        if (a < b) return 0;

        long res = 0;

        int count = 1;
        while (count * b <= a) {
            a -= count * b;
            res += count;
            count *= count;
        }

        return res += helper(a, b);
    }
    @Test
    public void test(){
        divide(-2147483648
                ,-1);
    }
}

/*
用减法计算除法
优化点：指数扩大，类似快速幂思想
 */