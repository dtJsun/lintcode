public class Solution {
    /**
     * @param s a string
     * @return an integer
     */
    public int minCut(String s) {
        // write your code here
        
        HashMap<Integer, Integer> memo = new HashMap<>();
        return dfs(s, 0, s.length() - 1, memo);
    }

    private int dfs(String s, int start, int end, HashMap<Integer, Integer> memo) {

        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        if (isPalindrome(s, start, end)) {
            return 0;
        }

        int result = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            // String s1 = s.substring(0, i);
            // String s2 = s.substring(i);

            if (isPalindrome(s, start, i)) {
                if (end == start) {
                    result = 0;
                } else {
                    int temp = 1 + dfs(s, i + 1, end, memo);
                    result = Math.min(result, temp);
                }
            }
            
        }
        memo.put(start, result);
        return result;

    }

    private boolean isPalindrome(String s, int start, int end) {
        if (end <= start) {
            return true;
        }
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

};