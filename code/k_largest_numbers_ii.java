/**
 * quick sort  ----- time limit exceeded
 */
public class Solution {
    
        private ArrayList<Integer> nums;
        private int count = 0;
    
        /*
        * @param k: An integer
        */public Solution(int k) {
            // do intialization if necessary
            nums = new ArrayList<>();
            count = k;
        }
    
        /*
         * @param num: Number to be added
         * @return: nothing
         */
        public void add(int num) {
            // write your code here
            nums.add(num);
            quickSort(nums, 0, nums.size() - 1);
            if (nums.size() > count) {
                nums.remove(count);
            }
        }
    
        /*
         * @return: Top k element
         */
        public List<Integer> topk() {
            // write your code here
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < count && i < nums.size(); i++) {
                ans.add(nums.get(i));
            }
            return ans;
        }
    
        private void quickSort(ArrayList<Integer> nums, int start, int end) {
    
            if (start >= end) {
                return;
            }
    
            int pivot = partition(nums, start, end);
            quickSort(nums, start, pivot - 1);
            quickSort(nums, pivot + 1, end);
    
        }
    
        private int partition(ArrayList<Integer> nums, int start, int end) {
    
            Integer pivot = nums.get(end);
    
            int i = start;
            for (int j = start; j < end; j++) {
                if (nums.get(j) > pivot) {
                    swap(nums, i, j);
                    i++;
                }
            }
            swap(nums, i, end);
            return i;
        }
    
        private void swap(ArrayList<Integer> nums, int i, int j) {
            Integer temp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, temp);
        }
    
    }
