public class Solution {
    /*
     * @param nums: an integer array
     * @param target: An integer
     * @return: the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        // write your code here

        int diff = Integer.MAX_VALUE;
        int start = 0;
        int end = nums.length - 1;
        
        Arrays.sort(nums);

        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == target) {
                return 0;
            } else if (sum < target) {
                int temp = target - sum;
                diff = Math.min(temp, diff);
                start++;
            } else if (sum > target) {
                int temp = sum - target;
                diff = Math.min(temp, diff);
                end--;
            }
        }
        return diff;
    }
}