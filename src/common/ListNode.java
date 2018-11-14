package common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode create(String str) {//"-1,-7,7,-4,19,6,-9,-5,-2,-5"
        String[] strs = str.split(",");
        ListNode head = new ListNode(Integer.parseInt(strs[0]));
        int i = 1;
        ListNode curr = head;
        while (i < strs.length) {
            curr.next = new ListNode(Integer.parseInt(strs[i]));
            curr = curr.next;
            i++;
        }
        return head;
    }
}