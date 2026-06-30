/*
 * @lc app=leetcode id=289 lang=java
 *
 * [289] Game of Life
 */

// @lc code=start
class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        short freq;

        short[][] freqGrid = new short[m][n];

        int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                freq = 0;
                for (int k = 0; k < 8; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];

                    if (nr >= 0 && nr < board.length &&
                            nc >= 0 && nc < board[0].length) {
                        freq += board[nr][nc];
                    }
                }
                freqGrid[i][j] = freq;
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                freq = freqGrid[i][j];
                if(board[i][j] == 1) {
                    if(freq < 2 || freq > 3) board[i][j] = 0;
                } else {
                    if(freq == 3) board[i][j] = 1;
                }
            }
        }
    }
}
// @lc code=end
