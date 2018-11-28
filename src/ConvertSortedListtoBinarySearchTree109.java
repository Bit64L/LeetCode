import common.ListNode;
import common.TreeNode;
import org.junit.Test;

public class ConvertSortedListtoBinarySearchTree109 {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        ListNode mid = findMid(head);
        TreeNode root = new TreeNode(mid.val);
        root.left = head == mid ? null : sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }
    public ListNode findMid(ListNode head){
        ListNode slow = head, fast = head.next, pre=null;
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(pre != null) pre.next = null;
        return slow;
    }
    @Test
    public void test(){
        ListNode head = ListNode.create("1,2,3,4");
        sortedListToBST(head);
        String testStr = "";
        String[] strs = testStr.split(",");
        System.out.printf("");
    }
}
