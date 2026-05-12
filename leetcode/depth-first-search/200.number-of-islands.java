/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
import java.util.*;

class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        if(m == 1 && n == 1) return grid[0][0] - '0';
        
        Queue<int[]> queue = new ArrayDeque<>();
        int[] dx = new int[]{ 0, 1, 0, -1 };
        int[] dy = new int[]{ 1, 0, -1, 0 };

        boolean[][] visited = new boolean[m][n];
        int count = 0;
        int[] curr;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;

                    while(!queue.isEmpty()) {
                        curr = queue.remove();

                        for(int k = 0; k < 4; k++) {
                            int nx = curr[0] + dx[k];
                            int ny = curr[1] + dy[k];

                            if(
                                nx >= 0 && ny >= 0 &&
                                nx < m && ny < n &&
                                grid[nx][ny] == '1' && !visited[nx][ny]
                            ) {
                                visited[nx][ny] = true;
                                queue.add(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}
// @lc code=end

