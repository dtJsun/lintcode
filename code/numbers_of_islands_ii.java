/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */


public class Solution {
    
        private HashMap<Point, Point> father = new HashMap<>();
    
        /*
         * @param n: An integer
         * @param m: An integer
         * @param operators: an array of point
         * @return: an integer array
         */
        public List<Integer> numIslands2(int n, int m, Point[] operators) {
            // write your code here
    
            List<Integer> ans = new ArrayList<>();
            if (operators == null || operators.length == 0) return ans;
    
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    Point temp = new Point(i, j);
                    father.put(temp, temp);
                }
            }
    
            int[][] grid = new int[n][m];
    
            int[] dx = new int[]{0, -1, 0, 1};
            int[] dy = new int[]{-1, 0, 1, 0};
            int count = 0;
    
            for (int i = 0; i < operators.length; i++) {
                int x = operators[i].x;
                int y = operators[i].y;
                if (grid[x][y] != 1) {
                    count++;
                    grid[x][y] = 1;
    
                    for (int j = 0; j < 4; j++) {
                        int newX = x + dx[j];
                        int newY = y + dy[j];
                    
                        if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
                            if (grid[newX][newY] == 1) {
                                Point newPoint = new Point(newX, newY);
                                Point fatherCurr = compressedFind(operators[i]);
                                Point fatherNew = compressedFind(newPoint);
                                if (!fatherCurr.equals(fatherNew)) {
                                    union(fatherCurr, fatherNew);
                                    count--;
                                }
                            }
                        }
                    }
                }
                ans.add(count);
            }
            return ans;
        }
    
        private Point compressedFind(Point p) {
    
            Point parent = father.get(p);
            while (parent != father.get(parent)) {
                parent = father.get(parent);
            }
    
            Point curr = p;
            while (curr != father.get(curr)) {
                Point temp = father.get(curr);
                father.put(curr, parent);
                curr = temp;
            }
    
            return parent;
        }
    
        private void union(Point a, Point b) {
            Point fatherA = compressedFind(a);
            Point fatherB = compressedFind(b);
            if (fatherA != fatherB) {
                father.put(fatherA, fatherB);
            }
        }
    
    
    }