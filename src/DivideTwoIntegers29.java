public class DivideTwoIntegers29 {
    public int divide(int dividend, int divisor) {
        int sign = (dividend >>> 31) ^ (divisor >>> 31);
        long a = Math.abs((long)dividend), b = Math.abs((long)divisor);
        long res = sign > 0 ? -helper(a, b) : helper(a, b);
        if(res - 1 == Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int) res;
    }

    public long helper(long a, long b){
        if(a < b)
            return 0;
        long sum = 0, count = 1;
        long oriB = b;
        while(a >= b){
            a -= b;
            sum += count;
            b <<= 1;
            count <<= 1;

        }
        return sum + helper(a, oriB);
    }
}

/*
用减法计算除法
优化点：指数扩大，类似快速幂思想
 */