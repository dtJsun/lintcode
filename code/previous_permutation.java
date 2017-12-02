public class Solution {
    /*
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public List<Integer> previousPermuation(List<Integer> nums) {
        // write your code here
        
        int index = -1;
        for (int i = nums.size() - 1; i - 1 >= 0; i--) {
            if (nums.get(i - 1) > nums.get(i)) {
                index = i - 1;
                break;
            }
        }
        
        if (index == -1) {
            swapMultiple(nums, 0, nums.size() - 1);
            return nums;
        }
        
        for (int i = nums.size() -1; i > index; i--) {
            if (nums.get(i) < nums.get(index)) {
                swap(nums, i, index);
                break;
            }
        }
        
        swapMultiple(nums, index + 1, nums.size() - 1);
        
        return nums;
        
    }
    
    private void swap(List<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }
    
    private void swapMultiple(List<Integer> nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}