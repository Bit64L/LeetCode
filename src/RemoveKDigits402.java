import java.util.Stack;

public class RemoveKDigits402 {
    public String removeKdigits(String num, int k) {
        int size = num.length();
        if(size == k) return "0";
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<size;i++){
            while(!stack.isEmpty() && stack.peek() > num.charAt(i) && k>0){
                stack.pop(); k--;
            }
            stack.push(num.charAt(i));
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            if(k>0){
                stack.pop();
                k--;
            }else
                res.append(stack.pop());
        }
        res = res.reverse();
        int i;
        for(i=0;i<res.length() && res.charAt(i) == '0';i++) continue;
        return i >= res.length() ? "0" : res.substring(i);

    }
}
