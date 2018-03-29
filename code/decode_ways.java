//不太懂，再见到的时候多理解一下
class Solution {
    public int numDecodings(String s) {
        
        if (s.length() == 0) return 0;
        
        int[] nums = new int[s.length() + 1];
        nums[0] = 1;
        nums[1] = s.charAt(0) == '0' ? 0 : 1;
        
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0') {
                nums[i] = nums[i - 1];
            }
            
            int temp = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
            if (temp >= 10 && temp <= 26) {
                nums[i] += nums[i - 2];
            }
            
        }
        
        return nums[s.length()];
        
    }
}