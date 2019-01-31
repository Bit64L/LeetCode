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
// using stack to process every digits
// Time Complexity O(N)


    public String removeKdigits1(String num, int k) {
        if(num == null || num.length() == 0) return null;
        for(int i = 0; i < k; i++){
            int j;
            StringBuilder sb = new StringBuilder();
            for(j = 0; j < num.length() - 1; j++){
                if(num.charAt(j) > num.charAt(j + 1))
                    break;
            }
            sb.append(num.substring(0, j));
            if(j+1 < num.length()) sb.append(num.substring(j+1));
            // remove leading zero
            j = 0;
            while(j < sb.length() && sb.charAt(j) == '0') sb.deleteCharAt(j);
            num = sb.toString();
        }

        return num.equals("") ? "0" : num;
    }


// Solution:
// remove the first digits bigger than next from left two right
// repeat this operation k times
// Time Complexity: O(k*N)

}
