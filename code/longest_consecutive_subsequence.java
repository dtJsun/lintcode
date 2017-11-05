public class Solution {
    /*
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestConsecutive(int[] nums) {
        // write your code here

        HashSet<Integer> set = new HashSet<>();
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {

            int low = nums[i] - 1;
            int tempLen = 1;
            while (set.contains(low)) {
                tempLen++;
                set.remove(low);
                low--;
            }

            int high = nums[i] + 1;
            while (set.contains(high)) {
                tempLen++;
                set.remove(high);
                high++;
            }

            maxLen = Math.max(maxLen, tempLen);

        }

        return maxLen;

    }
}