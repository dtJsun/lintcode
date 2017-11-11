public class Solution {
    /*
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int[] S) {
        // write your code here

        Arrays.sort(S);
        int count = 0;
        for (int i = S.length - 1; i >= 2; i++) {
            count += greaterThanTarget(S, i - 1, S[i]);
        }
        return count;

    }

    public int greaterThenTarget (int[] S, int end, int target) {

        int count = 0;
        int start = 0;
        while (start < end) {
            int sum = S[start] + S[end];
            if (sum > target) {
                count += (end - start);
                end--;
            } else {
                start++;
            }
        }
        return count;

    }
}