/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x;
 *         neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */


public class Solution {
    /*
     * @param graph: a list of Undirected graph node
     * @param s: Undirected graph node
     * @param t: Undirected graph nodes
     * @return: an integer
     */
    public int sixDegrees(List<UndirectedGraphNode> graph, UndirectedGraphNode s, UndirectedGraphNode t) {
        // write your code here
        
        if (s == t) return 0;
        
        HashSet<UndirectedGraphNode> mark = new HashSet();
        Queue<UndirectedGraphNode> que = new LinkedList<>();
        int ans = 0;
        que.offer(s);

        while (!que.isEmpty()) {
            int size = que.size();
            ans++;
            for (int i = 0; i < size; i++) {
                UndirectedGraphNode curr = que.poll();
                for (int j = 0; j < curr.neighbors.size(); j++) {
                    UndirectedGraphNode temp = curr.neighbors.get(j);
                    if (mark.contains(temp)) continue;
                    if (temp != t) {
                        mark.add(temp);
                        que.offer(temp);
                    } else {
                        return ans;
                    }
                }
            }
        }
        return -1;
        
        
    }
}
