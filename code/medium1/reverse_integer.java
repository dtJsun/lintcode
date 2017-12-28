class Solution {
    public int reverse(int x) {
        
        long ans = 0;
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x *= -1;
        }

        while (x != 0) {
            ans = ans * 10 + (x % 10);
            x = x / 10;
        }
        
        ans = isNegative ? -ans : ans;
        
        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
            return 0;
        }

        return (int)ans;

    }
}