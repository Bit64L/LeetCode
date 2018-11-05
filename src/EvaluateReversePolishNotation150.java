import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluateReversePolishNotation150 {
    public int evalRPN(String[] tokens) {
        if(tokens==null || tokens.length == 0)
            return 0;
        Deque<String> stack = new ArrayDeque<>();
        int ans = 0;
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+")){
                String b = stack.pop();
                String a = stack.pop();
                stack.push(Integer.parseInt(a)+Integer.parseInt(b)+"");
            }else if(tokens[i].equals("-")){
                String b = stack.pop();
                String a = stack.pop();
                stack.push(Integer.parseInt(a)-Integer.parseInt(b)+"");
            }else if(tokens[i].equals("*")){
                String b = stack.pop();
                String a = stack.pop();
                stack.push(Integer.parseInt(a)*Integer.parseInt(b)+"");
            }else if(tokens[i].equals("/")){
                String b = stack.pop();
                String a = stack.pop();
                stack.push(Integer.parseInt(a)/Integer.parseInt(b)+"");
            }else{
                stack.push(tokens[i]);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    @Test
    public void test(){
        String[] arr = {"0","3","/"};
        evalRPN(arr);
    }
}
