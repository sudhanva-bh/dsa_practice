/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 */

// @lc code=start
class Solution {
    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};
    char[] ca;
    int m, n, cl;
    char[][] brd;

    private boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }

    private boolean search(int curr, int x, int y) {
        if(curr >= cl - 1) return true;
        
        char temp = brd[x][y];
        brd[x][y] = '#';      

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if(isValid(nx, ny) && brd[nx][ny] == ca[curr + 1]) {
                if(search(curr + 1, nx, ny)) {
                    return true;
                }
            }
        }
        
        brd[x][y] = temp;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        brd = board;
        m = board.length;
        n = board[0].length;
        ca = word.toCharArray();
        cl = ca.length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (brd[i][j] == ca[0] && search(0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }
}
// @lc code=end

