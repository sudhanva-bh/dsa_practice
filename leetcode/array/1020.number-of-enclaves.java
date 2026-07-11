/*
 * @lc app=leetcode id=1020 lang=java
 *
 * [1020] Number of Enclaves
 */

// @lc code=start
import java.util.*;

class Solution {
    int m, n;
    int[][] board;

    static final int[] dx = { 0, 1, -1, 0 };
    static final int[] dy = { 1, 0, 0, -1 };

    public int numEnclaves(int[][] board) {
        this.board = board;
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < n; i++) {
            if (board[0][i] == 1)
                dfsVisit(0, i);
            if (board[m - 1][i] == 1)
                dfsVisit(m - 1, i);
        }

        for (int i = 1; i < m - 1; i++) {
            if (board[i][0] == 1)
                dfsVisit(i, 0);
            if (board[i][n - 1] == 1)
                dfsVisit(i, n - 1);
        }

        int count = 0;

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    void dfsVisit(int x, int y) {
        board[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < m && ny < n && board[nx][ny] == 1) {
                dfsVisit(nx, ny);
            }
        }
    }
}
// @lc code=end
