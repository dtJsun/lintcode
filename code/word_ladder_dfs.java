public class Solution {
    
        private int ladderLen = Integer.MAX_VALUE;
        /*
         * @param start: a string
         * @param end: a string
         * @param dict: a set of string
         * @return: An integer
         */
        public int ladderLength(String start, String end, Set<String> dict) {
            // write your code here
            if (start == end) return 0;
            dict.add(start);
            dict.add(end);
            int wordLen = start.length();
            int[][] allWords = new int[wordLen][26];
            HashMap<String, Integer> mark = new HashMap<>();

            preProcess(wordLen, dict, allWords, mark);
            
            dfs(start, end, allWords, dict, 1, mark);
    
            return this.ladderLen == Integer.MAX_VALUE ? 0 : this.ladderLen;
        }
    
        private void preProcess(int wordLen, Set<String> dict, int[][] allWords, HashMap<String, Integer> mark) {
    
            for (String s : dict) {
                mark.put(s, 0);
                char[] sStr = s.toCharArray();
                for (int i = 0; i < wordLen; i++) {
                    allWords[i][sStr[i] - 'a'] = 1;
                }
            }
        }
    
        private void dfs(
            String curr,
            String target,
            int[][] allWords,
            Set<String> dict,
            int currLen,
            HashMap<String, Integer> mark
        ) {
    
            if (curr.equals(target)) {
                this.ladderLen = Math.min(currLen, this.ladderLen);
                return;
            }
            
            char[] tempCurr = curr.toCharArray();
            for (int i = 0; i < curr.length(); i++) {
                for (int j = 0; j < 26; j++) {
                    if (allWords[i][j] == 1) {
                        char temp = tempCurr[i];
                        tempCurr[i] = (char)('a' + j);
                        String newCurr = new String(tempCurr);
                        if (dict.contains(newCurr) && mark.get(newCurr) == 0) {
                            mark.put(newCurr, 1);
                            dfs(newCurr, target, allWords, dict, currLen + 1, mark);
                            mark.put(newCurr, 0);
                        }
                        tempCurr[i] = temp;
                    }
                }
    
            }
    
        }
    
    }