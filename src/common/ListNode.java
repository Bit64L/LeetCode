package common;

import org.junit.Test;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
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
    }
}