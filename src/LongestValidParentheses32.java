import java.util.Stack;

public class LongestValidParentheses32 {
    public int longestValidParentheses(String s) {// O(N)
        if(s == null || s.length() == 0) return 0;
        int max = 0, leftMost = -1;
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='('){
                stack.push(i);
            }else if(!stack.isEmpty()){
                stack.pop();
                if(stack.isEmpty())
                    max = Math.max(max, i-leftMost);
                else
                    max = Math.max(max, i-stack.peek());
            }else{
                leftMost=i;
            }
        }
        return max;
    }
}
