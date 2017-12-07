public class Solution {
    /*
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two substrings
     */
    public int maxDiffSubArrays(int[] nums) {
        // write your code here

        int n = nums.length;
        int[] left_max = new int[n];
        int[] left_min = new int[n];
        int[] right_max = new int[n];
        int[] right_min = new int[n];
        int[] copy = new int[n];

        for (int i = 0; i < nums.length; i++) {
            copy[i] = -1 * nums[i];
        }

        // left to right max subarray
        int maxSum = Integer.MIN_VALUE;
        int minSum = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            maxSum = Math.max(maxSum, sum - minSum);
            minSum = Math.min(minSum, sum);
            left_max[i] = maxSum;
        }

        //right to left max subarray
        maxSum = Integer.MIN_VALUE;
        minSum = 0;
        sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += nums[i];
            maxSum = Math.max(maxSum, sum - minSum);
            minSum = Math.min(minSum, sum);
            right_max[i] = maxSum;
        }

        //left to right min subarray
        maxSum = Integer.MIN_VALUE;
        minSum = 0;
        sum = 0;
        for (int i = 0; i < n; i++) {
            sum += copy[i];
            maxSum = Math.max(maxSum, sum - minSum);
            minSum = Math.min(minSum, sum);
            left_min[i] = -1 * maxSum;
        }

        //right to left min subarray
        maxSum = Integer.MIN_VALUE;
        minSum = 0;
        sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += copy[i];
            maxSum = Math.max(maxSum, sum - minSum);
            minSum = Math.min(minSum, sum);
            right_min[i] = -1 * maxSum;
        }

        int diff = 0;
        for (int i = 0; i < n - 1; i++) {
            diff = Math.max(diff, Math.abs(left_max[i] - right_min[i + 1]));
            diff = Math.max(diff, Math.abs(left_min[i] - right_max[i + 1]));
        }

        return diff;
    }
}