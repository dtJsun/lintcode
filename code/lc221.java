class Solution {
    public int maximalSquare(char[][] matrix) {
        
        int ans = 0;
        int n = matrix.length;
        if (n == 0) {
            return 0;
        }
        if (matrix[0].length == 0) return 0;
        int m = matrix[0].length;
        
        int[][] dp = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            dp[i][0] = matrix[i][0] - '0';
            ans = Math.max(ans, dp[i][0]);
            
            for (int j = 1; j < m; j++) {
                
                if (i == 0) {
                    dp[i][j] = matrix[i][j] - '0';
                    ans = Math.max(ans, dp[i][j]);
                    continue;
                }
                
                if (matrix[i][j] == '0') {
                    dp[i][j]  = 0;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        
        return ans * ans;
        
    }
}