public class Solution {
    
        private HashMap<String, List<String>> map = new HashMap<>();
        private Set<String> dict;
    
        /*
         * @param s: A string
         * @param wordDict: A set of words.
         * @return: All possible sentences.
         */
        public List<String> wordBreak(String s, Set<String> wordDict) {
            // write your code here
            this.dict = wordDict;
            map.put("", new ArrayList<>());
            map.get("").add("");
            return dfs(s);
        }
    
        private List<String> dfs(String s) {
    
            if (map.containsKey(s)) {
                return map.get(s);
            }
    
            List<String> result = new ArrayList<>();
    
            for (int i = 1; i <= s.length(); i++) {
    
                String s1 = s.substring(0, i);
                String s2 = s.substring(i);
    
                if (dict.contains(s1)) {
                    List<String> postWords = dfs(s2);
                    for (int j = 0; j < postWords.size(); j++) {
                        if (postWords.get(j).length() == 0) {
                            result.add(s1);
                        } else {
                            result.add(s1 + " " + postWords.get(j));
                        }
                    }
                }
            }
    
            map.put(s, result);
            return result;
        }
    }