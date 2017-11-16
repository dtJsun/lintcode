public class Solution {
    /*
     * @param A: An array of integers
     * @return: A long integer
     */
    public long permutationIndex(int[] A) {
        // write your code here
        long result = 0;
        for (int i = 0; i < A.length; i++) {
            long count = getCount(i, A);
            result = result + count * getFac(A.length - 1 - i);
        }
        return result + 1;
    }

    private long getCount(int index, int[] A) {

        int count = 0;
        for (int i = index + 1; i < A.length; i++) {
            if (A[i] < A[index]) {
                count++;
            }
        }
        return count;
    }

    private long getFac(int index) {
        long fac = 1;
        for (int i = index; i > 0; i--) {
            fac *= i;
        }
        return fac;
    }
}