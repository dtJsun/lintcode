/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */


public class Solution {

    // private HashMap<Integer, Integer> map = new HashMap<>();
    // private HashSet<Integer> roots = new HashSet<>();

    /*
     * @param nodes: a array of Directed graph node
     * @return: a connected set of a directed graph
     */
     // bfs {1,2,4#2,4#3,5#4#5#6,5}过不了
    // public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
    //     // write your code here

    //     HashSet<Integer> set = new HashSet<>();
    //     Queue<DirectedGraphNode> que = new LinkedList<>();
    //     List<List<Integer>> ans = new List<>();

    //     for (int i = 0; i < nodes.size(); i++) {
    //         if (set.contains(nodes[i].label)) {
    //             continue;
    //         }
    //         List<Integer> list = new ArrayList<>();
    //         que.offer(nodes[i]);
    //         list.add(nodes[i].label);
    //         set.add(nodes[i].label);
    //         while (!que.isEmpty()) {
    //             DirectedGraphNode curr = que.poll();
    //             for (int j = 0; j < curr.neighbors.size(); j++) {
    //                 if (!set.contains(curr.neighbors[j].label)) {
    //                     que.offer(curr.neighbors[j]);
    //                     list.add(curr.neighbors[j].label);
    //                     set.add(curr.neighbors[j].label);
    //                 }
    //             }
    //         }
    //         ans.add(list);
    //     }
    //     return ans;
    // }

    // list map

    private HashMap<Integer, List<Integer>> listMap = new HashMap<>();
    private HashMap<Integer, Integer> nodeMap = new HashMap<>();

    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        // write your code here

        for (int i = 0; i < nodes.size(); i++) {
            List<Integer> list = new ArrayList<>();
            list.add(nodes.get(i).label);
            listMap.put(nodes.get(i).label);
            nodeMap.put(nodes.get(i).label, nodes.get(i).label);
        }





    }

    private void merge(int listID1, int listID2) {

        listMap.get(listID1).addAll(listMap.get(listID2));
        listMap.remove(listID);

    }

}