public class Solution {
    /*
     * @param nums: an array of integer
     * @param target: An integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        // write your code here

        Array.sort(nums);

        int ans = 0;
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int sum = nums[low] + nums[high];
            if (sum > target) {
                ans += (high - low);
                high--;
            } else if (sum < target) {
                low++;
            } else {
                low++;
            }
        }
        return ans;
    }
}