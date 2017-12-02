public class Solution {
    /*
     * @param : An integer
     * @param : An integer
     * @return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        // write your code here
        
        while (b != 0) {
            int tempA = a ^ b;
            int tempB = (a & b) << 1;
            a = tempA;
            b = tempB;
        }
        return a;
        
    }
};