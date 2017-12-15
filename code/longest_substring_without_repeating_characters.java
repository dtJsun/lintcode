public class Solution {
    /*
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here

        // int i = 0, j = 0;
        int ans = Integer.MIN_VALUE;
        int[] map = new int[256];
        int j = 0, i = 0;

        for (; i < s.length(); i++) {
            while (j < s.length() && map[s.charAt(j)] == 0) {
                map[s.charAt(j)] = 1;
                ans = Math.max(ans, j - i + 1);
                j++;
            }
            map[s.charAt(i)] = 0;
        }
        return ans == Integer.MIN_VALUE ? 0 : ans;

    }
}