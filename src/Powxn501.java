public class Powxn501 {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        x = n > 0? x : 1/x;
        return helper(x,Math.abs((long)n));
    }
    public double helper(double x, long n){
        if(n == 1) return x;
        double res = helper(x, n/2);
        return n  % 2 == 0 ? res*res : res*res*x;
    }

    public double myPow1(double x, int n) {
        if(n == 0) return 1;
        x = n > 0? x : 1/x;
        long exp = Math.abs((long)n);
        double product = x;
        double res = 1;
        for(;exp>0;exp/=2){
            if(exp % 2 == 1) res *= product;
            product *= product;
        }
        return res;
    }
}
