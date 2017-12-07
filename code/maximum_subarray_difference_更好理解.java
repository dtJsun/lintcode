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

        for (int i = 0; i < n; i++) {
            copy[i] = -1 * nums[i];
        }

        int sumMax = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum <= 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            sumMax = Math.max(sumMax, sum);
            left_max[i] = sumMax;
        }

        sumMax = Integer.MIN_VALUE;
        sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (sum <= 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            sumMax = Math.max(sumMax, sum);
            right_max[i] = sumMax;
        }
        

        sumMax = Integer.MIN_VALUE;
        sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum <= 0) {
                sum = copy[i];
            } else {
                sum += copy[i];
            }
            sumMax = Math.max(sumMax, sum);
            left_min[i] = -1 * sumMax;
        }

        sumMax = Integer.MIN_VALUE;
        sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (sum <= 0) {
                sum = copy[i];
            } else {
                sum += copy[i];
            }
            sumMax = Math.max(sumMax, sum);
            right_min[i] = -1 * sumMax;
        }

        int diff = 0;
        for (int i = 0; i < n - 1; i++) {
            diff = Math.max(diff, Math.abs(left_max[i] - right_min[i + 1]));
            diff = Math.max(diff, Math.abs(left_min[i] - right_max[i + 1]));
        }
        return diff;

    }
}