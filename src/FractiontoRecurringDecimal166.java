import org.junit.Test;

import java.util.HashMap;

public class FractiontoRecurringDecimal166 {

    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";
        StringBuilder res = new StringBuilder();
        res.append((numerator < 0 ^ denominator < 0) ? "-" : "");
        long num = Math.abs((long)numerator), deno = Math.abs((long)denominator);
        res.append(num / deno);
        if(num % deno == 0)
            return res.toString();
        res.append(".");
        HashMap<Long, Integer> map = new HashMap<>();
        long remainder = num % deno;
        while(remainder != 0){
            if(map.get(remainder) != null){
                res.insert(map.get(remainder), "(");
                res.append(")");
                break;
            }
            map.put(remainder, res.length());
            remainder *= 10;
            res.append(String.valueOf(remainder / deno));
            remainder = remainder % deno;
        }
        return res.toString();
    }

    @Test
    public void test(){
        System.out.println(fractionToDecimal(1,3));
    }
}
