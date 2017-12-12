public class Solution {
    /*
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(List<Integer> nums) {
        // write your code here

        if (nums == null || nums.size() == 0) {
            return 0;
        }

        int[] leftMax = new int[nums.size()];
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            if (sum <= 0) {
                sum = nums.get(i);
            } else {
                sum += nums.get(i);
            }
            maxSum = Math.max(sum, maxSum);
            leftMax[i] = maxSum;
        }

        int[] rightMax = new int[nums.size()];
        sum = 0;
        maxSum = Integer.MIN_VALUE;
        for (int i = nums.size() - 1; i >= 0; i--) {
            if (sum <= 0) {
                sum = nums.get(i);
            } else {
                sum += nums.get(i);
            }
            maxSum = Math.max(sum, maxSum);
            leftMax[i] = maxSum;
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            ans = Math.max(ans, leftMax[i] + rightMax[i + 1]);
        }

        return ans;

    }
}