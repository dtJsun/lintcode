class Solution {
    public boolean isPalindrome(String s) {
        
        int start = 0, end = s.length() - 1;
        
        while (start < end) {
            
            while (start < s.length() && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            while (end >= 0 && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }
            
            if (start >= end) {
                break;
            }
            
            if (isValid(s.charAt(start), s.charAt(end))) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
    
    private boolean isValid(char ch1, char ch2) {
        
        if (ch1 == ch2) return true;
        
        if (Math.abs(ch1 - ch2) == 32) {
            return ch1 < ch2 ? Character.isLetter(ch1) : Character.isLetter(ch2);
        }
        return false;
    }
    
    
}