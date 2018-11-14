import common.ListNode;
import org.junit.Test;

public class LinkedListCycleII142 {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast =fast.next.next;
            if(fast!=null && slow!=null && slow== fast) break;
        }
        if(fast!=null && fast.next !=null){
            slow = head;
            while(slow != fast){// 注意并非slow.val == fast.val
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        return null;
    }//千万注意并非slow.val == fast.val，如果这样链表出现重复值就出错了。

    @Test
    public void test() {
        ListNode head = ListNode.create("-1,-7,7,-4,19,6,-9,-5,-2,-5");
        ListNode tail = get(head, 10);
        tail.next = get(head,9);
        detectCycle(head);
    }

    public ListNode get(ListNode head, int i) {
        ListNode work = head;
        while (i > 1) {
            work = work.next;
            i--;
        }
        return work;
    }
}
