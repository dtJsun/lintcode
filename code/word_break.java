public class Solution {
    /*
     * @param s: A string
     * @param dict: A dictionary of words dict
     * @return: A boolean
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here

        int maxLength = getMaxLength(dict);

        boolean[] mark = new boolean[s.length() + 1];
        mark[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            mark[i] = false;
            for (int j = 1; j < maxLength && j <= i; j++) {
                if (!mark[i - j]) {
                    continue;
                }
                String curr = s.substring(i - j, i);
                if (dict.contains(curr)) {
                    mark[i] = true;
                    break;
                }
            }
        }
        return mark[s.length()];
    }

    private int getMaxLength(Set<String> dict) {
        int result = 0;
        for (String word : dict) {
            result = Math.max(result, word.length());
        }
        return result;
    }
}