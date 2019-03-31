import common.ListNode;

public class ReverseLinkedListII92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int count = 1;
        ListNode first = null, last = null, pf = null , ln = null, work = dummy;

        while(count < m){
            work = work.next;
            count++;
        }

        pf = work; first = work.next;
        work = work.next;
        pf.next = null;
        while(count <= n){
            if(count == n) ln = work.next;
            ListNode tmp = work;
            work = work.next;
            tmp.next = pf.next;
            pf.next = tmp;
            count++;
        }
        first.next = ln;
        return dummy.next;
    }
}
