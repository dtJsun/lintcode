public class Solution {
    /*
     * @param A: a string
     * @param B: a string
     * @return: a boolean
     */
    public boolean Permutation(String A, String B) {
        // write your code here

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length(); i++) {
            if (!map.containsKey(A.charAt(i))) {
                map.put(A.charAt(i), 1);
            } else {
                map.put(A.charAt(i), map.get(A.charAt(i)) + 1);
            }
        }

        for (int i = 0; i < B.length(); i++) {
            if (!map.containsKey(B.charAt(i))) {
                return false;
            }
            int count = map.get(B.charAt(i));
            count--;
            if (count < 0) {
                return false;
            }
            map.put(B.charAt(i), count);
        }
        
        for (char c : map.keySet()) {
            if (map.get(c) > 0) {
                return false;
            }
        }
        
        return true;

    }
}