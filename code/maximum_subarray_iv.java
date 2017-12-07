public class Solution {
    /*
     * @param nums: an array of integer
     * @param k: an integer
     * @return: the largest sum
     */
    public int maxSubarray4(int[] nums, int k) {
        // write your code here

        if (nums.length < k) return 0;

        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        int minSum = Integer.MAX_VALUE;
        int ans = Integer.MIN_VALUE;

        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
            if (i >= k) {
                minSum = Math.min(minSum, sum[i - k]);
                ans = Math.max(ans, sum[i] - minSum);
            }
        }
        
        return ans;
    }
}