/*
 * @lc app=leetcode id=2812 lang=java
 *
 * [2812] Find the Safest Path in a Grid
 */

// @lc code=start
import java.util.*;

class Solution {
    final int MASK = 0b11111111111111111111111111111111;
    final int[] dx = { 0, 1, 0, -1 };
    final int[] dy = { 1, 0, -1, 0 };

    public int maximumSafenessFactor(List<List<Integer>> gridList) {
        int n = gridList.size();

        int[][] grid = new int[n][n];
        Queue<Long> queue = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j] = gridList.get(i).get(j);
                if (grid[i][j] == 1) {
                    queue.add(((long) i << 32) | j);
                }
            }
        }

        int currLevel = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            currLevel++;

            while (size-- > 0) {
                long curr = queue.remove();

                int x = (int) (curr >> 32);
                int y = (int) (curr & MASK);

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < n
                            && grid[nx][ny] == 0) {
                        grid[nx][ny] = currLevel;
                        queue.add(((long) nx << 32) | ny);
                    }
                }
            }
        }

        int high = 2 * n + 1;
        int low = 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (isPossible(grid, mid)) {
                low = mid + 1;
                ans = mid;
            } else {
                high = mid - 1;
            }
        }

        return ans - 1;
    }

    boolean isPossible(int[][] grid, int steps) {
        if(grid[0][0] < steps) return false;
        
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        return dfs(grid, 0, 0, steps, visited);
    }

    boolean dfs(int[][] grid, int x, int y, int steps, boolean[][] visited) {
        int n = grid.length;
        if (x == n - 1 && y == n - 1)
            return true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n
                    && !visited[nx][ny] && grid[nx][ny] >= steps) {
                visited[nx][ny] = true;
                if(dfs(grid, nx, ny, steps, visited)) return true;
            }
        }

        return false;
    }
}
// @lc code=end
