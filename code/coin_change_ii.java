/**
leetcode: https://leetcode.com/problems/coin-change-2/description/
 */

 class Solution {
    public int change(int amount, int[] coins) {
        
        int[] currCount = new int[amount + 1];
        currCount[0] = 1;
        
        for (int j = 0; j < coins.length; j++) {
            for (int i = 0; i <= amount; i++) {
                if (i - coins[j] >= 0) {
                    currCount[i] += currCount[i - coins[j]];
                }
            }
        }
        
        return currCount[amount];
    }
}