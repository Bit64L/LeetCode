import org.junit.Test;

public class PowerofFour342 {
    public boolean isPowerOfFour(int num) {
        double res = Math.log(num) / Math.log(4);
        double ans = res - Math.floor(res);
        return ans == 0;
    }

    @Test
    public void test(){
        isPowerOfFour(16);
    }
}
