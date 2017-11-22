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
    
        private HashMap<Integer, Integer> father = new HashMap<>();
    
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
                    int id = getId(i, j, m);
                    father.put(id, id);
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
                    int id = getId(x, y, m);
                    count++;
                    grid[x][y] = 1;
    
                    for (int j = 0; j < 4; j++) {
                        int newX = x + dx[j];
                        int newY = y + dy[j];
                        
                    
                        if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
                            if (grid[newX][newY] == 1) {
                                int newId = getId(newX, newY, m);
                                int fatherCurr = compressedFind(id);
                                int fatherNew = compressedFind(newId);
                                if (fatherCurr != fatherNew) {
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
    
        private int compressedFind(int p) {
    
            int parent = father.get(p);
            while (parent != father.get(parent)) {
                parent = father.get(parent);
            }
    
            int curr = p;
            while (curr != father.get(curr)) {
                int temp = father.get(curr);
                father.put(curr, parent);
                curr = temp;
            }
    
            return parent;
        }
    
        private void union(int a, int b) {
            int fatherA = compressedFind(a);
            int fatherB = compressedFind(b);
            if (fatherA != fatherB) {
                father.put(fatherA, fatherB);
            }
        }

        private int getId(int x, int y, int m) {
            return x*m + y;
        }
    
    }