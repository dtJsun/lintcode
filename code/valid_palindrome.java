public class Solution {
    /*
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // write your code here

        int start = 0, end = s.length() - 1;

        while (start < end) {
            while (start < s.length() && !Character.isLetter(s.charAt(start)) && !Character.isDigit(s.charAt(start))) {
                start++;
            }
            while (end >= 0 && !Character.isLetter(s.charAt(end)) && !Character.isDigit(s.charAt(end))) {
                end--;
            }
            
            if (start >= s.length() || end < 0) {
                break;
            }

            if (s.charAt(start) != s.charAt(end) && Math.abs(s.charAt(start) - s.charAt(end)) != 32) {
                return false;
            }
            start++;
            end--;

        }

        return true;

    }
}