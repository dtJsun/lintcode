public class Solution {
    /*
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        return helper(A, 0, A.length - 1, target);
    }

    private int helper(int[] A, int start, int end, int target) {
        
        if (start > end) return -1;

        if (A[start] <= A[end]) {
            return binarySearch(A, start, end, target);
        } else {
            int mid = (start + end) / 2;
            int left = helper(A, start, mid, target);
            int right = helper(A, mid + 1, end, target);
            return left == -1 ? right : left;
        }
    }

    private int binarySearch(int[] A, int start, int end, int target) {

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