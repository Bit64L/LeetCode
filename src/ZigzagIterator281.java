import java.util.Iterator;
import java.util.List;

public class ZigzagIterator281 {
    private boolean next_i1;
    private Iterator<Integer> i1;
    private Iterator<Integer> i2;

    public ZigzagIterator281(List<Integer> v1, List<Integer> v2) {
        i1 = v1.iterator();
        i2 = v2.iterator();
        next_i1 = true;
    }

    public int next() {
        int next;
        if(next_i1){
            if(i1.hasNext()) next = i1.next();
            else next = i2.next();
        }else{
            if(i2.hasNext()) next = i2.next();
            else next = i1.next();
        }
        next_i1 = !next_i1;
        return next;
    }

    public boolean hasNext() {
        return i1.hasNext() || i2.hasNext();
    }
}
