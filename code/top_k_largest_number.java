public class Solution {
    /*
     * @param nums: an integer array
     * @param k: An integer
     * @return: the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        // write your code here
        int[] ans = new int[k];
        quickSort(nums, 0, nums.length - 1);

        for (int i = 0; i < k; i++) {
            ans[i] = nums[i];
        }
        return ans;
    }

    private void quickSort(int[] nums, int start, int end) {

        if (start >= end) {
            return;
        }

        int pivot = partition(nums, start, end);
        quickSort(nums, start, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }

    private int partition (int[] nums, int start, int end) {

        int pivot = nums[end];

        int i = start;
        for (int j = start; j < end; j++) {
            if (nums[j] > pivot) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        int temp = nums[end];
        nums[end] = nums[i];
        nums[i] = temp;
        
        return i;
    }
    
}