public class ConnectingGraph {
    
    private int[] father;
    
    private int find(int x) {
        if (father[x] == x) return x;
        return find(father[x]);
    }
    
    /*
    * @param n: An integer
    */public ConnectingGraph(int n) {
        // do intialization if necessary
        father = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            father[i] = i;
        }
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        // write your code here
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) {
            return;
        }
        father[rootA] = rootB;
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: A boolean
     */
    public boolean query(int a, int b) {
        // write your code here
        int rootA = find(a);
        int rootB=  find(b);
        return rootA == rootB;
    }
}