/**
leetcode: https://leetcode.com/problems/coin-change/description/
 */

 class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[] ans = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            ans[i] = -1;
        }
        ans[0] = 0;
        
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && ans[i - coins[j]] != -1) {
                    ans[i] = ans[i] == -1 ? ans[i - coins[j]] + 1 : Math.min(ans[i - coins[j]] + 1, ans[i]);   
                }
            }
        }
        
        return ans[amount];
    }
}