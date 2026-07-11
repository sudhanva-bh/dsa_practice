/*
 * @lc app=leetcode id=174 lang=java
 *
 * [174] Dungeon Game
 */

// @lc code=start
import java.util.*;

class Solution {
    int[][] hm;
    int[][] dung;
    int m, n;
    int m1, n1;

    int base;

    public int calculateMinimumHP(int[][] dungeon) {
        dung = dungeon;
        m = dungeon.length;
        n = dungeon[0].length;
        m1 = m - 1;
        n1 = n - 1;

        base = 1;
        if(dungeon[m1][n1] < 0) base -= dungeon[m1][n1];

        hm = new int[m][n];

        return rec(0, 0);
    }

    int rec(int i, int j) {
        if(i == m1 && j == n1) {
            return base;
        }

        if(hm[i][j] != 0) {
            return hm[i][j];
        }

        int minHealth = Integer.MAX_VALUE;

        if(i < m1) minHealth = rec(i + 1, j);
        if(j < n1) minHealth = Math.min(minHealth, rec(i, j + 1));

        minHealth -= dung[i][j];
        if(minHealth < 1) minHealth = 1;

        hm[i][j] = minHealth;

        return minHealth;
    }
    // public int calculateMinimumHP(int[][] dungeon) {
    //     int m = dungeon.length, n = dungeon[0].length;

    //     int[][] dp = new int[m + 1][n + 1];

    //     for (int i = 0; i < m; i++) {
    //         dp[i][n] = Integer.MAX_VALUE;
    //     }

    //     for (int j = 0; j < n; j++) {
    //         dp[m][j] = Integer.MAX_VALUE;
    //     }

    //     if(dungeon[m - 1][n - 1] < 0) dp[m - 1][n - 1] = -dungeon[m - 1][n - 1] + 1;
    //     else dp[m - 1][n - 1] = 1;

    //     boolean init = true;

    //     for (int i = m - 1; i >= 0; i--) {
    //         for (int j = n - 1; j >= 0; j--) {
    //             if (init) {
    //                 init = false;
    //                 continue;
    //             }

    //             dp[i][j] = Math.max(Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j], 1);
    //         }
    //     }

    //     return dp[0][0];
    // }
}
// @lc code=end
