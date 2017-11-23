public class Solution {
    /*
     * @param dividend: the dividend
     * @param divisor: the divisor
     * @return: the result
     */
    public int divide(int dividend, int divisor) {
        // write your code here

        if (divisor == 0) {
            return dividend > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        if (dividend == 0) {
            return 0;
        }
        
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isNegative = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);

        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        long ans = 0;

        while (a >= b) {
            long temp = b;
            int shift = 0;
            while (a >= temp) {
                temp = temp << shift;
                shift++;
            }
            ans += (1 << (shift - 2));
            a = a - (b << (shift - 2));
        }

        return isNegative ? (int)-ans : (int)ans; 

    }

}