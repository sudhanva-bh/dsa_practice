/*
 * @lc app=leetcode id=1219 lang=java
 *
 * [1219] Path with Maximum Gold
 */

// @lc code=start
import java.util.*;

class Solution {
    int[][] grid;
    int m, n;

    final static int[] dx = { 0, 1, 0, -1 };
    final static int[] dy = { 1, 0, -1, 0 };

    public int getMaximumGold(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;

        int max = 0;

        int total = 0;
        for(int[] row: grid) {
            for(int cell: row) {
                total += cell;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    boolean[][] visited = new boolean[m][n];
                    visited[i][j] = true;
                    max = Math.max(dfs(i, j, visited), max);
                    if(max == total) return max;
                }
            }
        }

        return max;
    }

    int dfs(int x, int y, boolean[][] visited) {
        int next = 0;

        int nx, ny;

        for(int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];

            if(isValid(nx, ny) && !visited[nx][ny]) {
                visited[nx][ny] = true;
                next = Math.max(next, dfs(nx, ny, visited));
                visited[nx][ny] = false;
            }
        }

        return grid[x][y] + next;
    }

    boolean isValid(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != 0;
    }
}
// @lc code=end
