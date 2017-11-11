public class Solution {
    /*
     * @param nums: a list of integers.
     * @param k: length of window.
     * @return: the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        // write your code here

        int len = nums.length;
        if (k >= len) {
            int[] ans = new int[1];
            for (int i = 0; i < nums.length; i++) {
                ans[0] += nums[i];
            }
        }

        int size = len - k + 1;
        int[] ans = new int[size];

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        ans[0] = sum;

        for (int i = k; i < len; i++) {
            sum = sum + nums[i] - nums[i - k - 1];
            ans[i - k + 1] = sum;
        }

        return ans;
    }
}