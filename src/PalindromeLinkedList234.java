import common.ListNode;
import org.junit.Test;

public class PalindromeLinkedList234 {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head, fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode dummy = new ListNode(-1);
        fast = slow.next;
        while(fast!=null){
            ListNode tmp = fast;
            fast = fast.next;
            tmp.next = dummy.next;
            dummy.next = tmp;
        }

        fast = dummy.next;
        slow = head;
        while(fast != null){
            if(slow.val != fast.val)
                return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }


    @Test
    public void test(){
        ListNode head = ListNode.create("0,0");
        isPalindrome(head);
    }
}
