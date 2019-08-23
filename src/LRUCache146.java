import java.util.HashMap;
import java.util.Map;

public class LRUCache146 {
    //    class Node{
//        int key;
//        int val;
//        Node pre;
//        Node next;
//        public Node(int key, int val) {
//            this.key = key;
//            this.val = val;
//            this.pre = this.next = null;
//        }
//    }
//
//    private Map<Integer, Node> map;
//    private Node dummyHead;
//    private Node dummyTail;
//    private int capacity;
//
//    public LRUCache146(int capacity) {
//        this.capacity = capacity;
//        map = new HashMap<>(this.capacity);
//        dummyHead = new Node(-1,100);
//        dummyTail = new Node(-1, 100);
//        dummyHead.next = dummyTail;
//        dummyTail.pre = dummyHead;
//    }
//
//    public int get(int key) {
//        if(map.containsKey(key)){
//            updateKey(key);
//            return map.get(key).val;
//        }
//        return -1;
//
//    }
//
//    public void put(int key, int value) {
//        if(map.containsKey(key)){
//            updateKey(key);
//            map.get(key).val = value;
//        }else{
//            if(map.size() == capacity){
//                Node curr = dummyHead.next;
//                dummyHead.next = curr.next.next;
//                curr.next.pre = dummyHead;
//                map.remove(key);
//            }
//            Node curr = new Node(key, value);
//            curr.next = dummyTail;
//            curr.pre = dummyTail.pre;
//            dummyTail.pre.next = curr;
//            dummyTail.pre = curr;
//
//            map.put(key, curr);
//        }
//
//    }
//
//
//    public void updateKey(int key){
//        Node curr = map.get(key);
//        curr.pre.next = curr.next;
//        curr.next.pre = curr.pre;
//
//        curr.next = dummyTail;
//        curr.pre = dummyTail.pre;
//        dummyTail.pre.next = curr;
//        dummyTail.pre = curr;
//    }
    class Node {
        int val;
        int key;
        Node pre;
        Node next;

        public Node(int key, int val, Node pre, Node next) {
            this.key = key;
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }

    private Map<Integer, Node> cache;
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache146(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.head = new Node(-1, -1, null, null);
        this.tail = new Node(-1, -1, null, null);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            System.out.println("hit " + key);
            Node node = cache.get(key);
            moveToFirst(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (!cache.containsKey(key)) {
            if (cache.size() >= this.capacity) {
                //todo: delete from list
                Node node = tail.pre;
                node.next.pre = node.pre;
                node.pre.next = node.next;
                node.next = null;
                node.pre = null;
                //todo: delete from cache
                cache.remove(node.key);
            }
            Node node = new Node(key, value, null, null);
            cache.put(key, node);
            addFirst(node);
        } else {
            Node node = cache.get(key);
            node.val = value;
            moveToFirst(node);
        }
    }

    public void moveToFirst(Node node) {
        // unbound
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.pre = null;
        node.next = null;

        addFirst(node);

    }

    public void addFirst(Node node) {
        // move to first
        node.next = head.next;
        head.next.pre = node;

        head.next = node;
        node.pre = head;
    }

    public static void main(String[] args) {
        LRUCache146 cache = new LRUCache146(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }
}
