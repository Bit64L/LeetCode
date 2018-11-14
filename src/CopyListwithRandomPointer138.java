import common.RandomListNode;
import org.junit.Test;

import java.util.HashMap;

public class CopyListwithRandomPointer138 {
    public RandomListNode copyRandomList1(RandomListNode head) {
        if(head == null) return null;
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode curr = head, currNew=dummy;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        while(curr!=null){
            if(!map.containsKey(curr))
                map.put(curr,new RandomListNode(curr.label));
            if(curr.random != null && !map.containsKey(curr.random))
                map.put(curr.random, new RandomListNode(curr.random.label));
            currNew.next = map.get(curr);
            currNew = currNew.next;
            currNew.random = map.get(curr.random);
            curr = curr.next;
        }
        return dummy.next;
    }

    public RandomListNode copyRandomList2(RandomListNode head) { // O(N) O(1)
        if (head == null) return null;
        RandomListNode curr = head;
        while (curr != null) {// create new node(interWave)
            RandomListNode tmp = new RandomListNode(curr.label);
            tmp.next = curr.next;
            curr.next = tmp;
            curr = tmp.next;
        }

        curr = head;
        while (curr != null) {// add random
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        curr = head;
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode newCurr = dummy;
        while(curr != null){
            newCurr.next = curr.next;
            newCurr = newCurr.next;
            curr.next = curr.next.next;
            curr = curr.next;
        }
        return dummy.next;
    }

    HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
    public RandomListNode copyRandomList(RandomListNode head) { // O(N) O(1)
        if(head == null) return null;
        if(map.containsKey(head)){
            return map.get(head);
        }
        RandomListNode newNode = new RandomListNode(head.label);
        map.put(head,newNode);
        newNode.next = copyRandomList(head.next);
        newNode.random = copyRandomList(head.random);
        return newNode;
    }


        @Test
    public void test(){
        RandomListNode node1 = new RandomListNode(-1);
        RandomListNode node2 = new RandomListNode(-1);
        node2.random = node1;
        node1.next  = node2;
        copyRandomList(node1);
    }

}
