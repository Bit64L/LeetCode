import java.util.HashMap;
import java.util.Map;

public class LRUCache146 {
    class Node{
        int key;
        int val;
        Node pre;
        Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.pre = this.next = null;
        }
    }

    private Map<Integer, Node> map;
    private Node dummyHead;
    private Node dummyTail;
    private int capacity;

    public LRUCache146(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(this.capacity);
        dummyHead = new Node(-1,100);
        dummyTail = new Node(-1, 100);
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            updateKey(key);
            return map.get(key).val;
        }
        return -1;

    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            updateKey(key);
            map.get(key).val = value;
        }else{
            if(map.size() == capacity){
                Node curr = dummyHead.next;
                dummyHead.next = curr.next.next;
                curr.next.pre = dummyHead;
                map.remove(key);
            }
            Node curr = new Node(key, value);
            curr.next = dummyTail;
            curr.pre = dummyTail.pre;
            dummyTail.pre.next = curr;
            dummyTail.pre = curr;

            map.put(key, curr);
        }

    }


    public void updateKey(int key){
        Node curr = map.get(key);
        curr.pre.next = curr.next;
        curr.next.pre = curr.pre;

        curr.next = dummyTail;
        curr.pre = dummyTail.pre;
        dummyTail.pre.next = curr;
        dummyTail.pre = curr;
    }
}
