public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        HashSet<String> mark = new HashSet<>();
        dict.add(start);
        dict.add(end);
        int ans = 1;
            Queue<String> que = new LinkedList<>();
            que.offer(start);
            
            while (!que.isEmpty()) {
                int size = que.size();
                for (int i = 0; i < size; i++) {
                    String curr = que.poll();
                    mark.add(curr);
                    Set<String> nextWords = getNextWords(curr, dict);
                    for (String word : nextWords) {
                        if (!mark.contains(word)) {
                            if (word.equals(end)) {
                                return ans + 1;
                            }
                            que.offer(word);
                        }
                    }
                    
                }
                ans++;
            }
        return 0;
    }
    
    private Set<String> getNextWords(String curr, Set<String> dict) {
        
        Set<String> result = new HashSet<>();
        
        char[] ch = new char[curr.length()];
        for (int i = 0; i < curr.length(); i ++) {
            ch[i] = curr.charAt(i);
        }
        
        for (int i = 0; i < curr.length(); i++) {
            char temp = ch[i];
            for (int j = 0; j < 26; j++) {
                ch[i] = (char)('a' + j);
                String s = new String(ch);
                if (dict.contains(s) && !s.equals(curr)) {
                    result.add(s);
                }
                
            }
            ch[i] = temp;
        }
        
        return result;
    }
    
}