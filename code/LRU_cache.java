public class LRUCache {
    
        private class Node {
            int key;
            int value;
            Node prev;
            Node next;
            public Node(int v, int k) {
                this.value = v;
                this.key = k;
                this.prev = null;
                this.next = null;
            }
        }
        private HashMap<Integer, Node> map = new HashMap<>();
        private Node head = new Node(-1, -1);
        private Node tail = new Node(-1, -1);
        private int capacity = 0;
    
        /*
        * @param capacity: An integer
        */public LRUCache(int capacity) {
            // do intialization if necessary
            this.capacity = capacity;
            head.next = tail;
            tail.prev = head;
        }
    
        /*
         * @param key: An integer
         * @return: An integer
         */
        public int get(int key) {
            // write your code here
            if (!map.containsKey(key)) {
                return -1;
            }
    
            Node node = map.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            moveToHead(node);
    
            return node.value;
        }
    
        /*
         * @param key: An integer
         * @param value: An integer
         * @return: nothing
         */
        public void set(int key, int value) {
            // write your code here
            if (get(key) != -1) {
                map.get(key).value = value;
                return;
            }
            
            if (map.size() < this.capacity) {
                Node node = new Node(value, key);
                map.put(key, node);
                moveToHead(node);
                return;
            }
    
            Node del = tail.prev;
            del.prev.next = tail;
            tail.prev = del.prev;
            map.remove(del.key);
    
            Node node = new Node(value, key);
            map.put(key, node);
            moveToHead(node);
            return;
        }
        
        private void moveToHead(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }
    }