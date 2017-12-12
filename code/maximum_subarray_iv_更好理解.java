public class Solution {
    /*
     * @param nums: an array of integer
     * @param k: an integer
     * @return: the largest sum
     */
    public int maxSubarray4(int[] nums, int k) {
        // write your code here
        
        if (nums.length < k) return 0;
        
        int initSum = 0;
        for (int i = 0; i < k && i < nums.length; i++) {
            initSum += nums[i];
        }
        
        int[] leftMax = new int[nums.length];
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum <= 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            // maxSum = Math.max(sum, maxSum);
            leftMax[i] = sum;
        }
        
        sum = initSum;
        int ans = initSum;
        for (int i = k; i < nums.length; i++) {
            sum -= nums[i - k];
            sum += nums[i];
            if (leftMax[i - k] > 0) {
                sum += leftMax[i - k];
                ans = Math.max(sum, ans);
                sum -= leftMax[i - k];
            } else {
                ans = Math.max(sum, ans);
            }
            
        }

        return ans;
    }
}