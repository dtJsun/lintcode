public class Solution {
    /*
     * @param nums: The integer array you should partition
     * @param k: An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        // write your code here

        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) {
                int temp = nums[i];
                nums[i] = nums[curr];
                nums[curr] = temp;
                curr++;
            }
        }
        return curr;
    }

}