import common.ListNode;
import org.junit.Test;

public class PartitionList86 {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(1);
        ListNode curr1 = dummy1, curr2 = dummy2;
        while(head!=null){
            if(head.val < x){
                curr1.next = head;
                curr1 = curr1.next;
            }else{
                curr2.next=head;
                curr2 = curr2.next;
            }
            head= head.next;
        }
        curr2.next = null;
        curr1.next = dummy2.next;
        return dummy1.next;
    }

    @Test
    public void test() {
        String str = "1,4,3,2,5,2";
        String[] strs = str.split(",");
        ListNode head = new ListNode(Integer.parseInt(strs[0]));
        int i = 1;
        ListNode curr = head;
        while (i < strs.length) {
            curr.next = new ListNode(Integer.parseInt(strs[i]));
            curr = curr.next;
            i++;
        }
        partition(head, 3);
    }
}
