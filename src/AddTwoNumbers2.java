import common.ListNode;

public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = l1;
        l1 = dummyHead;
        int sum = 0, carry = 0;
        while(l1.next != null && l2 != null){
            l1.next.val += l2.val + carry;
            carry = l1.next.val / 10;
            l1.next.val = l1.next.val % 10;

            l1 = l1.next; l2 = l2.next;
        }
        if(l1.next == null) l1.next = l2;
        while(l1.next != null){
            l1.next.val += carry;
            carry = l1.next.val / 10; l1.next.val %= 10;
            l1 = l1.next;
        }
        if(carry != 0){
            l1.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
