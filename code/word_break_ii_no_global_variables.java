public class Solution {
    /*
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        // write your code here
        
        HashMap<Integer, List<String>> memo = new HashMap<>();
        
        return dfs(s, wordDict, memo, 0);
    }
    
    private List<String> dfs(
        String s,
        Set<String> dict,
        HashMap<Integer, List<String>> memo,
        int start
        ) {
            
            if (memo.containsKey(start)) {
                return memo.get(start);
            }
            
            List<String> result = new ArrayList<>();
            
            for (int i = start + 1; i <= s.length(); i++) {
                
                String s1 = s.substring(start, i);
                String s2 = s.substring(i);
                
                if (dict.contains(s1)) {
                    if (s2.length() == 0) {
                        result.add(s1);
                    } else {
                        List<String> s2Result = dfs(s, dict, memo, i);
                        for (String str : s2Result) {
                            result.add(s1 + " " + str);
                        }
                    }
                }
            }
            memo.put(start, result);
            return result;
    }
}