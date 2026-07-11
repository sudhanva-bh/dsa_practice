/*
 * @lc app=leetcode id=1765 lang=java
 *
 * [1765] Map of Highest Peak
 */

// @lc code=start
import java.util.*;

class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;

        boolean[][] visited = new boolean[m][n];

        final int[] dx = new int[] { 0, 1, 0, -1 };
        final int[] dy = new int[] { 1, 0, -1, 0 };

        final long MASK = 0xFFFFFFFF;

        Queue<Long> queue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    visited[i][j] = true;
                    queue.add(((long) i << 32) | j);
                }
            }
        }

        int currDist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                long curr = queue.remove();
                int x = (int) (curr >> 32);
                int y = (int) (curr & MASK);

                isWater[x][y] = currDist;

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(((long) nx << 32) | ny);
                    }
                }
            }

            currDist++;
        }

        return isWater;
    }
}
// @lc code=end
