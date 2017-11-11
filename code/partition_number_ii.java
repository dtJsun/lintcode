public class Solution {
    /*
     * @param nums: an integer array
     * @param low: An integer
     * @param high: An integer
     * @return: 
     */
    public void partition2(int[] nums, int low, int high) {
        // write your code here
        
        int lowPtr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < low) {
                swap(nums, lowPtr, i);
                lowPtr++;
            }
        }

        int highPtr = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > high) {
                swap(nums, highPtr, i);
                highPtr--;
            }
        }

        return;

    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}