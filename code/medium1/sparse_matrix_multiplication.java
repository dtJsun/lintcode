// 1. 遍历A的所有，如果 A[i][j] != 0 那么思考谁会和它相乘？=> B的第j行的所有列都会和它相乘，
// 因此，接下来遍历B的第j行的所有列，如果 B[j][k] != 0 那么把所有不等于0的结果相加，就得出了 ans[i][k]的值


class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        
        int mA = A.length;
        int nA = A[0].length;
        int mB = B.length;
        int nB = B[0].length;
        
        int[][] ans = new int[mA][nB];
        
        for (int i = 0; i < mA; i++) {
            for (int j = 0; j < nA; j++) {
                if (A[i][j] != 0) {
                    for (int k = 0; k < nB; k++) {
                        if (B[j][k] != 0) {
                            ans[i][k] += A[i][j] * B[j][k];
                        }
                    }
                }
            }
        }
        return ans;
    }
}