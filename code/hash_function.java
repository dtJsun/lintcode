public class Solution {
    /*
     * @param key: A string you should hash
     * @param HASH_SIZE: An integer
     * @return: An integer
     */
    public int hashCode(char[] key, int HASH_SIZE) {
        // write your code here
        
        int fac = key.length - 1;

        int sum = 0;
        int magic = 33 % HASH_SIZE;

        for (int i = 0; i <= fac; i++) {
            int temp = (int)key[i];
            int 


        }

        
    }
}