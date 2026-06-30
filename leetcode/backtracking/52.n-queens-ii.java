/*
 * @lc app=leetcode id=52 lang=java
 *
 * [52] N-Queens II
 */

// @lc code=start
import java.util.*;

class Solution {
    int[] queens = new int[10];
    int n;

    boolean check(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || Math.abs(row - i) == Math.abs(col - queens[i])) {
                return false;
            }
        }

        return true;
    }

    int recurse(int row) {
        int ans = 0;

        if (row == n)
            return 1;

        for (int col = 0; col < n; col++) {
            if (check(row, col)) {
                queens[row] = col;
                ans += recurse(row + 1);
                queens[row] = -1;
            }
        }

        return ans;
    }

    public int totalNQueens(int n) {
        this.n = n;
        Arrays.fill(queens, -1);

        return recurse(0);
    }
}
// @lc code=end
