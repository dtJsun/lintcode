public class Solution {
    /*
     * @param : A string
     * @param : A set of word
     * @return: the number of possible sentences.
     */
    public int wordBreak3(String s, Set<String> dict) {
        // Write your code here
        return dfs(s, dict, 0);
    }

    int dfs(
        String s,
        Set<String> dict,
        int start
    ) {

        if (s.length() == 0) {
            return 0;
        }
        
        int result = 0;
        for (int i = start + 1; i <= s.length(); i++) {
            String s1 = s.substring(start, i);
            String s2 = s.substring(i);

            if (dict.contains(s1)) {
                if (s2.length() == 0) {
                    result += 1;
                } else {
                    result += dfs(s, dict, i);
                }
            }
        }
        return result;
    }

}