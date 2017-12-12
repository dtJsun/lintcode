public class Solution {
    /*
     * @param nums: an array of integers
     * @param s: An integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here
        
        int i = 0, j = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        for (; i < nums.length; i++) {
            while (j < nums.length && sum < s) {
                sum += nums[j];
                j++;
            }
            if (sum >= s) {
                ans = Math.min(ans, j - i);
            }
            sum -= nums[i];
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
        
    }
}