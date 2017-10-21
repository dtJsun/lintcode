public class Solution {
    /*
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public int deduplication(int[] nums) {
        // write your code here

        HashSet<Integer> set = new HashSet<>();

        int actual = 0;
        int curr = 0;

        while (actual < nums.length) {
            if (!set.contains(nums[actual])) {
                set.add(nums[actual]);
                actual++;
                curr++;
            } else {
                while (actual < nums.length && set.contains(nums[actual])) {
                    actual++;
                }
                if (actual >= nums.length) {
                    return curr;
                }
                nums[curr] = nums[actual];
                set.add(nums[actual]);
                curr++;
            }
        }

        return curr;
    }
}