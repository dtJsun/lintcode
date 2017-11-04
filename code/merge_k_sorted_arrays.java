/**
 * merge sort - time limit exceeded
 */

public class Solution {
    /*
     * @param arrays: k sorted integer arrays
     * @return: a sorted array
     */
    public int[] mergekSortedArrays(int[][] arrays) {
        // write your code here
    }

    private int[] helper(int[][] arrays, int start, int end) {

        if (start == end) {
            return arrays[start];
        }
        int mid = start + (end - start) / 2;
        int[] first = helper(arrays, start, mid);
        int[] second = helper(arrays, mid + 1, end);

        return merge(first, second);

    }

    private int[] merge(int[] first, int[] second) {
        int len = first.length + second.length;
        int[] ans = new int[len];
        int curr = 0;
        int i = 0, j = 0;
        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                ans[curr] = first[i];
                i++;
            } else {
                ans[curr] = second[j];
                j++;
            }
            curr++;
        }

        if (i == first.length) {
            while (j < second.length) {
                ans[curr] = second[j];
                curr++;
                j++;
            }
        } else {
            while (i < first.length) {
                ans[curr] = first[i];
                curr++;
                i++;
            }
        }

        return ans;
    }

    
    
}