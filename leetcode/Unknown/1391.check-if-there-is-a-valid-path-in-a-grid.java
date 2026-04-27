/*
 * @lc app=leetcode id=1391 lang=java
 *
 * [1391] Check if There is a Valid Path in a Grid
 */

// @lc code=start
class Solution {

    int[] dx = { 0, 1, 0, -1 };
    int[] dy = { 1, 0, -1, 0 };

    static final int R = 0, D = 1, L = 2, U = 3;

    int[][] openings = {
            {},
            { L, R },
            { U, D },
            { L, D },
            { R, D },
            { L, U },
            { R, U }
    };

    int getOpposite(int dir) {
        switch (dir) {
            case R:
                return L;
            case L:
                return R;
            case U:
                return D;
            case D:
                return U;
            default:
                return -1;
        }
    }

    public boolean hasValidPath(int[][] grid) {
        if (grid[0][0] == 5)
            return false;

        int m = grid.length, n = grid[0].length;

        if (m == 1 && n == 1)
            return true;

        boolean[][] visited = new boolean[m][n];

        int x = 0, y = 0;
        int nx, ny, curr, opposite;

        while (true) {
            if (x == m - 1 && y == n - 1)
                return true;

            curr = grid[x][y];
            visited[x][y] = true;

            nx = x + dx[openings[curr][0]];
            ny = y + dy[openings[curr][0]];

            opposite = getOpposite(openings[curr][0]);

            if (nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[nx][ny]) {
                if (openings[grid[nx][ny]][0] == opposite || openings[grid[nx][ny]][1] == opposite) {
                    x = nx;
                    y = ny;
                    continue;
                }
            }

            nx = x + dx[openings[curr][1]];
            ny = y + dy[openings[curr][1]];

            opposite = getOpposite(openings[curr][1]);

            if (nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[nx][ny]) {
                if (openings[grid[nx][ny]][0] == opposite || openings[grid[nx][ny]][1] == opposite) {
                    x = nx;
                    y = ny;
                    continue;
                }
            }

            return false;
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] { { 1, 2, 1 }, { 1, 2, 1 } };
        System.out.println("Result: " + new Solution().hasValidPath(grid));
    }
}
// @lc code=end
