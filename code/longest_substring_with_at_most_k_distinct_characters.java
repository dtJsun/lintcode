public class Solution {
    /*
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        
        if (s == null || s.length() == 0) return 0;

        int i = 0, j = 0;
        int ans = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();

        for (; i < s.length(); i++) {
            while (j < s.length() && map.size() <= k) {
                char curr = s.charAt(j);
                if (!map.containsKey(curr)) {
                    map.put(curr, 1);
                } else {
                    map.put(curr, map.get(curr) + 1);
                }
                ans = Math.max(ans, j - i);
            }
            char head = s.charAt(i);
            map.put(head, map.get(head) - 1);
            if (map.get(head) == 0) {
                map.remove(head);
            }
        }
        
        return ans == Integer.MIN_VALUE ? 0 : ans;
    }
}