/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

class Node {
    Double distance;
    Point point;
    public Node (Double d, Point p) {
        this.distance = d;
        this.point = new Point(p.x, p.y);
    }
}


public class Solution {
   /*
    * @param points: a list of points
    * @param origin: a point
    * @param k: An integer
    * @return: the k closest points
    */
   public Point[] kClosest(Point[] points, Point origin, int k) {
       // write your code here
       Point[] ans = new Point[k];
       ArrayList<Node> nodes = new ArrayList<>();
       for (int i = 0; i < points.length; i++) {
           int tempX = points[i].x - origin.x;
           int tempY = points[i].y - origin.y;
           double distance = Math.sqrt(tempX * tempX + tempY * tempY);
           Node node = new Node(distance, points[i]);
           nodes.add(node);
       }

       Collections.sort(nodes, new NodeComparator());

       for (int i = 0; i < k; i++) {
           ans[i] = nodes.get(i).point;
       }
       return ans;
   }

   private class NodeComparator implements Comparator<Node> {
       public int compare(Node a, Node b) {
           if (a.distance - b.distance == 0.0 ) {
               if (a.point.x == b.point.x) {
                   return a.point.y - b.point.y;
               } else {
                   return a.point.x - b.point.x;
               }
           } else {
               return a.distance < b.distance ? -1 : 1;
           }
       }        
   }
}