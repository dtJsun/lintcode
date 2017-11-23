public class Solution {
    /*
     * @param nums: an array with positive and negative numbers
     * @param k: an integer
     * @return: the maximum average
     */
    public double maxAverage(int[] nums, int k) {
        // write your code here

        double left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < left) {
                left = nums[i];
            }
            if (nums[i] > right) {
                right = nums[i];
            }
        }

        while (right - left <= 1e-6) {
            double mid = (left + right) / 2;

            if (isValid(nums, mid, k)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private isValid(int[] nums, double mid, int k) {

        int n = nums.length;
        double[] sums = new double[n + 1];
        sums[0] = 0;
        double pre_min = 0.0;

        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1] - mid;

            if (i >= k) {
                if (sum[i] - pre_min >= 0) {
                    return true;
                }
                pre_min = Math.min(pre_min, sum[i - k + 1]);
            }
        }
        return false;


    }




}