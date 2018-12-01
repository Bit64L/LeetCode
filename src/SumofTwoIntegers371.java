public class SumofTwoIntegers371 {
    public int getSum(int a, int b) {
        int count = 0, sum=0;
        for(int i=0;i<32;i++){
            int num = count + (a >> i & 1) + (b >> i & 1);
            int tmp = num;
            num %= 2; count = tmp/2;
            sum |= num << i;
        }
        return sum;
    }
}
