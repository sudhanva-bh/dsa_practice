/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // rows
        for(int i = 0; i < 9; i++) {
            boolean[] valid = new boolean[9];
            for(int j = 0; j < 9; j++) {
                char c = board[i][j];
                if(c != '.') {if(valid[c - '1']) return false;
                valid[c - '1'] = true;}
            }
        }

        // cols
        for(int i = 0; i < 9; i++) {
            boolean[] valid = new boolean[9];
            for(int j = 0; j < 9; j++) {
                char c = board[j][i];
                if(c != '.') {if(valid[c - '1']) return false;
                valid[c - '1'] = true;}
            }
        }

        for(int i = 0; i < 9; i += 3) {
            for(int j = 0; j < 9; j += 3) {
                boolean[] valid = new boolean[9];
                for(int p = 0; p < 3; p++) {
                    for(int q = 0; q < 3; q++) {
                        char c = board[i + p][j + q];
                        if(c != '.') {if(valid[c - '1']) return false;
                        valid[c - '1'] = true;}
                    }
                }
            }
        }

        return true;
    }
}
// @lc code=end

// [[".",".","4",".",".",".","6","3","."],
//  [".",".",".",".",".",".",".",".","."],
//  ["5",".",".",".",".",".",".","9","."],
//  [".",".",".","5","6",".",".",".","."],
//  ["4",".","3",".",".",".",".",".","1"],
//  [".",".",".","7",".",".",".",".","."],
//  [".",".",".","5",".",".",".",".","."],
//  [".",".",".",".",".",".",".",".","."],
//  [".",".",".",".",".",".",".",".","."]]