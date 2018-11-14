import common.ListNode;
import org.junit.Test;

public class RotateList61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        int len = 1;
        ListNode work = head;
        while(work.next!=null){
            work = work.next;
            len++;
        }

        k = k%len;
        if(k == 0) return head;
        work.next = head;

        for(int i=len-k;i>1;i--){
            head = head.next;
        }
        work = head.next;
        head.next = null;

        return work;
    }

    @Test
    public void test(){
        ListNode head = ListNode.create("1,2,3,4,5");
        rotateRight(head,2);
    }


}
