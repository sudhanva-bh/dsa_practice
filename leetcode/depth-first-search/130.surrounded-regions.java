/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 */

// @lc code=start
import java.util.*;

class Solution {
    int m, n;
    char[][] board;
    boolean[][] visited;

    public void solve(char[][] board) {
        this.board = board;
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];

        for(int i = 0; i < n; i++) {
            dfsMarkVisited(0, i);
            dfsMarkVisited(m - 1, i);
        }

        for(int i = 1; i < m - 1; i++) {
            dfsMarkVisited(i, 0);
            dfsMarkVisited(i, n - 1);
        }

        for(int i = 1; i < m - 1; i++) {
            for(int j = 1; j < n - 1; j++) {
                dfsMarkVisitedAndCapture(i, j);
            }
        }
    }

    void dfsMarkVisited(int x, int y) {
        if(x < 0 || y < 0 || x >= m || y >= n || visited[x][y] || board[x][y] == 'X') {
            return;
        }

        visited[x][y] = true;

        dfsMarkVisited(x, y + 1);
        dfsMarkVisited(x + 1, y);
        dfsMarkVisited(x - 1, y);
        dfsMarkVisited(x, y - 1);
    }

    void dfsMarkVisitedAndCapture(int x, int y) {
        if(x < 0 || y < 0 || x >= m || y >= n || visited[x][y] || board[x][y] == 'X') {
            return;
        }

        visited[x][y] = true;
        board[x][y] = 'X';

        dfsMarkVisitedAndCapture(x, y + 1);
        dfsMarkVisitedAndCapture(x + 1, y);
        dfsMarkVisitedAndCapture(x - 1, y);
        dfsMarkVisitedAndCapture(x, y - 1);
    }
}
// @lc code=end

