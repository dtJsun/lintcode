/**
 * bfs time limit exceeded :/
 */


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
        int[][] grid = new int[n][m];
        for (int i = 0; i < operators.length; i++) {
            grid[operators[i].x][operators[i].y] = 1;
            ans.add(bfs(grid, n, m));
        }
        return ans;
    }

    private int bfs(int[][] grid, int n, int m) {

        int result = 0;

        int[][] mark = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mark[i][j] = grid[i][j];
            }
        }
        int[] directX = new int[]{0, -1, 0, 1};
        int[] directY = new int[]{-1, 0, 1, 0};

        Queue<Point> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mark[i][j] == 1) {
                    que.offer(new Point(i, j));
                    mark[i][j] = 0;
                    while (!que.isEmpty()) {
                        Point curr = que.poll();
                        for (int k = 0; k < 4; k++) {
                            int newX = curr.x + directX[k];
                            int newY = curr.y + directY[k];
                            if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
                                if (mark[newX][newY] == 1) {
                                    que.offer(new Point(newX, newY));
                                    mark[newX][newY] = 0;
                                }
                            }
                        }
                    }
                    result++;
                }
            }
        }

        return result;
    }

}