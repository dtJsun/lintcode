public class Solution {

    class Pair {
        int a;
        int b;
        int sum;
        public Pair(int a, int b, int sum) {
            this.a = a;
            this.b = b;
            this.sum = sum;
        }
    }

    class PairComparator implements Comparator<Pair> {
        public int compare(Pair A, Pair B) {
            return a.sum - b.sum;
        }
    }
    
    /*
     * @param A: an integer arrays sorted in ascending order
     * @param B: an integer arrays sorted in ascending order
     * @param k: An integer
     * @return: An integer
     */
    public int kthSmallestSum(int[] A, int[] B, int k) {
        // write your code here

        int[] da = {0, 1};
        int[] db = {1, 0};

        int[][] mark = new int[A.length][B.length];
        
        PriorityQueue<Pair> que = new PriorityQueue<>(k, new PairComparator());
        que.offer(new Pair(0, 0, A[0] + B[0]));

        for (int i = 0; i < k - 1; i++) {
            Pair curr = que.poll();
            for (int j = 0; j < 2; j++) {
                int newA = curr.a + da[j];
                int newB = curr.b + db[j];
                if (newA < A.length && newB < B.length && mark[newA][newB] != 1) {
                    mark[newA][newB] = 1;
                    que.offer(new Pair(newA, newB, A[newA] + B[newB]));
                }
            }
        }

        return que.peek().sum;
    }
};