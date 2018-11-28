import org.junit.Test;

import java.util.Stack;

public class BasicCalculator224 {
    public int calculate(String s) {
        if(s==null || s.length() == 0) return 0;
        int prefix = 1, res = 0, val=0;
        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(chars[i] >= '0' && chars[i] <= '9'){
                val = val*10  + chars[i] - '0';
            }else if(chars[i] == '+' || chars[i] == '-'){
                res += prefix * val;
                val = 0;
                prefix = chars[i] == '+' ? 1 : -1;
            }else if(chars[i] == '('){
                stack.push(res);
                stack.push(prefix);
                res = 0; val = 0; prefix = 1;
            }else if(chars[i] == ')'){
                val = res + val*prefix;
                prefix = stack.pop();
                res = stack.pop();
            }
        }
        if(val != 0)
            res += prefix * val;
        return res;

    }

    @Test
    public void test(){
        calculate("1-(12-10) + 10");
    }
}
