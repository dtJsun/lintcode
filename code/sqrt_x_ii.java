public class Solution {
    /*
     * @param x: a double
     * @return: the square root of x
     */
    public double sqrt(double x) {
        // write your code here

        double start = 0;
        double end = x;

        while (end - start > 1e-8) {
            double mid = (start + end) / 2.0;

            if (mid * mid < x) {
                start = mid;
            } else if(mid * mid > x) {
                end = mid;
            } else {
                return mid;
            }
        }
        return start;

    }




}