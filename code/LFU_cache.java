public class LFUCache {

    class Element {
        int key;
        int value;
        int frequency;
        public Element(int k, int v) {
            key = k;
            value = v;
            frequency = 1;
        }
    }

    private PriorityQueue<Element> que;
    private int capacity;
    private Comparator<Element> ElementComparator = new Comparator<Element>() {
        public int compare(Element a, Element b) {
            return a.frequency - b.frequency;
        }
    };
    private HashMap<Integer, Element> map;

    /*
    * @param capacity: An integer
    */public LFUCache(int capacity) {
        // do intialization if necessary
        que = new PriorityQueue<Element>(capacity, ElementComparator);
        map = new HashMap<Integer, Element>();
        this.capacity = capacity;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if (map.containsKey(key)) {
            Element curr = map.get(key);
            que.remove(curr);
            curr.value = value;
            curr.frequency += 1;
            que.offer(curr);
        } else {
            Element curr = new Element(key, value);
            que.offer(curr);
            if (que)
        }
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
    }
}