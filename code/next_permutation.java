public class Solution {
    /*
     * @param nums: A list of integers
     * @return: A list of integers
     */
    public int[] nextPermutation(int[] nums) {
        // write your code here

        if (nums.length <= 1) return nums;

        int i = nums.length - 1;

        while (i > 0 && nums[i] <= nums[i - 1]) i--;

        swapList(nums, i, nums.length - 1);

        if (i != 0) {
            int j = i;
            while (nums[j] <= nums[i - 1]) j++;
            swapList(nums, i - 1, j);
        }

        return nums;
    }
    
    private swapList(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
    
}