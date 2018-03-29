class Solution {
    public int longestConsecutive(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            
            int left = nums[i] - 1;
            while (set.contains(left)) {
                set.remove(left);
                left--;
            }
            
            int right = nums[i] + 1;
            while (set.contains(right)) {
                set.remove(right);
                right++;
            }
            
            ans = Math.max(ans, right - left - 1);
            
        }
        
        return ans;
    }
}