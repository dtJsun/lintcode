public class Trie {

    class Node {
        char ch;
        Node[] next = new Node[26];
        boolean isEnd = false;
        public Node(char c) {
            this.ch = c;
        }
    }

    private Node head;

    public Trie() {
        // do intialization if necessary
        this.head = new Node('*');
    }

    /*
     * @param word: a word
     * @return: nothing
     */
    public void insert(String word) {
        // write your code here
        if (word == null || word.length() == 0) return;

        Node parent = head;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (parent.next[c - 'a'] != null) {
                parent = parent.next[c - 'a'];
                continue;
            }
            Node curr = new Node(c);
            parent.next[c - 'a'] = curr;
            parent = parent.next[c - 'a'];
        }
        parent.isEnd = true;
    }

    /*
     * @param word: A string
     * @return: if the word is in the trie.
     */
    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;

        // write your code here
        Node parent = head;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // System.out.println(c);
            if (parent.next[c - 'a'] == null) {
                return false;
            } else {
                parent = parent.next[c - 'a'];
            }
        }
        return parent.isEnd;
    }

    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        // write your code here
        Node parent = head;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            // System.out.println(c);
            if (parent.next[c - 'a'] == null) {
                return false;
            }
            parent = parent.next[c - 'a'];
        }
        return true;
    }
}