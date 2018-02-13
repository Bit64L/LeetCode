/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class Add_Two_Numbers_2 {

    private Solution solution = new Solution();

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

//    class Solution {
//        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//            int count = 0;
//            ListNode ll1 = l1;
//            ListNode ll2 = l2;
//            ListNode ll3 = new ListNode(0);
//            ListNode l3 = ll3;
//            while (ll1 != null && ll2 != null) {
//                ll3.val = (ll1.val + ll2.val + count) % 10;
//                count = (ll1.val + ll2.val + count ) / 10;
//                ll1 = ll1.next;
//                ll2 = ll2.next;
//                if (ll1 != null && ll2 != null) {
//                    ll3.next = new ListNode(0);
//                    ll3 = ll3.next;
//                }
//            }
//            if (!(ll1 == null && ll2 == null)) {
//                ListNode temp = ll1 == null ? ll2 : ll1;
//                int num;
//                while (temp != null) {
//                    num = temp.val;
//                    temp.val = (temp.val + count) % 10;
//                    count = (num + count) / 10;
//                    temp = temp.next;
//                }
//                ll3.next = ll1 == null ? ll2 : ll1;
//                while(ll3.next != null) ll3 = ll3.next;
//            }
//            if (count == 1) ll3.next = new ListNode(1);
//            return l3;
//        }

    //改进算法
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int carry = 0;
            ListNode p = l1;
            ListNode q = l2;
            ListNode ll3 = new ListNode(0);
            ListNode l3 = ll3;
            int x, y;
            while (p != null || q != null) {
                x = p == null ? 0 : p.val;//这种写法速率慢
                y = q == null ? 0 : q.val;
                ll3.val = (x + y + carry) % 10;
                carry = (x + y + carry) / 10;
                if (p != null) p = p.next;
                if (q != null) q = q.next;
                if (p != null || q != null) {
                    ll3.next = new ListNode(0);
                    ll3 = ll3.next;
                }

            }
            if (p == null && q == null && carry == 1)
                ll3.next = new ListNode(1);
            return l3;
        }

        public void test() {
            ListNode l1 = new ListNode(3);
            l1.next = new ListNode(7);

            ListNode l2 = new ListNode(9);
            l2.next = new ListNode(2);

            ListNode l3 = addTwoNumbers(l1, l2);
            while (l3 != null) {
                System.out.print(l3.val + "->");
                l3 = l3.next;
            }
        }
    }

    public static void main(String[] args) {
        Add_Two_Numbers_2 add_two_numbers_2 = new Add_Two_Numbers_2();
        add_two_numbers_2.solution.test();
    }
}
//将两个链表位数统一化来简化代码