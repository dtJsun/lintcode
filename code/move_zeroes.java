public class Solution {
    /*
     * @param nums: an integer array
     * @return: 
     */
    public void moveZeroes(int[] nums) {
        // write your code here

        int zero_ptr = 0;
        while (zero_ptr < nums.length && nums[zero_ptr] != 0) {
            zero_ptr++;
        }

        int i = zero_ptr + 1;
        while(i < nums.length) {
            if (nums[i] != 0) {
                int temp = nums[zero_ptr];
                nums[zero_ptr] = nums[i];
                nums[i] = temp;
                zero_ptr++;
            }
        }

    }
}