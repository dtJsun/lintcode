public class Solution {
    /*
     * @param n: An integer
     * @return: the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        // write your code here

        Queue<Long> que = new PriorityQueue<Long>();
        HashSet<Long> mark = new HashSet<>();

        Long[] primes = new Long[3];
        primes[0] = Long.valueOf(2);
        primes[1] = Long.valueOf(3);
        primes[2] = Long.valueOf(5);
        
        for (int i = 0; i < 3; i++) {
            que.offer(primes[i]);
            mark.add(primes[i]);
        }

        Long number = Long.valueOf(1);
        for (int i = 1; i < n; i++) {
            number = que.poll();
            for (int j = 0; j < 3; j++) {
                // System.out.println(primes[j]);
                Long temp = number * primes[j];
                if (!mark.contains(temp)) {
                    que.offer(temp);
                    mark.add(temp);
                }
            }
        }
        return number.intValue();


    }
}