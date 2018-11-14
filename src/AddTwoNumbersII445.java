import common.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class AddTwoNumbersII445 {
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode curr1 = l1, curr2 = l2, pre=null;
        int count =0;
        while(curr1!=null && curr2!=null){
            int sum = count+curr1.val+curr2.val;
            System.out.println(sum);
            count = sum / 10;
            curr1.val = sum % 10;
            pre = curr1;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        if(curr2 != null){
            pre.next = curr2;
            curr1 = curr2;
        }
        while(curr1!=null){
            int sum = count + curr1.val;
            count = sum / 10;
            curr1.val = sum %10;
            pre = curr1;
            curr1 = curr1.next;
        }
        if(count != 0)
            pre.next = new ListNode(count);
        return reverse(l1);

    }
    public ListNode reverse(ListNode head){
        ListNode dummy = new ListNode(-1);
        ListNode curr = head;
        while(curr!=null){
            ListNode tmp = curr;
            curr = curr.next;
            tmp.next = dummy.next;
            dummy.next = tmp;
        }
        return dummy.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Deque<ListNode> stack1 = new ArrayDeque<>();
        Deque<ListNode> stack2 = new ArrayDeque<>();
        while(l1!=null){
            stack1.push(l1);
            l1 = l1.next;
        }
        while(l2!=null){
            stack2.push(l2);
            l2 = l2.next;
        }

        ListNode dummy = new ListNode(1);
        int count = 0;
        while(!stack1.isEmpty() || !stack2.isEmpty() || count != 0){
            int sum = count;
            if(!stack1.isEmpty()) sum+=(stack1.pop()).val;
            if(!stack2.isEmpty()) sum+=(stack2.pop()).val;
            count = sum / 10;
            ListNode tmp = new ListNode(sum % 10);
            tmp.next = dummy.next;
            dummy.next = tmp;
        }

        return dummy.next;

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        int sum = listToInt(l1) + listToInt(l2); // 溢出
        ListNode head = null;
        if(sum == 0) return new ListNode(0);
        System.out.println(sum);
        while(sum != 0){
            ListNode tmp = new ListNode(sum%10);
            sum /= 10;
            tmp.next = head;
            head = tmp;
        }
        return head;
    }
    public int listToInt(ListNode head){
        if(head == null) return 0;
        int sum = 0;
        while(head!=null){
            sum=sum * 10 + head.val;
            head = head.next;
        }

        return sum;
    }

}
