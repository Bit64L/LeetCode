import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */


public class Valid_Parentheses_20 {

    private Solution solution = new Solution();

    class Solution {
        public boolean isValid(String s) {
            if (s == null || s.equals("")) return false;
            Stack<Character> stack = new Stack<>();
            for (Character c : s.toCharArray()) {
                if (c == '(' || c == '[' || c == '{') stack.push(c);
                else {
                    if (stack.isEmpty()) return false;//如果stack为空，peek()抛出异常
                    if (c == ')') {
                        if (stack.peek() == '(') stack.pop();
                        else return false;
                    } else if (c == ']') {
                        if (stack.peek() == '[') stack.pop();
                        else return false;
                    } else if (c == '}') {
                        if (stack.peek() == '{') stack.pop();
                        else return false;
                    } else
                        return false;
                }

            }
            if (stack.isEmpty()) return true;
            return false;
        }
    }

    public static void main(String[] args) {
        Valid_Parentheses_20 valid_parentheses_20 = new Valid_Parentheses_20();
        System.out.println(valid_parentheses_20.solution.isValid("()"));
    }
}
