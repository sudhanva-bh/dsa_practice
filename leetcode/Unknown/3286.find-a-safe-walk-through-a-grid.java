/*
 * @lc app=leetcode id=3286 lang=java
 *
 * [3286] Find a Safe Walk Through a Grid
 */

// @lc code=start
import java.util.*;

class Solution {

    int[][] grid;
    int m, n;

    byte[][][] dp;

    final static int[] dx = { 0, 1, 0, -1 };
    final static int[] dy = { 1, 0, -1, 0 };

    public boolean findSafeWalk(List<List<Integer>> g, int health) {
        m = g.size();
        n = g.get(0).size();

        grid = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = g.get(i).get(j);
            }
        }

        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;

        dp = new byte[m][n][health + 1];

        return rec(0, 0, health, visited);
    }

    boolean rec(int x, int y, int health, boolean[][] visited) {
        if (grid[x][y] == 1)
            health--;

        if (health < 1)
            return false;

        if (x == m - 1 && y == n - 1) {
            return true;
        }

        if (dp[x][y][health] != 0) {
            return dp[x][y][health] == 1;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isValid(nx, ny) && !visited[nx][ny]) {
                visited[nx][ny] = true;
                if (rec(nx, ny, health, visited)) {
                    dp[x][y][health] = 1;
                    return true;
                }
                visited[nx][ny] = false;
            }
        }

        dp[x][y][health] = 2;
        return false;
    }

    boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}
// @lc code=end
