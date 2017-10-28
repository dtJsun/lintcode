public class Solution {
    /*
     * @param nums: an integer unsorted array
     * @param k: an integer from 1 to n
     * @return: the kth largest element
     */
    public int kthLargestElement2(int[] nums, int k) {
        // write your code here

        quickSort(nums, 0, nums.length - 1);
        return nums[k - 1];

    }
    
    private void quickSort(int[] nums, int start, int end) {
        
        if (start >= end) return;
        
        int pivot = partition(nums, start, end);
        quickSort(nums, start, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }

    private int partition(int[] nums, int start, int end) {
        
        int pivot = end;

        int i = start;
        for (int j = start; j <= end; j++) {
            if (nums[j] > nums[pivot]) {
                swap(nums, j, i);
                i++;
            }
        }
        swap(nums, i, pivot);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}