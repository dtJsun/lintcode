public class Solution {
    /*
     * @param nums: an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public int twoSum6(int[] nums, int target) {
        // write your code here

        int count = 0;
        int start = 0;
        int end = nums.length - 1;
        Arrays.sort(nums);
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == target) {
                count++;
                while (start < end && nums[start] == nums[start + 1]) {
                    start++;
                }
                while (start < end && nums[end] == nums[end - 1]) {
                    end--;
                }
                start++;
                end--;
            } else if (sum < target) {
                start++;
            } else if (sum > target) {
                end--;
            }
        }
        return count;
    }
}