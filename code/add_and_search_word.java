public class WordDictionary {
    
        class Node {
            char ch;
            Node[] next = new Node[26];
            boolean isEnd = false;
            public Node(char c) {
                ch = c;
            }
        }
    
        private Node head = new Node('*');
    
        /*
         * @param word: Adds a word into the data structure.
         * @return: nothing
         */
        public void addWord(String word) {
            // write your code here
            if (word == null || word.length() == 0)
                return;
            
            Node curr = head;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (curr.next[ch - 'a'] == null) {
                    curr.next[ch - 'a'] = new Node(ch);
                }
                curr = curr.next[ch - 'a'];
            }
            curr.isEnd = true;
        }
    
        /*
         * @param word: A word could contain the dot character '.' to represent any one letter.
         * @return: if the word is in the data structure.
         */
        public boolean search(String word) {
            // write your code here
            if (word == null || word.length() == 0) return false;
            return searchHelper(word, head);
        }
    
        private boolean searchHelper(String word, Node head) {
            // System.out.println(word);
            if (word.length() == 0)
                return head.isEnd;
    
            Node curr = head;
    
            char ch = word.charAt(0);
            if (ch == '.') {
                for (int j = 0; j < 26; j++) {
                    if (curr.next[j] == null) {
                        continue;
                    }
                    if (searchHelper(word.substring(1), curr.next[j])) {
                        return true;
                    }
                }
            } else {
                if (curr.next[ch - 'a'] == null) {
                    return false;
                }
                return searchHelper(word.substring(1), curr.next[ch - 'a']);
            }
            
            return false;
        }
    
    
    }