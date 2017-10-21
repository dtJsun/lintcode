public class Solution {
    /*
     * @param s: a string
     * @param dict: a set of n substrings
     * @return: the minimum length
     */
    public int minLength(String s, Set<String> dict) {
        // write your code here
        
        Queue<String> que = new LinkedList<>();
        HashSet<String> mark = new HashSet<>();
        
        int min = s.length();
        que.offer(s);
        
        while (!que.isEmpty()) {
            String curr = que.poll();
            
            for (String word : dict) {
                int found = curr.indexOf(word);
                while (found != -1) {
                    String newS = curr.substring(0, found) + curr.substring(found + word.length(), curr.length());
                    
                    if (!mark.contains(newS)) {
                        min = Math.min(newS.length(), min);
                        mark.add(newS);
                        que.offer(newS);
                    }
                    found = curr.indexOf(word, found + 1);
                }
            }
            
        }
        return min;
    }
}