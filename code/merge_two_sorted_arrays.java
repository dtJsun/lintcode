public class Solution {
    /*
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here

        int[] ans = new int[A.length + B.length];

        int i = 0, j = 0;
        int index = 0;
        while (i < A.length && j < B.length) {
            if (A[i] < B[j]) {
                ans[index] = A[i];
                index++;
                i++;
            } else {
                ans[index] = B[j];
                index++;
                j++;
            }
        }

        if (i == A.length) {
            while (j < B.length) {
                ans[index] = B[j];
                j++;
                index++;
            }
        } else {
            while (i < A.length) {
                ans[index] = A[i];
                i++;
                index++;
            }
        }
        return ans;
    }
}