import java.util.Stack;

public class MinStack155 {
    private Stack<Integer> stack;
    private int min;
    /** initialize your data structure here. */
    public MinStack155() {
        stack = new Stack<>();
        min = 0x7fffffff;
    }

    public void push(int x) {
        if(min > x) min = x;
        stack.push(x);
    }

    public void pop() {
        if(top() != min) stack.pop();
        else{
            Stack<Integer> tmp = new Stack<>();
            min = 0x7fffffff;
            for(int i = stack.size(); i >= 1; i--){
                if(stack.peek() == min){
                    stack.pop();
                }else{
                    if(min > stack.peek()) min = stack.peek();
                    tmp.push(stack.pop());
                }
            }
            for(int i = tmp.size(); i >= 1; i--)
                stack.push(tmp.pop());
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
