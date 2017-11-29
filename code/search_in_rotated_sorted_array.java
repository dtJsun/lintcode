public class Solution {
    /*
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        // write your code here

        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (A[start] < A[mid]) { // 说明前半部分是sored的
                if (target >= A[start] && target <= A[mid]) { //如果target在sorted的部分里
                    end = mid;
                } else {
                    start = mid;
                }
            } else { //说明后半部分是sorted的
                if (target >= A[mid] && target <= A[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        
        if (A[start] == target) return start;
        if (A[end] == target) return end;
        return -1;


    }
}