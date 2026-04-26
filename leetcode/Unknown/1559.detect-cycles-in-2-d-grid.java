/*
 * @lc app=leetcode id=1559 lang=java
 *
 * [1559] Detect Cycles in 2D Grid
 */

// @lc code=start
import java.util.*;

class Solution {
    class Point {
        int x, y;
        int cx, cy;
        Point(int x, int y, int cx, int cy) {
            this.x = x;
            this.y = y;
            this.cx = cx;
            this.cy = cy;
        }
    }

    public boolean containsCycle(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        Queue<Point> queue = new LinkedList<>();

        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        Point curr;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    queue.add(new Point(i, j, -1, -1));
                    visited[i][j] = true;
                    while(!queue.isEmpty()) {
                        curr = queue.remove();
                        visited[curr.x][curr.y] = true;
                        for(int d = 0; d < 4; d++) {
                            int nx = curr.x + dx[d];
                            int ny = curr.y + dy[d];

                            if(
                                nx >= 0 && ny >= 0 &&
                                nx < m && ny < n &&
                                grid[curr.x][curr.y] == grid[nx][ny]
                            ) {
                                if(visited[nx][ny]) {
                                    if(nx != curr.cx || ny != curr.cy) return true;
                                } else {
                                    visited[nx][ny] = true;
                                    queue.add(new Point(nx, ny, curr.x, curr.y));
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
// @lc code=end

