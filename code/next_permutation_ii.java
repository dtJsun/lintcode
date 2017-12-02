public class Solution {
    /*
     * @param nums: An array of integers
     * @return: nothing
     */
    public void nextPermutation(int[] nums) {
        // write your code here
        int index = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                index = i - 1;
            }
        }

        for (int i = nums.length - 1; i >= index; i--) {
            if (nums[i] > nums[index]) {
                swap(nums, i, index);
            }
        }

        swapMultiple(nums, index + 1, nums.length - 1);

    }
    
    private void swapMultiple(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}