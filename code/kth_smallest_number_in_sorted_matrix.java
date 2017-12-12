public class Solution {

    class CheckResult {
        int num;
        boolean exist;
        public CheckResult(int n, int e){
            num = n;
            exist = e;
        }
    }

    /*
     * @param matrix: a matrix of integers
     * @param k: An integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here

        int m = matrix.length;
        int n = matrix[0].length;

        int left = matrix[0][0];
        int right = matrix[m - 1][n - 1];

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            CheckResult curr = check(mid, matrix);

            if (curr.exist && curr.num == k - 1) {
                return mid;
            } else if (curr.num < k - 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        CheckResult result = check(left, matrix);
        if (result.num == k - 1) return left;
        else return right;

    }

    private CheckResult check(int value, int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        int i = n - 1, j = 0;
        boolean exist = false;
        int num;
        while (i >= 0 && j < m) {
            if (matrix[i][j] == value) {
                exist = true;
            }

            if (matrix[i][j] < value) {
                num += i + 1;
                j++;
            } else {
                i--;
            }

            return new CheckResult(num, exist);
        }

    }

}