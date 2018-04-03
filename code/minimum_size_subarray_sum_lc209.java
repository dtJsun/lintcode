class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        
        if (nums.length == 0) return 0;
        
        int i = 0, j = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        
        for (; i < nums.length; i++) {
            
            while (sum < s && i < nums.length) {
                sum += nums[i];
                i++;
            }
            
            if (i == nums.length && sum < s) {
                return ans == Integer.MAX_VALUE ? 0 : ans;
            }
            
            while (sum >= s && j <= i) {
                sum -= nums[j];
                j++;
            }
            
            ans = Math.min(ans, i - j + 1);
            i--;
            
        }
        
        return ans;
        
        
        
        
    }
}