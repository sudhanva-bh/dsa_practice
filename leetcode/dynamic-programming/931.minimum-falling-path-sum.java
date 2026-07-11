/*
 * @lc app=leetcode id=931 lang=java
 *
 * [931] Minimum Falling Path Sum
 */

// @lc code=start
import java.util.*;

class Solution {
    int[][] dp;
    int[][] matrix;

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        if (n == 1)
            return matrix[0][0];

        dp = new int[n][n];
        for (int i = 0; i < n - 1; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[n - 1] = matrix[n - 1];

        this.matrix = matrix;

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            min = Math.min(min, rec(0, i));
            // p(dp);
        }

        return min;
    }

    int rec(int i, int j) {
        if (j < 0 || j >= matrix.length)
            return Integer.MAX_VALUE;

        if (dp[i][j] != Integer.MAX_VALUE)
            return dp[i][j];

        int downLeft = rec(i + 1, j - 1);
        int down = rec(i + 1, j);
        int downRight = rec(i + 1, j + 1);

        int best = Math.min(downLeft, Math.min(down, downRight));

        if (best == Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        return dp[i][j] = matrix[i][j] + best;
    }

    // void p(int[][] m) {
    // for(int[] i : m) {
    // for(int j : i) {
    // if(j == Integer.MAX_VALUE) System.out.print("inf ");
    // else System.out.print(j + " ");
    // }
    // System.out.println();
    // }
    // System.out.println();
    // }
}
// @lc code=end
