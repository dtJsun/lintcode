public class Solution {
    /*
     * @param A: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */
    
     
     // start 应该被叫做 smallerValue, end应该被叫做 greaterValue
     // start 代表比target小的值， end 代表比target大的值
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // write your code here

        if (A == null || A.length == 0) return null;
        if (k > A.length) return A;

        int[] ans =  new int[k];

        int index = getFirstIndex(A, target);

        int start = index - 1, end = index;
        
        for (int i = 0; i < k; i++) {
            if (start < 0) {
                ans[i] = A[end++];
            } else if (end >= A.length) {
                ans[i] = A[start--];
            } else {
                if (target - A[start] <= A[end] - target) {
                    ans[i] = A[start--];
                } else {
                    ans[i] = A[end++];
                }
             }
        }
        return ans;
    }

    private int getFirstIndex(int[] A, int target) {

        int start = 0, end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < target) {
                start = mid;
            } else if (A[mid] > target) {
                end = mid;
            } else {
                end = mid;
            }
        }

            if (target <= A[start]) {
                return start;
            }

            if (target <= A[end]) {
                return end;
            }

            return A.length; //只有target >= A[A.length - 1] 的时候才会出现这种情况
    }


}