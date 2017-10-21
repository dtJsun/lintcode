public class Solution {
    /*
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum5(int[] nums, int target) {
        // write your code here

        int start = 0;
        int end = nums.length - 1;
        int count = 0;

        Arrays.sort(nums);
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum > target) {
                end--;
            } else {
                count += end - start;
                start++;
            }
        }

        return count;

    }
}