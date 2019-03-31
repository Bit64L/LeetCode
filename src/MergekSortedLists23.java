import common.ListNode;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedLists23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
        });
        for(ListNode node : lists){
            if(node != null)
                pq.add(node);
        }
        ListNode dummy = new ListNode(-1);
        ListNode work = dummy;
        while(!pq.isEmpty()){
            ListNode tmp = pq.poll();
            if(tmp.next != null) pq.add(tmp.next);
            work.next = tmp;
            tmp.next = null;
            work = work.next;
        }
        return dummy.next;

    }



    public ListNode mergeKLists1(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        ListNode[] pointers = new ListNode[lists.length];
        for(int i=0;i<pointers.length;i++){
            pointers[i] = lists[i];
        }
        ListNode head = new ListNode(0), work = head,next;
        while((next = findMin(pointers))!= null){
            work.next = next;
            work = work.next;
        }
        return head.next;
    }
    public ListNode findMin(ListNode[] pointers){
        int min = 0;
        for(int i=0;i<pointers.length;i++){
            if(pointers[i] == null) continue;
            if(pointers[min] == null){
                min = i;
                continue;
            }
            if(pointers[min].val > pointers[i].val)
                min = i;
        }
        ListNode tmp = pointers[min];
        if(tmp != null) pointers[min] = pointers[min].next;
        return tmp;
    }

    @Test
    public void test(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        node1.next=node2;
        node2.next = node3;

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;

        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(6);
        node7.next = node8;

        ListNode[] list = new ListNode[3];
        list[0] = node1;
        list[1] = node4;
        list[2] = node7;

        mergeKLists(list);


    }
}
