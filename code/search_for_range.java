public class Solution {
    /*
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here

        if (A == null || A.length == 0) return new int[]{-1, -1};

        if (target > A[A.length - 1]) return new int[]{-1, -1};

        int index = getIndex(A, target);
        if (index == -1) return new int[]{-1, -1};
        int first = index;
        int second = index;
        while (first >= 0 && A[first] == target) {
            first--;
        }
        while (second < A.length && A[second] == target) {
            second++;
        }

        return new int[]{first + 1, second - 1};
    }

    private int getIndex(int[] A, int target) {

        int start = 0, end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[start] == target) return start;
        if (A[end] == target) return end;

        return -1;
    }


}