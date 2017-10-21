public class Solution {
    /*
     * @param nums: an array of Integer
     * @param target: target = nums[index1] + nums[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        // write your code here

        int index1 = 0;
        int index2 = nums.length - 1;
        int[] ans = new int[2];

        while (index1 < index2) {
            int sum = nums[index1] + nums[index2];
            if (sum < target) {
                index1++;
            } else if (sum > target) {
                index2--;
            } else {
                ans[0] = index1 + 1;
                ans[1] = index2 + 1;
                return ans;
            }
        }
        return ans;
    }
}