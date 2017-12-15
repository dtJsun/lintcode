public class Solution {
    
    /*
     * @param arrays: a list of array
     * @param k: An integer
     * @return: an integer, K-th largest element in N arrays
     */
    public int KthInArrays(int[][] arrays, int k) {
        // write your code here

        int count = 0;
        for (int i = 0; i < arrays.length; i++) {
            count += arrays[i].length;
        }

        int[] nums = new int[count];
        int index = 0;
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                nums[index] = arrays[i][j];
                index++;
            }
        }  
        quickSort(nums, 0, index - 1);
        return nums[k - 1];

    }
    
    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = partition(nums, start, end);
        quickSort(nums, start, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }

    private int partition(int[] nums, int start, int end) {

        int pivot = nums[end];

        int i = start;
        for (int j = start; j < end; j++) {
            if (nums[j] > pivot) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
        }
        int temp = nums[i];
        nums[i] = nums[end];
        nums[end] = temp;
        return i;
    }
    
    
};