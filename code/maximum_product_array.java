public class Solution {
    /*
     * @param nums: An array of integers
     * @return: An integer
     */
    public int maxProduct(int[] nums) {
        // write your code here

        int[] maxProduct = new int[nums.length];
        int[] minProduct = new int[nums.length];

        maxProduct[0] = nums[0];
        minProduct[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxProduct[i] = nums[i];
            minProduct[i] = nums[i];

            if (nums[i] > 0) {
                maxProduct[i] = Math.max(maxProduct[i], maxProduct[i - 1] * nums[i]);
                minProduct[i] = Math.max(minProduct[i], minProduct[i - 1] * nums[i]);
            } else if (nums[i] < 0) {
                maxProduct[i] = Math.max(maxProduct[i], minProduct[i - 1] * nums[i]);
                minProduct[i] = Math.min(minProduct[i], maxProduct[i - 1] * num[i]);
            }

            result = Math.max(result, maxProduct[i]);

        }
        return result;
    }
}