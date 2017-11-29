public class Solution {
    /*
     * @param A: an integer array
     * @return: 
     */
    public void sortIntegers2(int[] A) {
        // write your code here
        if (A == null || A.length == 0) return;
        mergeSort(A, 0, A.length - 1);
    }
    
    private void mergeSort(int[] A, int start, int end) {
        
        if (start == end) return;

        int mid = start + (end - start) / 2;

        mergeSort(A, start, mid);
        mergeSort(A, mid + 1, end);

        merge(A, start, end);
    }

    private void merge(int[] A, int start, int end) {
        
        if (start >= end) return;

        int[] helper  = new int[end - start + 1];
        for (int i = 0, j = start; i < helper.length && j <= end; i++, j++) {
            helper[i] = A[j];
        }

        int mid = (helper.length - 1) / 2;

        int i = 0;
        int j = mid + 1;
        int k = start;

        while (i <= mid && j <= helper.length - 1) {
            if (helper[i] <= helper[j]) {
                A[k] = helper[i];
                i++;
            } else {
                A[k] = helper[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            A[k] = helper[i];
            i++;
            k++;
        }

        while (j <= helper.length - 1) {
            A[k] = helper[j];
            j++;
            k++;
        }
    }
    
}