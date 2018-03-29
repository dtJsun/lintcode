/*
1. hash 中hash[key] 指向的是 Node 的prev，因为这样才能做各种操作
2. movetotail中别忘了更新curr 和 curr->next 的hash！！！！！（蠢啊）
3. movetotail很重要，别写错了
*/
class LRUCache {
    
    class Node {
        int key;
        int val;
        Node next;
        public Node(int k, int v) {
            key = k;
            val = v;
            next = null;
        }
    }
    
    private int capacity;
    private Node head;
    private Node tail;
    private int size;
    HashMap<Integer, Node> hash = new HashMap<Integer, Node>();

    public LRUCache(int capacity) {
        head = new Node(0, 0);
        tail = head;
        this.capacity = capacity;
        size = 0;
    }
    
    public int get(int key) {
        if (!hash.containsKey(key)) return -1;
        
        moveToTail(hash.get(key));
        return hash.get(key).next.val;
    }
    
    public void put(int key, int value) {
        
        if (hash.containsKey(key)) {
            moveToTail(hash.get(key));
            hash.get(key).next.val = value;
        } else {
            Node node = new Node(key, value);
            tail.next = node;
            hash.put(key, tail);
            tail = node;
            size++;
            if (size > capacity) {
                hash.remove(head.next.key);
                head.next = head.next.next;
                hash.put(head.next.key, head);
                size--;
            }
        }
    }
    
    private void moveToTail(Node prev) {
        
        if (prev.next == tail) return;
        
        Node curr = prev.next;
        prev.next = curr.next;
        hash.put(curr.next.key, prev);
        tail.next = curr;
        hash.put(curr.key, tail);
        tail = curr;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */