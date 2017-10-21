public class Solution {
    /*
     * @param A: An integer array
     * @param B: An integer array
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here

        int lenA = A.length;
        int lenB = B.length;

        if ((lenA + lenB) % 2 != 0) {
            return findKth(A, 0, B, 0, (lenA + lenB) / 2);
        } else {
            return (findKth(A, 0, B, 0, (lenA + lenB) / 2) + findKth(A, 0, B, 0, (lenA + lenB) / 2 - 1)) / 2.0;
        }

    }

    private double findKth (
        int[] A,
        int startA,
        int[] B,
        int startB,
        int k
    ) {
        if (startA >= A.length) {
            return B[startB + k - 1];
        }

        if (startB >= B.length) {
            return A[startA + k - 1];
        }

        if (k == 1) {
            return Math.min(A[startA], B[startB]);
        }

        double AKey = startA + k / 2 - 1 < A.length ?
        A[startA + k / 2 - 1] : Integer.MAX_VALUE;

        double BKey = startB + k / 2 - 1 < B.length ?
        B[startB + k / 2 - 1] : Integer.MAX_VALUE;

        if (AKey < BKey) {
            return findKth(A, startA + k / 2, B, startB, k - k / 2);
        } else {
            return findKth(A, startA, B, startB + k / 2, k - k / 2);
        }
    }
}