/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */



public class Merge_Two_Sorted_Lists_21 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            ListNode p = l1;
            ListNode q = l2;
            if (p.val > q.val ) {
                q = q.next;
                l2.next = p;
                p = l2;
                l1 = l2;
            }
            while (p.next != null && q != null) {
                if (p.next.val >= q.val) {
                    ListNode temp = q;
                    q = q.next;
                    temp.next = p.next;
                    p.next = temp;
                    p = p.next;
                }else{
                    p = p.next;
                }
            }
            if(q == null)
                return l1;
            if(p.next == null){
                p.next = q;
            }
            return l1;
        }
    }
}