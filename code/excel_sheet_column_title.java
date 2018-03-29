class Solution {
    public String convertToTitle(int n) {
        
        StringBuilder ans = new StringBuilder();
        
        while (n > 0) {
            int curr = n % 26;
            if (curr == 0) {
                n -= 26;
                ans.append('Z');
            } else {
                n -= curr;
                ans.append((char)('A' + curr - 1));
            }
            n /= 26;
        }
        return ans.reverse().toString();
    }
}