/*
 * @lc app=leetcode id=980 lang=java
 *
 * [980] Unique Paths III
 */

// @lc code=start
import java.util.*;

class Solution {
    final static int[] dx = { 0, 1, 0, -1 };
    final static int[] dy = { 1, 0, -1, 0 };

    int[][] grid;
    int m, n, mn;

    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;

        int free = 0;

        int x = 0, y = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    free++;
                } else if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                }
            }
        }

        grid[x][y] = -1;
        this.mn = free + 2;
        return rec(x, y, 1);
    }

    int rec(int x, int y, int count) {
        int numWays = 0;
        count++;

        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < m && ny < n && grid[nx][ny] != -1) {
                int curr = grid[nx][ny];

                if (curr == 2) {
                    if (count == mn)
                        numWays++;
                } else {
                    grid[nx][ny] = -1;
                    numWays += rec(nx, ny, count);
                    grid[nx][ny] = curr;
                }

            }
        }

        return numWays;
    }
}
// @lc code=end
