import common.ListNode;
import org.junit.Test;

public class ReverseNodesinkGroup25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode work = dummy;
        while(work.next != null){
            ListNode groupHead = work.next;
            ListNode groupTail = work.next;
            for(int i=1;groupTail!=null && i<k;i++){
                groupTail = groupTail.next;
            }
            if(groupTail == null) return dummy.next;
            ListNode right = groupTail.next;

            work.next = null;
            groupTail = groupHead;
            while(groupTail!=right){
                ListNode tmp = groupTail;
                groupTail = groupTail.next;
                tmp.next = work.next;
                work.next = tmp;
            }
            groupHead.next = right;
            work = groupHead;
        }
        return dummy.next;
    }

    @Test
    public void test(){
        ListNode head = ListNode.create("1,2,3,4,5");
        reverseKGroup(head, 2);
    }
}
