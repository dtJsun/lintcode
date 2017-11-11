public class Solution {
    /*
     * @param k: An integer
     * @param nums: An integer array
     * @return: kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
        // write your code here
        return helper(nums, 0, nums.length - 1, k);

    }

    private int helper(int[] nums, int start, int end, int k) {

        int pivot = partition(nums, start, end);

        if (pivot - start == k - 1) {
            return nums[pivot];
        } else if (pivot - start > k - 1) {
            return helper(nums, start, pivot - 1, k);
        }
        return helper(nums, pivot + 1, end, k - (pivot - start + 1));
    }

    private int partition(int[] nums, int start, int end) {

        int pivot = nums[end];

        int i = start;
        for (int j = start; j < end; j++) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, end);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}