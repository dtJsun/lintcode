public class Solution {
    /*
     * @param nums: an array of integers
     * @param s: An integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here

        if (nums == null || nums.length == 0) return -1;

        int[] sum = new int[nums.length];
        sum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = sum.length - 1; i >= 0; i--) {
            
            if (sum[i] > s) {
                int distance = getDistance(sum, i, s);
                if (distance == -1) {
                    break;
                }
                ans = Math.min(distance, ans);
            } else if (sum[i] == s) {
                ans = Math.min(i + 1, ans);
            } else {
                break;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;

    }

    private int getDistance(int[] sum, int end, int s) {

        for (int i = end - 1; i >= 0; i--) {
            if (sum[end] - sum[i] >= s) {
                return end - i;
            }
        }
        return -1;
    }
}