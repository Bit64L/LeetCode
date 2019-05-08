import common.NestedInteger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class FlattenNestedListIterator341 implements Iterator<Integer> {
    Deque<NestedInteger> stack = new ArrayDeque<>();
    public FlattenNestedListIterator341(List<NestedInteger> nestedList) {
        for(int i = nestedList.size() - 1; i >= 0; i--){
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()){
            NestedInteger ni = stack.peek();
            if(ni.isInteger()) return true;
            else{
                stack.pop();
                for(int i = ni.getList().size() - 1; i >= 0; i--){
                    stack.push(ni.getList().get(i));

                }
            }
        }
        return false;
    }
}
