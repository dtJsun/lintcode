public class Solution {
    /*
     * @param nums: an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public int twoSum6(int[] nums, int target) {
        // write your code here

        HashSet<String> set = new HashSet<>();

        Arrays.sort(nums);

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum < target) {
                start++;
            } else if (sum > target) {
                end--;
            } else {
                set.add(Integer.toString(nums[start]) + Integer.toString(nums[end]));
                start++;
                end--;
            }
        }
        return set.size();
    }
}