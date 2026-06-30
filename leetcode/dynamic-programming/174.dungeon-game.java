/*
 * @lc app=leetcode id=174 lang=java
 *
 * [174] Dungeon Game
 */

// @lc code=start
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;

        int[][][] dp = new int[m][n][2];

        // dp[i][j] = ___ + ___
        //            min health to reach i, j + min health required to not drop below zero

        int starting = dungeon[0][0];


        for(int i = 0; i < )
    }
}
// @lc code=end

