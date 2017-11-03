public class Solution {
    /*
     * @param source: A source string
     * @param target: A target string
     * @return: An integer as index
     */
    // public int strStr2(String source, String target) {
        // write your code here
    // }
    
    private int getPartialMatch(String str) {

        int result = 0;

        HashSet<String> prefix = new HashSet<>();

        for (int i = 1; i < str.length(); i++) {
            prefix.add(str.substring(0, i));
        }

        for (int i = 2; i <= str.length(); i++) {
            String suffix = str.substring(1, i);
            if (prefix.contains(suffix)) {
                result = Math.max(result, suffix.length());
            }
        }
        return result;
    }

    private int[] getPartialMatchArray(String str) {

        int[] result = new int[str.length() + 1];
        result[0] = 0;
        for (int i = 1; i <= str.length(); i++) {
            result[i] = getPartialMatch(str.substring(0, i));
        }
        return result;
    }

    public int strStr2(String source, String target) {

        int[] partial = new int[target.length()];
        partial = getPartialMatchArray(target);

        int i = 0;
        for (; i <= source.length() - target.length(); i++) {
            int curr = i, j = 0, steps = 0;
            for (; j < target.length(); j++) {
                // System.out.println(curr);
                if (source.charAt(curr) == target.charAt(j)) {
                    curr++;
                } else {
                    // System.out.println(j);
                    steps = j - partial[j];
                    if (steps != 0) {
                        i = i + steps - 1;
                    }
                    // i = i + steps;
                    break;
                }
            }
            if (j == target.length()) return i;
        }

        return -1;
    }
    
    
}