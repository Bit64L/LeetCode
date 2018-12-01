import org.junit.Test;

public class BitwiseANDofNumbersRange201 {
    public int rangeBitwiseAnd(int m, int n) {// TLE
        int res = 0;
        for(int i=0;i<32;i++){
            int bit = 1;
            for(int j=m;j<=n;j++){
                bit &= (j >> i) & 1;
                if(bit == 0) break;
            }
            res |= (bit << i);
        }
        return res;
    }

    public int rangeBitwiseAnd1(int m, int n){
        int i = 0;
        for(;m!=n;i++){
            m >>= 1;
            n >>= 1;
        }
        return m << i;
    }

    @Test
    public void test(){
        System.out.println(rangeBitwiseAnd(700000000,
                2147483641));
    }
}
