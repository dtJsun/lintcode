//居然不用去重 :/
public class Solution {
    /*
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param m: An integer
     * @param B: sorted integer array B which has n elements
     * @param n: An integer
     * @return: nothing
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here

        int[] temp = new int[A.length];

        int i = 0, j = 0, index = 0;
        while (i < m && j < n) {
            if (A[i] < B[j]) {
                temp[index] = A[i];
                i++;
            }  else {
                temp[index] = B[j];
                j++;
            }
            index++;
        }
        
        // System.out.println(j);
        // System.out.println(index);
        
        if (i == m) {
            while (j < n) {
                temp[index] = B[j];
                // System.out.println(temp[index]);
                index++;
                j++;
            }
        } else {
            while (i < m) {
                temp[index] = A[i];
                index++;
                i++;
            }
        }

        for (int k = 0; k < A.length; k++) {
            A[k] = temp[k];
        }

    }
}