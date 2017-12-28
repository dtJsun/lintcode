class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashSet<Character> set = new HashSet<>();
        int ans = Integer.MIN_VALUE;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {

            while (j < s.length()) {
                if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                    j++;
                } else {
                    break;
                }
            }
            ans = Math.max(ans, j - i);
            set.remove(s.charAt(i));
        }

        return ans;

    }
}