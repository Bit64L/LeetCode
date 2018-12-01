import org.junit.Test;

public class ReverseBits190 {
    public int reverseBits(int n) {
        int res = 0;
        for(int i=0;i<32;i++){
            res <<= 1;
            res |= n & 1;
            n >>= 1;
        }
        return res;
    }
    @Test
    public void test(){
        System.out.println(reverseBits(1));
    }
}
