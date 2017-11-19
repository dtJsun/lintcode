/**
 * 简单来说：

计算当前row 到其他row的距离的和
计算当前col 到其他col的距离的和
判断每一个0的距离，找最小值
计算和的时候：
当前row到目标row的距离的和 = 目标row上1的个数 * 当前row到目标row的距离

col同理
 */
public class Solution {
    /*
     * @param grid: a 2D grid
     * @return: An integer
     */
    public int shortestDistance(int[][] grid) {
        // write your code here

        if (grid.length == 0 || grid[0].length == 0)
            return 0;

        int[] rowCount = new int[grid.length];
        int[] colCount = new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        int[] rowDistance = new int[grid.length];
        int[] colDistance = new int[grid[0].length];

        getDistances(rouCount, grid.length, rowDistances);
        getDistances(colCount, grid[0].length, colDistances);

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    int temp = rowDistances[i] + colDistances[j];
                    ans = Math.min(ans, temp);
                }
            }
        }

        return ans;
    }

    private void getDistances(int[] ary, int size, int[] ans) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                ans[i] += ary[j] * (Math.abs(j - i));
            }
        }
    }
}